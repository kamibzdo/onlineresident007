'use strict';

var shoppingCartControllers = angular.module('shoppingCartControllers' ,['shoppingCartServices']);

shoppingCartControllers.controller('showShoppingCartController',
    ['$scope', 'shoppingCartService','cartManagement', '$location', '$rootScope','$routeParams',
        function ($scope, shoppingCartService, cartManagement, $location, $rootScope,$rootParams)
      {
          $scope.cart={"id":"","selectedProducts":"","purchaseDate":"","totalProductPrice":""}
        if ($rootScope.shoppingCart != null){
             $scope.cart = $rootScope.shoppingCart;
             }else {
             shoppingCartService.get(function (data) {
                 $rootScope.checkOrder = false;
                 $scope.cart = data;
                 })
             }
        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.cartUpdateSuccess = false;

        });


        $scope.updateCart = function (cart) {
            cartManagement.updateCart(cart,function(){
                $rootScope.cartUpdateSuccess = true;

            });
        }
          $scope.saveCart = function(cart){
              cartManagement.saveCart(cart,function(){
                   //success add cart
                       console.log("save cart success");
                   })
               }


          $scope.removeProduct = function(product){
              cartManagement.removeProduct(product,function(newCart){
                   $scope.cart = newCart;
                   })
          }

        $scope.totalEach = function(index){
            return $scope.cart.selectedProducts[index].product.totalPrice * $scope.cart.selectedProducts[index].amount;
        }

        $scope.total = function(){
            var total = 0;
            angular.forEach($scope.cart.selectedProducts, function(item) {
                total += item.amount * item.product.totalPrice;
            });

            return total;
        }
    }]);
shoppingCartControllers.controller('shoppingCartHistoryController',
    ['$scope', 'shoppingCartService','cartManagement', '$location', '$rootScope','$routeParams',
        function ($scope, shoppingCartService, cartManagement, $location, $rootScope,$rootParams) {
            cartManagement.cart(function(data) {
                $scope.carts = data;
            });
            $scope.checkToCart = function(cart){
                    $rootScope.shoppingCart = cart;
                    $rootScope.checkOrder = true;
                    $location.path("shoppingCart");
            }



        }]);

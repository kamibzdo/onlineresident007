'use strict';

var userMainController = angular.module('registerControllers', ['userServices']);

userMainController.controller('addUserController', ['$scope', '$http', '$location', '$rootScope','userService',
    function ($scope, $http, $location, $rootScope,userService) {
        $scope.user = {};
        $scope.addUser = function () {

            //$http.post("/product", $scope.product).success(function () {
            userService.save($scope.user,function(){
                $location.path("home");

            });
        };



    }]);
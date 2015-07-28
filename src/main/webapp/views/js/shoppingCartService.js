'use strict'
var shoppingCartServices = angular.module('shoppingCartServices',['ngResource']);
shoppingCartServices.factory('shoppingCartService',function($resource){
    return $resource('/shoppingcart/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})
shoppingCartServices.factory('cartManagement',function($resource) {
    return $resource('/shoppingcart/:action', {}, {
            addToCart: {
                method: 'POST',
                params: {'action': 'addToCart'}

            },
            updateCart: {
                method: 'POST',
                params: {'action': 'updateCart'}

            },

            removeProduct: {
                method: 'POST',
                params: {'action': 'removeProduct'}
            },
            saveCart: {
                method: 'POST',
                params: {'action': 'saveCart'}
            },
            emptyCart:{
            method: 'POST',
            params: {'action': 'emptyCart'}
            },
            cart:{
                method: 'GET',
                params: {'action': 'historyCart'}
                ,isArray:true
            }
        }
    )
})

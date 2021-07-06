angular.module('app').controller('productInfoController', function ($scope, $http, $localStorage, $routeParams) {
    const contextPath = 'http://localhost:8189/market';

    $scope.loadProduct = function () {
        $http({
            url: contextPath + '/api/v1/products/' + $routeParams.productIdParam,
            method: 'GET'
        }).then(function (response) {
            $scope.prod = response.data;
        });
    };

    $scope.loadComments = function () {
        $http({
            url: contextPath + '/api/v1/comments',
            method: 'GET',
            params: {
                productId : $routeParams.productIdParam
            }
        }).then(function (response) {
            $scope.comments = response.data;
        });
    };

    $scope.share = function () {
        $http({
            url: contextPath + '/api/v1/comments',
            method: 'POST',
            params: {
                productId : $routeParams.productIdParam,
                comment: $scope.comment
            }
        }).then(function (response) {
            $scope.comment = '';
        });
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.aprilMarketCurrentUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.loadProduct();
    $scope.loadComments();
});
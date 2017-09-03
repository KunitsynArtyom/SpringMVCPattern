var modul = angular.module("Books", []);

modul.controller("BookController", ['$scope', '$http', function ($scope, $http) {
    var _this = this;

    $scope.fetchBookList = function () {
        $http.get('all').success(function (bookList) {
            $scope.books = bookList;
        });
    };

    $scope.fetchBookList();

}]);

modul.directive("bookList", function () {
    return {
        templateUrl: "books/layout.html"
    }
});

angular.module("Books", [])
    .controller("BookController", ['$scope', '$http', function ($scope, $http) {
    var _this = this;

    $scope.fetchBookList = function () {
        $http.get('all').success(function (bookList) {
            $scope.books = bookList;
        });
    };

    $scope.fetchBookList();

}]);

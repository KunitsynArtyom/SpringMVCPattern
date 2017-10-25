var demo = angular.module('app');

demo.controller("TableController",

    function TableController($scope, BookFetcher, BookUpdater) {

        function onBookFetchSuccess(result) {
            $scope.books = result.data;
            $scope.selected = {}
        }

        $scope.refresh = function () {
            BookFetcher.receive(
                onBookFetchSuccess,
                function(response) {console.log(response)}
            );
        };

        $scope.refresh();

        $scope.getTemplate = function (book) {
            if (book.id === $scope.selected.id) return 'edit';
            else return 'display';
        };

        $scope.editBook = function (book) {
            $scope.selected = angular.copy(book);
        };

        $scope.saveBook = function (idx) {
            $scope.books[idx] = angular.copy($scope.selected);
            console.log("Saving book");
            BookUpdater.update(
                function() {},
                function() {},
                $scope.selected
            );
             $scope.reset();
        };

        $scope.reset = function () {
            $scope.selected = {};
        };
    });
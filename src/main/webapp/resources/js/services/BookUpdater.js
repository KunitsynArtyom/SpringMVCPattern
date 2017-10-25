angular.module('Books')
    .factory('BookUpdater', [
        '$http',
        function($http) {

            function BookUpdater() {

            }

            function update(callbackSuccess, callbackReject, book) {
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/books/update',
                    contentType: 'application/json',
                    data : JSON.stringify(book)
                }).then(
                    callbackSuccess,
                    callbackReject
                );
            }

            BookUpdater.prototype.update = update;

            return new BookUpdater();
        }
    ]);
angular.module('Books')
    .factory('BookFetcher', [
        '$http',
        function($http) {

            function BookFetcher() {

            }

            function receive(callbackSuccess, callbackReject) {
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/books/all',
                    contentType: 'application/json',
                }).then(
                    callbackSuccess,
                    callbackReject
                );
            }

            BookFetcher.prototype.receive = receive;

            return new BookFetcher();
        }
    ]);
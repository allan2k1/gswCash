'use strict';

angular.module('GswApplication').factory('ClientService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllClients: loadAllClients,
                getAllClients: getAllClients,
                createClient: createClient,
                updateClient: updateClient,
                removeClient: removeClient
            };

            return factory;

            function loadAllClients() {
                console.log('Fetching all clients');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all clients');
                            $localStorage.clients = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading clients');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllClients(){
                return $localStorage.clients;
            }

            function getClient(id) {
                console.log('Fetching Client with id: ' + id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Client with id: ' + id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Client with id: ' + id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createClient(client) {
                console.log('Creating Client');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, client)
                    .then(
                        function (response) {
                            loadAllClients();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Client: ' + errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateClient(client) {
                console.log('Updating Client');
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API, client)
                    .then(
                        function (response) {
                            loadAllClients();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Client with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeClient(id) {
                console.log('Removing Client with id '+ id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllClients();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Client with id :' + id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);
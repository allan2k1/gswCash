var app = angular.module('gswApplication',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/'
    USER_SERVICE_API : 'http://localhost:8080/client'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'client',
                controller:'ClientController',
                controllerAs:'ctrl',
                resolve: {
                	clients: function ($q, ClientService) {
                        console.log('Load all clients');
                        var deferred = $q.defer();
                        ClientService.loadAllClients().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);


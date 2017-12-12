'use strict';

angular.module('GswApplication').controller('ClientController',
    ['ClientService', '$scope',  function( ClientService, $scope) {

        var self = this;
        self.client = {};
        self.clients = [];

        self.submit = submit;
        self.getAllClients = getAllClients;
        self.createClient = createClient;
        self.updateClient = updateClient;
        self.removeClient = removeClient;
        self.editClient = editClient;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.client.id === undefined || self.client.id === null) {
                console.log('Saving New client', self.client);
                createClient(self.client);
            } else {
                updateClient(self.client);
                console.log('Client updated with id ', self.client.id);
            }
        }

        function createClient(client) {
            console.log('About to create client');
            ClientService.createClient(client)
                .then(
                    function (response) {
                        console.log('Client created successfully');
                        self.successMessage = 'Client created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.client={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating client');
                        self.errorMessage = 'Error while creating client: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateClient(client){
            console.log('About to update client');
            ClientService.updateClient(client)
                .then(
                    function (response){
                        console.log('Client updated successfully');
                        self.successMessage='Client updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating client');
                        self.errorMessage='Error while updating client '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeClient(id){
            console.log('About to remove client with id '+id);
            ClientService.removeClient(id)
                .then(
                    function(){
                        console.log('Client '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing client '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllClients(){
            return ClientService.getAllClients();
        }

        function editClient(id) {
            self.successMessage='';
            self.errorMessage='';
            ClientService.getClient(id).then(
                function (client) {
                    self.client = client;
                },
                function (errResponse) {
                    console.error('Error while removing client ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.client={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }

    ]);
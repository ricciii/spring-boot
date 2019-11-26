'use strict'

var app = angular.module('app');

app.controller('EditContactsController', ['$scope', 'personService', 'contactTypeService', '$window','$routeParams' , function ($scope, personService, contactTypeService,$window, $routeParams) {

    $scope.addContact = function(contact) {
      personService.addContact($scope.person.id, contact)
        .then(function success(response) {
          $scope.person = response.data;
          $scope.contacts = $scope.person.contacts;
        }, function error(response) {

        });
    }

    $scope.removeContact = function(index) {
      var contact = $scope.contacts[index];
      personService.removeContact($scope.person.id, contact)
        .then(function success(response) {
          $scope.person = response.data;
          $scope.contacts = $scope.person.contacts;
        }, function error(response) {  
        });
    }

    $scope.initPersonInfo = function() {
      $window.location.href = '#!persons/' + $scope.person.id;
    }

    $scope.loadContactTypes = function() {
      contactTypeService.getAllContactTypes()
        .then(function success(response) {
          $scope.types = response.data;
        },
        function error(response) {

        });
    }

    $scope.loadContactTypes();

    $scope.loadPerson = function(personId) {
      personService.getPerson(personId)
        .then(function success(response) {
          $scope.person = response.data;
          $scope.contacts = $scope.person.contacts;
        },
        function error(response) {

        });
    }

    $scope.loadPerson($routeParams.personId);
}]);
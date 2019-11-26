'use strict'

var app = angular.module('app');

app.controller('CreatePersonController', ['$scope', 'personService', '$window', function ($scope, personService, $window) {
    
    $scope.addPerson = function(person) {
      personService.addPerson(person)
        .then(function success(response) {
          $scope.person = response.data;
          $window.location.href = '#!persons/' + $scope.person.id;
        }, function error(response) {

        });
    }

    $scope.loadPerson = function(personId) {
      personService.getPerson(personId)
        .then(function success(response) {
          $person = response.data;
        },
        function error(response) {

        })
    }

    $scope.loadPerson();

}]);
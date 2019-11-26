'use strict'

var app = angular.module('app');

app.controller('UpdatePersonController', ['$scope', 'personService', '$window','$routeParams' , function ($scope, personService, $window, $routeParams) {

    $scope.updatePerson = function() {
      personService.updatePerson($scope.person)
        .then( function success(response) {
          $window.location.href = '#!persons/' + $scope.person.id;
        }, function error(response) {

        });
    }

    $scope.loadPerson = function(personId) {
      personService.getPerson(personId)
        .then(function success(response) {
          $scope.person = response.data;
        },
        function error(response) {

        });
    }

    $scope.loadPerson($routeParams.personId);
}]);
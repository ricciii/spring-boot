'use strict'

var app = angular.module('app');

app.controller('ListPersonController', ['$scope', 'personService', '$window', function ($scope, personService, $window) {

    $scope.getAllPersons = function() {
      personService.getAllPersons()
        .then(function success(response) {
          $scope.persons = response.data;
        }, function error(response) {

        });
    }

    $scope.viewPerson = function(index) {
      var personId = $scope.persons[index].id;
      $window.location.href = '#!persons/' + personId;
    }

    $scope.loadPersonsList = function() {
      $scope.getAllPersons();
      $scope.orderByOption = "name.lastName";
    }

    $scope.loadPersonsList();
}]);
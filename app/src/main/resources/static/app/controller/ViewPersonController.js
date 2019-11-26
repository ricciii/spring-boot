'use strict'

var app = angular.module('app');

app.controller('ViewPersonController', ['$scope', 'personService', '$window', '$routeParams' ,function ($scope, personService, $window, $routeParams) {

  $scope.initUpdatePerson = function() {
    $window.location.href = '#!persons/' + $scope.person.id + '/update';
  }

  $scope.initEditRoles = function() {
    $window.location.href = '#!persons/' + $scope.person.id + '/edit-roles';
  }

  $scope.initEditContacts = function() {
    $window.location.href = '#!persons/' + $scope.person.id + '/edit-contacts';
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
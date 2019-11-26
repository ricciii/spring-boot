'use strict'

var app = angular.module('app');

app.controller('EditRolesController', ['$scope', 'personService', 'roleService', '$window','$routeParams' , function ($scope, personService, roleService,$window, $routeParams) {

    $scope.assignRole = function(selectedRole) {
      var roleId = selectedRole.id;
      var roleName = selectedRole.name;
      personService.assignRole($scope.person.id, roleId, roleName)
        .then(function success(response) {
          $scope.person = response.data;
          $scope.assignments = $scope.person.roles;
        }, function error(response) {

        });
    }

    $scope.removeRole = function(index) {
      var roleId = $scope.assignments[index].id;
      var roleName = $scope.assignments[index].name;
      personService.removeRole($scope.person.id, roleId, roleName)
        .then(function success(response) {
          $scope.person = response.data;
          $scope.assignments = $scope.person.roles;
        }, function error(response) {

        });
    }

    $scope.initPersonInfo = function() {
      $window.location.href = '#!persons/' + $scope.person.id;
    }

    $scope.loadRoles = function() {
      roleService.getAllRoles()
        .then(function success(response) {
          $scope.roles = response.data;
        },
        function error(response) {

        });
    }

    $scope.loadRoles();

    $scope.loadPerson = function(personId) {
      personService.getPerson(personId)
        .then(function success(response) {
          $scope.person = response.data;
          $scope.assignments = $scope.person.roles;
        },
        function error(response) {

        });
    }

    $scope.loadPerson($routeParams.personId);
}]);
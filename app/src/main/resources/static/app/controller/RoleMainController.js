'use strict'

var app = angular.module('app');

app.controller('RoleMainController', ['$scope', 'roleService', function ($scope, roleService) {
	  
    $scope.updateRole = function () {
        roleService.updateRole($scope.role.id, $scope.role.name)
          .then(function success(response){
              $scope.message = 'Role data has been updated!';
              $scope.errorMessage = '';
              $scope.role = null;
              $scope.initPage();
          },
          function error(response){
              $scope.errorMessage = 'Error updating role!';
              $scope.message = '';
          });
    }

    $scope.initUpdate = function(index) {
      var roleId = $scope.roles[index].id;
      roleService.getRole(roleId).
        then(function success(response) {
          $scope.role = response.data;
          $scope.showCreateForm = false;
          $scope.showUpdateForm = true;
        }, function error(response) {

        });
    }
    
    $scope.getAllRoles = function () {
      roleService.getAllRoles()
      .then(function success(response){
        $scope.roles = response.data;
      },
      function error (response){
        $scope.message='';
        $scope.errorMessage = 'Error getting roles!';
      });
    }

    $scope.initPage = function() {
      $scope.role = null;
      $scope.getAllRoles();
      $scope.showCreateForm = true;
      $scope.showUpdateForm = false;
    }

    $scope.initPage();

    $scope.addRole = function () {
        if ($scope.role.name!=null) {
            roleService.addRole($scope.role.name)
              .then (function success(response){
                  $scope.errorMessage = '';
                  $scope.showError = false;
                  $scope.message = 'Role ' + name + ' has been added!';
                  $scope.showSuccess = true;
                  $scope.initPage();
              },
              function error(response){
                  $scope.message = '';
                  $scope.showSuccess = false;
                  $scope.errorMessage = 'Error adding role!';
                  $scope.showError = true;
            });
        }
        else {
            $scope.errorMessage = 'Please enter a name!';
            $scope.message = '';
        }
    }

    $scope.deleteRole = function (index) {
        var roleId = $scope.roles[index].id;
        roleService.deleteRole(roleId)
          .then (function success(response){
              $scope.message = 'Role with ID:' + roleId + ' has been deleted!';
              $scope.initPage();
              $scope.errorMessage='';
          },
          function error(response){
              $scope.errorMessage = 'Error deleting role!';
              $scope.message='';
          });
    }

    $scope.generateRolesReport = function() {
      roleService.generateRolesReport($scope.roles)
        .then( function success(response) {

        }, function error(response) {

        });
    }
}]);
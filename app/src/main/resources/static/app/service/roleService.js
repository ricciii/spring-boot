'use strict'

var app = angular.module('app');

app.service('roleService',['$http', '$location', function ($http) {

	this.getAllRoles = function getAllRoles(){
        return $http({
          method: 'GET',
          url: 'api/roles'
        });
    }

  this.addRole = function addRole(name){
      return $http({
        method: 'POST',
        url: 'api/roles',
        data: {name:name}
      });
  }

  this.deleteRole = function deleteRole(roleId){
      return $http({
        method: 'DELETE',
        url: 'api/roles/' + roleId
      });
  }

  this.updateRole = function updateRole(roleId, name){
      return $http({
        method: 'PATCH',
        url: 'api/roles/' + roleId,
        data: {name:name}
      });
  }

  this.getRole = function getRole(roleId){
      return $http({
        method: 'GET',
        url: 'api/roles/' + roleId
      });
  }

  this.generateRolesReport = function(roles) {
      return $http({
        method: 'GET',
        url: 'api/roles/pdf'
      });
  }

}]);
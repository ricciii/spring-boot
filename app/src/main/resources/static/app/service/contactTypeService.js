'use strict'

var app = angular.module('app');

app.service('contactTypeService',['$http', '$location', function ($http) {

	this.getAllContactTypes = function(){
        return $http({
          method: 'GET',
          url: 'api/contact-types'
        });
    }

}]);
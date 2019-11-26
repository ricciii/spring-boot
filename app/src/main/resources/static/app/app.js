'use strict'

var app = angular.module('app', ['ngRoute']);
app.config(['$routeProvider','$locationProvider', function($routeProvider, $locationProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "templates/home.html"
    })
    .when("/roles", {
        templateUrl : "templates/roles/roles.html",
        controller : "RoleMainController"
    })
    .when("/persons", {
        templateUrl : "templates/persons/persons-list.html",
        controller : "ListPersonController"
    })
    .when("/persons/new", {
        templateUrl : "templates/persons/add-person-form.html",
        controller : "CreatePersonController"
    })
    .when("/persons/:personId", {
        templateUrl : "templates/persons/person-information.html",
        controller : "ViewPersonController"
    })
    .when("/persons/:personId/update", {
        templateUrl : "templates/persons/update-person-form.html",
        controller : "UpdatePersonController"
    })
    .when("/persons/:personId/edit-roles", {
        templateUrl : "templates/persons/edit-roles.html",
        controller : "EditRolesController"
    })
    .when("/persons/:personId/edit-contacts", {
        templateUrl : "templates/persons/edit-contacts.html",
        controller : "EditContactsController"
    })
    .otherwise({
        templateUrl : "templates/error.html"
    });
}]);
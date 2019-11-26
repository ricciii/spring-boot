'use strict'

var app = angular.module('app');

app.service('personService',['$http', '$location', function ($http) {

  this.getAllPersons = function() {
        return $http({
          method: 'GET',
          url: 'api/persons'
        });
    }

  this.addPerson = function(person) {
    
    return $http({
      method: 'POST',
      url: 'api/persons',
      data: { name:person.name, 
              address:person.address,
              dateOfBirth:person.dateOfBirth,
              gwa:person.gwa,
              dateHired:person.dateHired,
              currentlyEmployed:person.currentlyEmployed
            }
    });
  }

  this.getPerson = function getPerson(personId){
      return $http({
        method: 'GET',
        url: 'api/persons/' + personId
      });
  }

  this.deletePerson = function deletePerson(personId){
      return $http({
        method: 'DELETE',
        url: 'api/persons/' + personId
      });
  }

  this.updatePerson = function(person) {
    return $http({
      method: 'PUT',
      url: 'api/persons/' + person.id,
      data: { name:person.name, 
              address:person.address,
              dateOfBirth:person.dateOfBirth,
              gwa:person.gwa,
              dateHired:person.dateHired,
              currentlyEmployed:person.currentlyEmployed
            }
    });
  }

  this.assignRole = function(personId, roleId, roleName) {
    return $http({
      method: 'PUT',
      url: 'api/persons/' + personId + '/assign-role',
      data: { id:roleId, 
              name:roleName
      }
    });
  }

  this.removeRole = function(personId, roleId, roleName) {
    return $http({
      method: 'PUT',
      url: 'api/persons/' + personId + '/remove-role',
      data: { id:roleId, 
              name:roleName
      }
    });
  }

  this.addContact = function(personId, contact) {
    return $http({
      method: 'PUT',
      url: 'api/persons/' + personId + '/add-contact',
      data: { type:contact.type,
              info:contact.info
      }
    });
  }

  this.removeContact = function(personId, contact) {
    return $http({
      method: 'PUT',
      url: 'api/persons/' + personId + '/remove-contact',
      data: { id:contact.id, 
              type:contact.type,
              info:contact.info
      }
    });
  }

}]);
'use strict';

angular.module('RecoApp')
  .controller('NavbarCtrl', function ($scope, $http, $location) {
    $scope.isCollapsed = true;
    
    $scope.isActive = function(route) {
        return '/main/' + route === $location.path();
    };
    
    $scope.items = [
    	{label:"getOffers", link:"main"},
    	{label:"getResults", link:"getResults"},
    	{label:"precalculOffre", link:"precalculOffre"},
    	{label:"validateOffre", link:"validateOffre"}
    ];;
    
    //////////////////////////////////////////////


  });
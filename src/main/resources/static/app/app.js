'use strict';

angular.module('RecoApp', [
  'ngCookies',
  'ngResource',
  'ui.router',
  'ui.bootstrap'
])
  .config(function ($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {
	  
		$urlRouterProvider.otherwise('/');
		
		$httpProvider.defaults.headers.get = [
  			{ 'Access-Control-Allow-Origin' : '*' },
  			{ 'Access-Control-Allow-Origin' : 'http://127.0.0.1:8090/RECO' }
  			
  			
  		]
		
		$locationProvider.html5Mode(true);
  });

angular.module('RecoApp').run(function($rootScope, $templateCache) {
   $rootScope.$on('$viewContentLoaded', function() {
      $templateCache.removeAll();
   });
});
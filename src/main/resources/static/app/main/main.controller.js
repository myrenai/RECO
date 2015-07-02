'use strict';

angular.module('RecoApp')
  .controller('MainCtrl', function ($scope, $http, $location, $sce) {

	  
	var jsonData = JSON.stringify({"context":[{"name":"CTX_PERIMETRE","value":"RESILIATION","dataType":"string"},{"name":"ctx_page","value":"shop","dataType":"string"},{"name":"lang_pref","value":"FR","dataType":"string"}],"profil":[{"name":"age","value":"","dataType":"numeric"},{"name":"best_calling_time","value":"","dataType":"string"},{"name":"birth_dt","value":"","dataType":"datetime"},{"name":"created_dt","value":"03/17/2015 09:41:48","dataType":"datetime"},{"name":"currency_pref","value":"GBP","dataType":"string"},{"name":"customer_status","value":"","dataType":"string"},{"name":"customer_type","value":"","dataType":"string"},{"name":"audienceID_customerid","value":"114.0","dataType":"numeric"},{"name":"email","value":"mbinigue@capgemini.com","dataType":"string"},{"name":"email_opt_in_ind","value":"","dataType":"string"},{"name":"enable_geoloc","value":"","dataType":"string"},{"name":"first_name","value":"marine","dataType":"string"},{"name":"gender","value":"F","dataType":"string"},{"name":"geoloc_x_desc","value":"48.1366618","dataType":"numeric"},{"name":"geoloc_y_desc","value":"-1.6222836","dataType":"numeric"},{"name":"in_store_date","value":"03/17/2015 09:43:59","dataType":"datetime"},{"name":"last_name","value":"BINIGUER-MOIZAN","dataType":"string"},{"name":"norm_mobile_phone","value":"","dataType":"string"},{"name":"number_of_children","value":"","dataType":"numeric"},{"name":"preferred_contact_channel","value":"","dataType":"string"},{"name":"salutation","value":"Mme","dataType":"string"},{"name":"sms_opt_in_ind","value":"","dataType":"string"},{"name":"uaciinteractivechannelid","value":"1.0","dataType":"numeric"},{"name":"interactiveChanel","value":"Mobile_app","dataType":"string"},{"name":"uacisessionid","value":"1234","dataType":"string"},{"name":"xid","value":"55000f948a99c643b7232e1c","dataType":"string"}]});
  	$scope.jsonEntryData = "Entrer les donnees de context et profil ici.";
  	$scope.jsonEntryData = {}
  	$scope.data = {};
  	$scope.trustAsHtml = $sce.trustAsHtml;
  	$scope.sendPost = function () {
  		
		$http.post('http://127.0.0.1:8090/RECO/V0/Offers/next', jsonData).
		success(function(data, status, headers, config) {
	  	    console.log("success");
	  	    $scope.data = data;
		}).
		error(function(data, status, headers, config) {
			console.log("fail");
			$scope.data = data;
		});

	}
});
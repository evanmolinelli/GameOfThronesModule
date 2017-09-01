var app = angular.module("homePage", [ "ngRoute" ]); // initializes the angular
// app
app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix(""); // don't use !# in the URL
	$routeProvider.when("/createHouse", {
		templateUrl : "newHouse.html",
		controller : "createHouseCtrl"
	}).when("/createCharacter", {
		templateUrl : "newCharacter.html",
		controller : "createCharacterCtrl"
	}).when("/viewHouse", {
		templateUrl : "allHouse.html",
		controller : "viewAllHouseCtrl"
	}).when("/pickSigil", {
		templateUrl : "NewSigil.html",
//		controller : "newSigilCtrl"
	}).otherwise({
		templateUrl: "default.html"
	});
});

/*app.controller("viewAllReimbCtrl", function($scope, $http) {
	$http({
		method : "post",
		url : "allReimb.do"
	}).then(function(response) {
		if (response.status == 200) {
			$scope.reimbursements = response.data; 
			
		} else {
			console.log("No user logged in.");
		}
	});
});
*/
angular.module("homePage")
.controller("createHouseCtrl", function($http, $scope) {
	$scope.createHouse = function() {
		$http.post("http://localhost:8080/home/house/create",
				$scope.house).then(function(value) {
			window.alert("House Added!");
		});
	}
});
angular.module("homePage")
.controller("createCharacterCtrl", function($http, $scope) {
	$scope.createCharacter = function() {
		$http.post("http://localhost:8080/home/character/create",
				$scope.character).then(function(value) {
			window.alert("Character Added!");
		});
	}
});
angular.module("homePage")
.controller("viewAllHouseCtrl", function($http, $scope) {
	// make a HTTP call to /game/all, get the JSON data from the
	// HTTP response parameter, then store the JSON object
	// in the $scope service
	$http.get("http://localhost:8080/home/house/all")
	.then(function(response) {
		$scope.allHouse = response.data;
	});
});


/*function checkTextField(field) {
	 if(document.getElementById('createAmt').value === "" || document.getElementById('createDescr').value === "")
	 { window.alert("Must be valid reimbursement.");
	 	return false; }
	 else
		 {console.log("good to go.")
		 	return true;}
	}*/
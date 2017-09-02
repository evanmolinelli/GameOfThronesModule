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
		templateUrl : "allHouses.html",
		controller : "viewAllHouseCtrl"
	}).when("/pickSigil", {
		templateUrl : "NewSigil.html",
//		controller : "newSigilCtrl"
	}).otherwise({
		templateUrl: "default.html"
	});
});

//angular.module("homePage")
//.controller("newSigilCtrl", function($scope) {
//	$scope.slide = function (dir) {
//	    $('.carousel').carousel(dir);
//	};
//});

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
	$http({
		method : "get",
		url : "http://localhost:8080/ManyFacedProject/location/all"
	}).then(function(response) {
		if (response.status == 200) {
			$scope.locations = response.data; 
		}
	});
	
	$scope.createHouse = function() {
		console.log($scope.house);
		console.log("loaded");
		$http.post("http://localhost:8080/ManyFacedProject/house/create",
				$scope.house).then(function(value) {
			window.alert("House Added!");
		});
	}
});

//angular.module("homePage")
//.controller("createHouseCtrl", function($scope, $http) {
//	$scope.addHouse = function(){
//		console.log($scope.newHouse);
//		// data: request body 
//		$http({
//			method: "POST", url: "create.do", data: $scope.newHouse 
//		}).then(function(response) {
//			console.log(response.status);
//		});
//	}
//});

angular.module("homePage")
.controller("createCharacterCtrl", function($http, $scope) {
	$http({
		method : "get",
		url : "http://localhost:8080/ManyFacedProject/house/all"
	}).then(function(response) {
		if (response.status == 200) {
			$scope.houses = response.data; 
		}
	});

	$http({
		method : "get",
		url : "http://localhost:8080/ManyFacedProject/status/all"
	}).then(function(response) {
		if (response.status == 200) {
			$scope.status = response.data; 
		}
	});
	
	$http({
		method : "get",
		url : "http://localhost:8080/ManyFacedProject/weapons/all"
	}).then(function(response) {
		if (response.status == 200) {
			$scope.weapon = response.data; 
		}
	});
		
	$scope.addCharacter = function(houses) {
		
		$http.post("http://localhost:8080/ManyFacedProject/character/create",
				$scope.newCharacter).then(function(value) {
			window.alert("Character Added!");
		});
	}
});

/*angular.module("homePage")
.controller("houseInCharacter", function($http, $scope) {
	$scope.houses = function() {
		$http.get("http://localhost:8080/ManyFacedProject/house/all")
		.then(function(response) {
			console.log(response.data);
		});
	}
});*/

angular.module("homePage")
.controller("viewAllHouseCtrl", function($http, $scope) {
	// make a HTTP call to /game/all, get the JSON data from the
	// HTTP response parameter, then store the JSON object
	// in the $scope service
	$http.get("http://localhost:8080/ManyFacedProject/house/all")
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
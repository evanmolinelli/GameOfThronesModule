var app = angular.module("homePage", [ "ngRoute"]); // initializes the
														// angular
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
	 controller : "createSigilCtrl"
	}).when("/viewCharacter", {
		templateUrl : "allCharacters.html",
		 controller : "viewCharactersCtrl"
		}).otherwise({
		templateUrl : "default.html"
	});
});


angular.module("homePage").controller(
		"createHouseCtrl",
		function($http, $scope) {
			$http({
				method : "get",
				url : "http://localhost:8080/ManyFacedProject/location/all"
			}).then(function(response) {
				if (response.status == 200) {
					$scope.locations = response.data;
				}
			});
			
			$http({
				method : "get",
				url : "http://localhost:8080/ManyFacedProject/sigil/all"
			}).then(function(response) {
				if (response.status == 200) {
					$scope.sigils = response.data;
				}
			});

			$scope.createHouse = function() {
				console.log($scope.house);
				console.log("loaded");
				$http.post(
						"http://localhost:8080/ManyFacedProject/house/create",
						$scope.house).then(function(value) {
					window.alert("House Added!");
				});
			}
		});

 angular.module("homePage").controller("createSigilCtrl",
		function($scope, $http) {
			$scope.addSigil = function() {
				console.log($scope.newSigil);
				// data: request body
				$http({
					method : "POST",
					url : "http://localhost:8080/ManyFacedProject/sigil/create",
					data : $scope.newSigil
				}).then(function(response) {
					console.log(response.status);
				});
			}
		});

angular
		.module("homePage")
		.controller(
				"createCharacterCtrl",
				function($http, $scope) {
					$http(
							{
								method : "get",
								url : "http://localhost:8080/ManyFacedProject/house/all"
							}).then(function(response) {
						if (response.status == 200) {
							$scope.houses = response.data;
						}
					});

					$http(
							{
								method : "get",
								url : "http://localhost:8080/ManyFacedProject/status/all"
							}).then(function(response) {
						if (response.status == 200) {
							$scope.status = response.data;
						}
					});

					$http(
							{
								method : "get",
								url : "http://localhost:8080/ManyFacedProject/weapons/all"
							}).then(function(response) {
						if (response.status == 200) {
							$scope.weapon = response.data;
						}
					});

					$scope.addCharacter = function(houses) {

						$http
								.post(
										"http://localhost:8080/ManyFacedProject/character/create",
										$scope.newCharacter).then(
										function(value) {
											window.alert("Character Added!");
										});
					}
				});


angular.module("homePage").controller(
		"viewAllHouseCtrl",
		function($http, $scope) {
			// make a HTTP call to /game/all, get the JSON data from the
			// HTTP response parameter, then store the JSON object
			// in the $scope service
			$http.get("http://localhost:8080/ManyFacedProject/house/all").then(
					function(response) {
						$scope.allHouse = response.data;
						$scope.poop = '';
					$scope.myModal = function(house){
						$scope.poop = house;
					}
					});
			

		});

angular.module("homePage").controller(
		"viewCharactersCtrl",
		function($http, $scope) {

			$scope.show = true;
			$http.get("http://localhost:8080/ManyFacedProject/house/all").then(
					function(response) {
						$scope.houses = response.data;
					});
					$scope.displayChar = function() {
//						console.log($scope.id);
						var url1 = "http://localhost:8080/ManyFacedProject/charactersInHouse/";
						var url2 = url1.concat($scope.id); // ,
																// {params:{"id":
																// 50}}
						$http.get(url2).then(function(response) {
							$scope.characters = response.data;
						});
					}

		});
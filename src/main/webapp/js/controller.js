app.controller("studentController", function($scope, $http) {
	
	$scope.addStudent = function() {
		var dataObject = {
			/*"stuNo" : $scope.stuNo,
			"firstName" : $scope.fName,
			"lastName" : $scope.lName,
			"gender" : $scope.gender,
			"age" : $scope.age,
			"address" : $scope.address,
			"email" : $scope.email*/
				
				"stuNo" : "seu1",
				"firstName" : "harshana",
				"lastName" : "madusanka",
				"gender" : "male",
				"age" : $scope.age,
				"address" : "dorawaka",
				"email" : "harshanaj@wso2.com"
		}
	
		dataObject.age = $scope.age;
		$http.post("http://localhost:8080/student-app/api/student",dataObject).then(
			function() {
				alert("sucessfully added");
			} , 
			function() {
				alert(dataObject.age);
			}
		);
	}
});
app.controller("studentController", function($scope, $http) {
	
	$scope.addStudent = function() {
		var dataObject = {
			"stuNo" : $scope.stuNo,
			"firstName" : $scope.fName,
			"lastName" : $scope.lName,
			"gender" : $scope.gender,
			"age" : $scope.age,
			"address" : $scope.address,
			"email" : $scope.email			
		}
	
		$http.post("http://localhost:8080/student-app/api/student",dataObject).then(
			function() {
				alert("sucessfully added");
			} , 
			function() {
				alert("something went wrong");
			}
		);
	}
});
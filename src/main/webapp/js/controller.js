app.controller("studentController", function($scope, $http) {
	
	$scope.getAllStudents = function() {
		$http.get("http://localhost:8080/student-app/api/student").then(
				function(response){
					$scope.students = response.data;
				}
				
		);
	}
	
	$scope.getAllStudents();
	
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
				$scope.getAllStudents();
				$scope.reset();
			} , 
			function() {
				alert("something went wrong");
			}
		);
	}

	$scope.findStudent = function() {
		
		$http.get("http://localhost:8080/student-app/api/student/" + $scope.search).then(
			function(response) {
				$scope.student =  response.data;	
				
				$scope.stuNo = $scope.student.stuNo;
				$scope.fName = $scope.student.firstName;
				$scope.lName = $scope.student.lastName;
				$scope.gender = $scope.student.gender;
				$scope.age = $scope.student.age;
				$scope.address = $scope.student.address;
				$scope.email = $scope.student.email;
			} ,
			function() {
				alert("Student number is invalid");
			}
		);
	}
	
	$scope.updateStudent = function() {
		var dataObject = {
			"stuNo" : $scope.stuNo,
			"firstName" : $scope.fName,
			"lastName" : $scope.lName,
			"gender" : $scope.gender,
			"age" : $scope.age,
			"address" : $scope.address,
			"email" : $scope.email
		}
		
		$http.put("http://localhost:8080/student-app/api/student/"+ $scope.stuNo,  dataObject).then(
			function() {
				alert("successfully updated");
				$scope.getAllStudents();
				$scope.reset();
			} , 
			function() {
				alert("something went wrong");
			}
		);
	}
	
	$scope.deleteStudent = function(stuNo) {
		$http.delete("http://localhost:8080/student-app/api/student/" + stuNo).then(
			function() {
				alert("successfully deleted");
				$scope.getAllStudents();
			} ,
			function() {
				alert("No such student")
			}	
		);
	}

	$scope.reset = function() {
		$scope.stuNo = "";
		$scope.fName = "";
		$scope.lName = "";
		$scope.gender = "";
		$scope.age = "";
		$scope.address = "";
		$scope.email = "";
	}
});
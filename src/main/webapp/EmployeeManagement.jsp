<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script type="text/javascript">
	
	var app = angular.module("EmployeeManagement", []);
    
    //Controller Part
    app.controller("EmployeeManagementController", function($scope, $http) {
    	$scope.form={
    			id:"-1",
    			name:"",
    			password:"",
    			designation:"",
    			salary:""
    	};
    	_refreshPageData();
    	 
         function _refreshPageData() {
             $http({
                 method : 'GET',
                 url : 'getAllEmployee'
             }).then(function (response) {
                 $scope.employees = response.data;
                	 alert(JSON.stringify(response));
             }, function errorCallback(response) {
                 console.log(response.statusText);
             });
         }
  
         function _success(response) {
             _refreshPageData();
             _clearForm()
         }
  
         function _error(response) {
             console.log(response.statusText);
         }
  
         //Clear the form
         function _clearForm() {
             $scope.form.name = "";
             $scope.form.password = "";
             $scope.form.designation = "";
             
         };
         $scope.submitEmployee = function() {
    		 
    		  var method = "";
             var url = "";
             if ($scope.form.id == -1) {
                 //Id is absent so add employee - POST operation
                 method = "POST";
                 url = 'addEmployee';
             } else {
                 //If Id is present, it's edit operation - PUT operation
                 alert('submitEmployee');
                 method = "PUT";
                 url = 'updateEmployee/' + $scope.form.id;
             }
  
             $http({
                 method : method,
                 url : url,
                 data : angular.toJson($scope.form),
                 headers : {
                     'Content-Type' : 'application/json'
                 }
             }).then( _success, _error ); 
         };
  $scope.editEmployee = function(employee)
  {
	  $scope.form.id = employee.id;
	  $scope.form.name = employee.name;
	  $scope.form.password = employee.password;
	  $scope.form.designation = employee.designation;
	  $scope.form.salary = employee.salary;
  };
  $scope.deleteEmployee = function(employee)
  {
	  $http({
          method : 'DELETE',
          url : 'deleteEmployee/' + employee.id
      }).then(_success, _error);
  };
  
    	 
    });
 
	</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	
</head>

<body ng-app="EmployeeManagement" ng-controller="EmployeeManagementController">

	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Password</th>
<th>designation</th>
<th>Salary</th>
</tr>
 <tr ng-repeat="employee in employees">
  <td>{{ employee.id }}</td>
                <td>{{ employee.name }}</td>
                <td>{{ employee.password }}</td>
                <td>{{ employee.designation }}</td>
                <td>{{ employee.salary }}</td>
<td><a ng-click="editEmployee(employee)" class="btn btn-primary btn-sm">Edit</a>
					<a ng-click="deleteEmployee(employee)" class="btn btn-danger btn-sm">Delete</a></td>       
     </tr>
</table>
<form ng-submit="submitEmployee()">
 <h2>Add/Edit Employee</h2>
<table>
<tr><td>Id</td>
<td>
<input type="text" ng-model="form.id"/>
</td></tr>
<tr>
<td>name</td>
<td><input type="text" ng-model="form.name"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" ng-model="form.password"/></td>
</tr>
<tr>
<td>description</td>
<td><input type="text" ng-model="form.designation"/></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text" ng-model="form.salary"/></td>
</tr>
<tr>
<td>
<input type="submit">Click Me!</button>
</td>
</tr>
</table>
</form>
</body>
</html>
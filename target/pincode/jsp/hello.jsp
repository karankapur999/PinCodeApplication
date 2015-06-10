<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html ng-app="myApp">

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<title>Contact List</title>
</head>

<body>
	<div class="container" ng-controller="AppCtrl">
		<h1>Pincode List App</h1>
		<table class="table">
			<thead>
				<tr>
					<th>District Name</th>
					<th>State</th>
					<th>PinCode</th>

					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<form method="POST" action="fetching">
					<tr>
						<td><input class="form-control"
							ng-model="contact.district_name"></td>
						<td><input class="form-control" ng-model="contact.state"></td>
						<td><input class="form-control" name="pincode"
							ng-model="contact.pincode"></td>
						<td><button class="btn btn-primary"">Search</button></td>


						<!-- 			<td><button class="btn btn-info" ng-click="update()"> Update</button></td>
 -->
					</tr>
				</form>

				<c:forEach items="${response}" var="element">
					<tr>
						<c:forEach items="${element}" var="obj">
							<td class="form-control"><span>${obj.districtName}</span></td>
							<td class="form-control"><span>${obj.stateName}</span></td>
							<td class="form-control"><span>${obj.pincode}</span></td>


						</c:forEach>
					</tr>
				</c:forEach>




			</tbody>
		</table>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
	<!-- <script src="resources/controller.js"></script> -->
</body>

</html>
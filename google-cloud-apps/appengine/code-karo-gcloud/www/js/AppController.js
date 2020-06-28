var app = angular.module("ContactApp", []);

// Controller Part
app.controller("ContactCtrl", function($scope, $http) {

	// HTTP POST/PUT methods for add/edit employee
	$scope.submitQuery = function() {

		var userId = '30004';
		var name = $('#contact_name_input').val();
		var email = $('#contact_email_input').val();
		var emailSubject = $('#contact_email_subject_input').val();
		var queryTxt = $('#contact_text_area_input').val();
		var postData = {
			"userId" : userId,
			"contactName" : name,
			"contactEmailAddress" : email,
			"contactQuerySubject" : emailSubject,
			"contactQueryText" : queryTxt
		};

		var method = "POST";
		var url = "http://localhost:8080/queries/put";

		$http({
			method : method,
			url : url,
			data : JSON.stringify(postData),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

	function _success(response) {
		console.log("SUCCESS");
		console.log(response.statusText);
		// _refreshPageData();
		// _clearForm()
	}

	function _error(response) {
		console.log(response.statusText);
	}
});
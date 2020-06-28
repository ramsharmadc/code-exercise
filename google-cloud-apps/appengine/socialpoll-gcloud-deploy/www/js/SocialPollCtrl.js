var app = angular.module("SocialPollApp", []);

// Controller Part
app.controller("SocialPollCtrl", function($scope, $http) {

    $scope.allPolls = [];

	// HTTP POST/PUT methods for add/edit social poll
	$scope.submitNewPoll = function() {

	    alert("Here I am!!");

//		var id = '30006';
		var name = $('#poll-name-txt').val();
		var optionA = $('#poll-option-yes-txt').val();
		var optionB = $('#poll-option-no-txt').val();
		var postData = {
//			"id" : id,
			"name" : name,
			"optionA" : optionA,
			"optionB" : optionB,

		};

		var method = "POST";
		var url = "http://localhost:8080/socialpoll/put";

		$http({
			method : method,
			url : url,
			data : JSON.stringify(postData),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(success, error);
	};

	function success(response) {
	    alert("oh yeah!! You just posted a social poll.");
		console.log("SUCCESS");
		console.log(response.statusText);
		// _refreshPageData();
		// _clearForm()
	}

	function error(response) {
	    alert("oops!! some error happened.");
		console.log(response.statusText);
	}

	// HTTP GET methods for showing social polls
    $scope.fetchAllPolls = function() {
         alert("Here I am in showing social polls!!");
    	 $http.get('http://localhost:8080/socialpoll/get').
                then(function(response) {
                console.log(response.data)
                    $scope.allPolls = angular.fromJson(response.data);
             });
             console.log(response.data)
//         alert($scope.allPolls);
    };

	/*angular.element(document).ready(function (){

	    alert("I am called");

	    google.charts.load('current', {packages: ['corechart', 'bar']});
        google.charts.setOnLoadCallback(drawBasic);

        function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('timeofday', 'Time of Day');
        data.addColumn('number', 'Motivation Level');

        data.addRows([
            [{v: [8, 0, 0], f: '8 am'}, 1],
            [{v: [9, 0, 0], f: '9 am'}, 2],
            [{v: [10, 0, 0], f:'10 am'}, 3],
            [{v: [11, 0, 0], f: '11 am'}, 4],
            [{v: [12, 0, 0], f: '12 pm'}, 5],
            [{v: [13, 0, 0], f: '1 pm'}, 6],
            [{v: [14, 0, 0], f: '2 pm'}, 7],
            [{v: [15, 0, 0], f: '3 pm'}, 8],
            [{v: [16, 0, 0], f: '4 pm'}, 9],
            [{v: [17, 0, 0], f: '5 pm'}, 10],
        ]);

        var options = {
            title: 'Motivation Level Throughout the Day',
            hAxis: {
                title: 'Time of Day',
                format: 'h:mm a',
                viewWindow: {
                    min: [7, 30, 0],
                    max: [17, 30, 0]
                }
            },
            vAxis: {
                title: 'Rating (scale of 1-10)'
            }
        };

        var chart = new google.visualization.ColumnChart(
            document.getElementById('chart_div'));
            chart.draw(data, options);
        }
	});*/
});
agGrid.initialiseAgGridWithAngular1(angular);

var app = angular.module("DoctorsApp", []);

app.controller("DoctorsCtrl", function($scope) {

    var columnDefs = [
        {headerName: "Doctor Name", field: "docName"},
        {headerName: "Doctor Contact", field: "docPhoneNumber"},
        {headerName: "Doctor Shift", field: "docShift"}
    ];

    var rowData = [
        {   "docId" : "DOC-1",
            "docName" : "Ram Sharma",
            "docEmailAddress" : "ramsharma@gmail.com",
            "docPhoneNumber" : "80957784009",
            "docSpeciality" : "Heart Specialist",
            "docShift": "Morning"
        },
        {
            "docId" : "DOC-2",
            "docName" : "Ravi Kumar",
            "docEmailAddress" : "ravikumar@gmail.com",
            "docPhoneNumber" : "8099865009",
            "docSpeciality" : "Physician"
            "docShift": "Evening"
        }
    ];

    $scope.gridOptions = {
        columnDefs: columnDefs,
        rowData: rowData
    };

});

    //agGrid.initialiseAgGridWithAngular1(angular);

    var app = angular.module("DocApp", ['ngGrid']);

    // Controller Part
    app.controller("DocCtrl", function($scope, $http) {

    $scope.columnHeaders = [
    {displayName: "Doctor Name", field: "docName"},
    {displayName: "Doctor Contact", field: "docPhoneNumber"},
    {displayName: "Doctor Shift", field: "docShift"},
    {displayName: "Doctor Speciality", field: "docSpeciality"},
    {displayName: "Doctor Area", field: "docArea"}
    ];

    $scope.rowDetails = [
    {
    docName : "Ram Sharma",
    docPhoneNumber : "80957784009",
    docShift: "Morning",
    docSpeciality:"Physician",
    docArea:"Mohan Garden"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
    docName : "Ravi Kumar",
    docPhoneNumber : "8099865009",
    docShift: "Evening",
    docSpeciality:"Heart specialist",
    docArea:"Uttam Nagar"
    },
    {
        docName : "Ravi Kumar",
        docPhoneNumber : "8099865009",
        docShift: "Evening",
        docSpeciality:"Heart specialist",
        docArea:"Uttam Nagar"
        }
    ];

    $scope.gridOptions = {
    columnDefs: 'columnHeaders',
    data: 'rowDetails'
    };


    });
var EmpApp = angular.module('RequestApp', ['ngRoute']);
RequestApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/request/list',
    {
        templateUrl: 'home/listassetrequest',
        controller: 'ListRequestController'
    }).
    when('/request/create',
    {
        templateUrl: 'home/editassetrequest',
        controller: 'EditRequestController'
    }).
    when('/request/edit/:id',
    {
        templateUrl: 'home/editassetrequest',
        controller: 'EditRequestController'
    }).
    when('/request/delete/:id',
    {
        templateUrl: 'home/deleteassetrequest',
        controller: 'DeleteRequestController'
    }).when('/room/list',
    {
        templateUrl: 'home/listroom',
        controller: 'ListController'
    }).
    when('/room/create',
    {
        templateUrl: 'home/editroom',
        controller: 'EditController'
    }).
    when('/room/edit/:id',
    {
        templateUrl: 'home/editroom',
        controller: 'EditController'
    }).
    when('/room/delete/:id',
    {
        templateUrl: 'home/deleteroom',
        controller: 'DeleteController'
    }).when('/building/list',
    {
        templateUrl: 'home/listbuilding',
        controller: 'ListBuildingController'
    }).
    when('/building/create',
    {
        templateUrl: 'home/editbuilding',
        controller: 'EditBuildingController'
    }).
    when('/building/edit/:id',
    {
        templateUrl: 'home/editbuilding',
        controller: 'EditBuildingController'
    }).
    when('/building/delete/:id',
    {
        templateUrl: 'home/deletebuilding',
        controller: 'DeleteBuildingController'
    }).when('/site/list',
    {
        templateUrl: 'home/listsite',
        controller: 'ListSiteController'
    }).
    when('/site/create',
    {
        templateUrl: 'home/editsite',
        controller: 'EditSiteController'
    }).
    when('/site/edit/:id',
    {
        templateUrl: 'home/editsite',
        controller: 'EditSiteController'
    }).
    when('/site/delete/:id',
    {
        templateUrl: 'home/deletesite',
        controller: 'DeleteSiteController'
    }).when('/asset/list',
    {
        templateUrl: 'home/listasset',
        controller: 'ListAssetController'
    }).
    when('/asset/create',
    {
        templateUrl: 'home/editasset',
        controller: 'EditAssetController'
    }).
    when('/asset/edit/:id',
    {
        templateUrl: 'home/editasset',
        controller: 'EditAssetController'
    }).
    when('/asset/delete/:id',
    {
        templateUrl: 'home/deleteasset',
        controller: 'DeleteAssetController'
    }).
    otherwise(
    {
        redirectTo: '/request/list'
    });
}]);
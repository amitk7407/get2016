// this controller call the api method and display the list of sites in listsite.cshtml  
RequestApp.controller("ListSiteController", ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/api/sites').success(function (data) {
            $scope.sites = data;
        }).error(function (data) {
            $scope.error = "An error has occured while getting sites! " + data;
        });
    }
]);

// this controller call the api method and display the record of selected site
// in deletesite.cshtml and provide an option for delete  
RequestApp.controller("DeleteSiteController", ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.id = $routeParams.id;
        $http.get('/api/sites/' + $scope.id).success(function (data) {
            //$scope.siteid = data.SiteId;
            $scope.sitename = data.SiteName;
            $scope.country = data.Country;
            $scope.state = data.State;
            $scope.active = data.IsActive;
        }).error(function (data) {
            $scope.error = "An error has occured while fetching site! " + data;
        });
        $scope.delete = function () {
            $http.delete('/api/sites/' + $scope.id).success(function (data) {
                $location.path('/site/list');
            }).error(function (data) {
                $scope.error = "An error has occured while deleting site! " + data;
            });
        };
    }
]);

// this controller call the api method and display the record of selected site
// in editsite.cshtml and provide an option for create and modify the site and save the site record  
RequestApp.controller("EditSiteController", ['$scope', '$filter', '$http', '$routeParams', '$location',
    function ($scope, $filter, $http, $routeParams, $location) {
        $scope.id = 0;
        $scope.save = function () {
            var obj = {
                SiteId: $scope.siteid,
                SiteName: $scope.sitename,
                Country: $scope.country,
                State: $scope.state,
                IsActive: $scope.active
            };
            if ($scope.id == 0) {
                $http.post('/api/sites/', obj).success(function (data) {
                    $location.path('/site/list');
                }).error(function (data) {
                    $scope.error = "An error has occured while adding site! " + data.ExceptionMessage;
                });
            }
            else {
                $http.put('/api/sites/', obj).success(function (data) {
                    $location.path('/site/list');
                }).error(function (data) {
                    console.log(data);
                    $scope.error = "An Error has occured while Saving site! " + data.ExceptionMessage;
                });
            }
        }
        if ($routeParams.id) {
            $scope.id = $routeParams.id;
            $scope.title = "Edit Site";
            $http.get('/api/sites/' + $routeParams.id).success(function (data) {
                $scope.siteid = data.SiteId;
                $scope.sitename = data.SiteName;
                $scope.country = data.Country;
                $scope.state = data.State;
                $scope.active = data.IsActive;
                $scope.displaySiteId = "";
                $scope.disabled = "disabled";
            });
        }
        else {
            $scope.title = "Create New Site";
            $scope.displaySiteId = "none";
            $scope.disabled = "";
        }
    }
]);
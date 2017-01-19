// this controller call the api method and display the list of buildings in listbuilding.cshtml  
RequestApp.controller("ListBuildingController", ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/api/buildings').success(function (data) {
            $scope.buildings = data;
        }).error(function (data) {
            $scope.error = "An error has occured while getting buildings! " + data;
        });
    }
]);

// this controller call the api method and display the record of selected building
// in deletebuilding.cshtml and provide an option for delete  
RequestApp.controller("DeleteBuildingController", ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.id = $routeParams.id;
        $http.get('/api/buildings/' + $scope.id).success(function (data) {
            //$scope.buildingid = data.BuildingId;
            $scope.buildingname = data.BuildingName;
            $scope.sitename = data.SiteName;
            $scope.country = data.Country;
            $scope.state = data.State;
            $scope.active = data.IsActive;
        }).error(function (data) {
            $scope.error = "An error has occured while fetching building! " + data;
        });
        $scope.delete = function () {
            $http.delete('/api/buildings/' + $scope.id).success(function (data) {
                $location.path('/building/list');
            }).error(function (data) {
                $scope.error = "An error has occured while deleting building! " + data;
            });
        };
    }
]);

// this controller call the api method and display the record of selected building
// in editbuilding.cshtml and provide an option for create and modify the building and save the building record  
RequestApp.controller("EditBuildingController", ['$scope', '$filter', '$http', '$routeParams', '$location',
    function ($scope, $filter, $http, $routeParams, $location) {
        $scope.id = 0;
        $scope.save = function () {
            var obj = {
                BuildingId: $scope.buildingid,
                BuildingName: $scope.buildingname,
                SiteName: $scope.sitename,
                Country: $scope.country,
                State: $scope.state,
                IsActive: $scope.active
            };
            if ($scope.id == 0) {
                $http.post('/api/buildings/', obj).success(function (data) {
                    $location.path('/building/list');
                }).error(function (data) {
                    $scope.error = "An error has occured while adding building! " + data.ExceptionMessage;
                });
            }
            else {
                $http.put('/api/buildings/', obj).success(function (data) {
                    $location.path('/building/list');
                }).error(function (data) {
                    console.log(data);
                    $scope.error = "An Error has occured while Saving building! " + data.ExceptionMessage;
                });
            }
        }
        if ($routeParams.id) {
            $scope.id = $routeParams.id;
            $scope.title = "Edit Building";
            $http.get('/api/buildings/' + $routeParams.id).success(function (data) {
                $scope.buildingid = data.BuildingId;
                $scope.buildingname = data.BuildingName;
                $scope.sitename = data.SiteName;
                $scope.country = data.Country;
                $scope.state = data.State;
                $scope.active = data.IsActive;
                $scope.displayBuildingId = "";
                $scope.disabled = "disabled";
            });
        }
        else {
            $scope.title = "Create New Building";
            $scope.displayBuildingId = "none";
            $scope.disabled = "";
        }
    }
]);
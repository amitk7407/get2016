// this controller call the api method and display the list of requests in listrequest.cshtml  
RequestApp.controller("ListRequestController", ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/api/assetrequests').success(function (data) {
            $scope.requests = data;
        }).error(function (data) {
            $scope.error = "An error has occured while getting requests! " + data;
        });
    }
]);

// this controller call the api method and display the record of selected request
// in deleterequest.cshtml and provide an option for delete  
RequestApp.controller("DeleteRequestController", ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.id = $routeParams.id;
        $http.get('/api/assetrequests/' + $scope.id).success(function (data) {
            //$scope.requestid = data.AssetRequestId;
            $scope.requestname = data.AssetRequestName;
            $scope.assetname = data.AssetName;
            $scope.roomname = data.RoomName;
            $scope.buildingname = data.BuildingName;
            $scope.sitename = data.SiteName;
            $scope.country = data.Country;
            $scope.state = data.State;
            $scope.active = data.IsActive;
        }).error(function (data) {
            $scope.error = "An error has occured while fetching request! " + data;
        });
        $scope.delete = function () {
            $http.delete('/api/assetrequests/' + $scope.id).success(function (data) {
                $location.path('/request/list');
            }).error(function (data) {
                $scope.error = "An error has occured while deleting request! " + data;
            });
        };
    }
]);

// this controller call the api method and display the record of selected request
// in editrequest.cshtml and provide an option for create and modify the request and save the request record  
RequestApp.controller("EditRequestController", ['$scope', '$filter', '$http', '$routeParams', '$location',
    function ($scope, $filter, $http, $routeParams, $location) {
        $scope.id = 0;
        $scope.save = function () {
            var obj = {
                AssetRequestId: $scope.requestid,
                AssetRequestName: $scope.requestname,
                AssetName: $scope.assetname,
                RoomName: $scope.roomname,
                BuildingName: $scope.buildingname,
                SiteName: $scope.sitename,
                Country: $scope.country,
                State: $scope.state,
                IsActive: $scope.active
            };
            if ($scope.id == 0) {
                $http.post('/api/assetrequests/', obj).success(function (data) {
                    $location.path('/request/list');
                }).error(function (data) {
                    $scope.error = "An error has occured while adding request! " + data.ExceptionMessage;
                });
            }
            else {
                $http.put('/api/assetrequests/', obj).success(function (data) {
                    $location.path('/request/list');
                }).error(function (data) {
                    console.log(data);
                    $scope.error = "An Error has occured while Saving request! " + data.ExceptionMessage;
                });
            }
        }
        if ($routeParams.id) {
            $scope.id = $routeParams.id;
            $scope.title = "Edit Request";
            $http.get('/api/assetrequests/' + $routeParams.id).success(function (data) {
                $scope.requestid = data.requestId;
                $scope.requestname = data.requestName;
                $scope.assetname = data.AssetName;
                $scope.roomname = data.RoomName;
                $scope.buildingname = data.BuildingName;
                $scope.sitename = data.SiteName;
                $scope.country = data.Country;
                $scope.state = data.State;
                $scope.active = data.IsActive;
                $scope.displayRequestId = "";
                $scope.disabled = "disabled";
            });
        }
        else {
            $scope.title = "Create New Request";
            $scope.displayRequestId = "none";
            $scope.disabled = "";
        }
    }
]);
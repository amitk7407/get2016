// this controller call the api method and display the list of assets in listasset.cshtml  
RequestApp.controller("ListAssetController", ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/api/assets').success(function (data) {
            $scope.assets = data;
        }).error(function (data) {
            $scope.error = "An error has occured while getting assets! " + data;
        });
    }
]);

// this controller call the api method and display the record of selected asset
// in deleteasset.cshtml and provide an option for delete  
RequestApp.controller("DeleteAssetController", ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.id = $routeParams.id;
        $http.get('/api/assets/' + $scope.id).success(function (data) {
            //$scope.assetid = data.assetId;
            $scope.assetname = data.AssetName;
            $scope.roomname = data.RoomName;
            $scope.buildingname = data.BuildingName;
            $scope.sitename = data.SiteName;
            $scope.country = data.Country;
            $scope.state = data.State;
            $scope.active = data.IsActive;
        }).error(function (data) {
            $scope.error = "An error has occured while fetching asset! " + data;
        });
        $scope.delete = function () {
            $http.delete('/api/assets/' + $scope.id).success(function (data) {
                $location.path('/asset/listasset');
            }).error(function (data) {
                $scope.error = "An error has occured while deleting asset! " + data;
            });
        };
    }
]);

// this controller call the api method and display the record of selected asset
// in editasset.cshtml and provide an option for create and modify the asset and save the asset record  
RequestApp.controller("EditAssetController", ['$scope', '$filter', '$http', '$routeParams', '$location',
    function ($scope, $filter, $http, $routeParams, $location) {
        $scope.id = 0;
        $scope.save = function () {
            var obj = {
                AssetId: $scope.assetid,
                AssetName: $scope.assetname,
                RoomName: $scope.roomname,
                BuildingName: $scope.buildingname,
                SiteName: $scope.sitename,
                Country: $scope.country,
                State: $scope.state,
                IsActive: $scope.active
            };
            if ($scope.id == 0) {
                $http.post('/api/assets/', obj).success(function (data) {
                    $location.path('/asset/listasset');
                }).error(function (data) {
                    $scope.error = "An error has occured while adding asset! " + data.ExceptionMessage;
                });
            }
            else {
                $http.put('/api/assets/', obj).success(function (data) {
                    $location.path('/asset/listasset');
                }).error(function (data) {
                    console.log(data);
                    $scope.error = "An Error has occured while Saving asset! " + data.ExceptionMessage;
                });
            }
        }
        if ($routeParams.id) {
            $scope.id = $routeParams.id;
            $scope.title = "Edit Asset";
            $http.get('/api/assets/' + $routeParams.id).success(function (data) {
                $scope.assetid = data.AssetId;
                $scope.assetname = data.AssetName;
                $scope.roomname = data.RoomName;
                $scope.buildingname = data.BuildingName;
                $scope.sitename = data.SiteName;
                $scope.country = data.Country;
                $scope.state = data.State;
                $scope.active = data.IsActive;
                $scope.displayAssetId = "";
                $scope.disabled = "disabled";
            });
        }
        else {
            $scope.title = "Create New Asset";
            $scope.displayAssetId = "none";
            $scope.disabled = "";
        }
    }
]);
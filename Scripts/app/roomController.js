// this controller call the api method and display the list of rooms in listroom.cshtml  
RequestApp.controller("ListRoomController", ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/api/rooms').success(function (data) {
            $scope.rooms = data;
        }).error(function (data) {
            $scope.error = "An error has occured while getting rooms! " + data;
        });
    }
]);

// this controller call the api method and display the record of selected room
// in deleteroom.cshtml and provide an option for delete  
RequestApp.controller("DeleteRoomController", ['$scope', '$http', '$routeParams', '$location',
    function ($scope, $http, $routeParams, $location) {
        $scope.id = $routeParams.id;
        $http.get('/api/rooms/' + $scope.id).success(function (data) {
            //$scope.roomid = data.RoomId;
            $scope.roomname = data.RoomName;
            $scope.buildingname = data.BuildingName;
            $scope.sitename = data.SiteName;
            $scope.country = data.Country;
            $scope.state = data.State;
            $scope.active = data.IsActive;
        }).error(function (data) {
            $scope.error = "An error has occured while fetching room! " + data;
        });
        $scope.delete = function () {
            $http.delete('/api/rooms/' + $scope.id).success(function (data) {
                $location.path('/room/list');
            }).error(function (data) {
                $scope.error = "An error has occured while deleting room! " + data;
            });
        };
    }
]);

// this controller call the api method and display the record of selected room
// in editroom.cshtml and provide an option for create and modify the room and save the room record  
RequestApp.controller("EditRoomController", ['$scope', '$filter', '$http', '$routeParams', '$location',
    function ($scope, $filter, $http, $routeParams, $location) {
        $scope.id = 0;
        $scope.save = function () {
            var obj = {
                RoomId: $scope.roomid,
                RoomName: $scope.roomname,
                BuildingName: $scope.buildingname,
                SiteName: $scope.sitename,
                Country: $scope.country,
                State: $scope.state,
                IsActive: $scope.active
            };
            if ($scope.id == 0) {
                $http.post('/api/rooms/', obj).success(function (data) {
                    $location.path('/room/list');
                }).error(function (data) {
                    $scope.error = "An error has occured while adding room! " + data.ExceptionMessage;
                });
            }
            else {
                $http.put('/api/rooms/', obj).success(function (data) {
                    $location.path('/room/list');
                }).error(function (data) {
                    console.log(data);
                    $scope.error = "An Error has occured while Saving room! " + data.ExceptionMessage;
                });
            }
        }
        if ($routeParams.id) {
            $scope.id = $routeParams.id;
            $scope.title = "Edit Room";
            $http.get('/api/rooms/' + $routeParams.id).success(function (data) {
                $scope.roomid = data.RoomId;
                $scope.roomname = data.RoomName;
                $scope.buildingname = data.BuildingName;
                $scope.sitename = data.SiteName;
                $scope.country = data.Country;
                $scope.state = data.State;
                $scope.active = data.IsActive;
                $scope.displayRoomId = "";
                $scope.disabled = "disabled";
            });
        }
        else {
            $scope.title = "Create New Room";
            $scope.displayRoomId = "none";
            $scope.disabled = "";
        }
    }
]);
angular.module('message-app',[]).controller("messageController", function($scope, $http){
  $scope.messages = [];
  $http.get('/service/GetAllNotes?orderby=id').success(function(data){
            $scope.messages = data;
        });
  $scope.addMessage = function() {
      $scope.messages.push({text:$scope.text, author:$scope.author});
      $scope.text = '';
      $scope.author = '';
    };
});
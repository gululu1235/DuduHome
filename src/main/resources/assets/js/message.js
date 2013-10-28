angular.module('message-app',[]).controller("messageController", function($scope, $http){
  $scope.messages = [];
  function getMessage() {
    $http.get('/service/GetAllNotes?orderby=id').success(function(data){
                data.forEach(function (message){
                    if (message.author.substring(0,2) == 'da'){
                        message.style = 'dadu';
                    }
                    else if (message.author.substring(0, 4) == 'xiao') {
                        message.style = 'xiaodu';
                    }
                    else {
                        message.style = 'xiaodu';
                    }

                });
                $scope.messages = data;
            });
  }
  getMessage()
  $scope.addMessage = function() {
      var note = {}
      note.author = $scope.author;
      note.content = $scope.newMessage;
      $http.post("/service/PutNote", note).success(function(){
          getMessage();
      });

      $scope.newMessage = '';
      $scope.author = '';
    };
});
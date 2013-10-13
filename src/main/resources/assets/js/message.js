angular.module('message-app',[]).controller("messageController", function($scope, $http){
  $scope.messages = [];
  function getMessage() {
    $http.get('/service/GetAllNotes?orderby=id').success(function(data){
                data.forEach(function (message){
                    if (message.author == 'dadu'){
                        message.style = 'dadu';
                        message.icon = '/dadu.jpg';
                    }
                    else if (message.author == 'xiaodu') {
                        message.style = 'xiaodu';
                        message.icon = '/xiaodu.jpg';
                    }
                    else {
                        message.style = 'xiaodu';
                        message.icon = '/unknown.jpg';
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
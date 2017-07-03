Social.controller('logoutController', function ($scope, authService){
  $scope.logout = authService.logout;
})
Social.controller('FeedController', function($scope, $routeParams, social, $location, $rootScope){
  $scope.controller = 'FeedController';
  $rootScope.usuario;
  $scope.postContent = postCont;
  $scope.searchName = searchName;
  function searchName(nameSearch){
    social.getUsersByName(nameSearch)
  }
  console.log("ta dentro do feed controller");


    getUsuarioperfil($rootScope.usuario.username);


  function getUsuarioperfil(username){
    console.log(username + " username");
    social.getByUsername(username).then( function (response){
      $rootScope.usuario = response.data;
      console.log($rootScope.usuario);
    })
  }

  function postCont(post){
    console.log("ta indo rpa fazer post do post");
    console.log($rootScope.usuario);
    post.userProfile = $rootScope.usuario;
    social.postContentWithUser(post).then(function (response){
      $scope.post = {};
    })
    console.log("teoricamente termino o post");
  }

});

Social.controller('ProfileController', function($scope, $routeParams, social, $location, $rootScope){
  $scope.controller = 'ProfileController';
  $rootScope.usuario;
  //$scope.postContent = postCont;
  $scope.userPosts = [{}];
  $scope.searchName = searchName;
  $scope.idUser = $routeParams.idUser;

  function searchName(nameSearch){
    social.getUsersByName(nameSearch)
  }
  console.log("$scope.iduser = " + $scope.idUser);
  if($scope.idUser === undefined){
    getUsuarioperfil($rootScope.usuario.username);
    getPostsUser($rootScope.usuario.idUser);
  }
  else{
    getUserprofile($scope.idUser);
    getPostsUser($scope.idUser);
  }

  function getUserprofile(idUser) {
      social.getUserprofileById(idUser).then( function (response){
        $scope.userProfile = response.data;
      })
  }

  function getUsuarioperfil(username){
    social.getByUsername(username).then( function (response){
      $rootScope.usuario = response.data;
      console.log($rootScope.usuario);
    })
  }

  function getPostsUser(idUser){
    social.getPostsUser(idUser).then(function (response){
      $scope.userPosts = response.data;
    })
  }

});






























//

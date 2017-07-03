Social.controller('logoutController', function ($scope, authService){
  $scope.logout = authService.logout;

})
Social.controller('FeedController', function($scope, $routeParams, social, $location, $rootScope){
  $scope.controller = 'FeedController';
  $scope.postContent = postCont;
  $scope.postContents = [{}];
  $scope.gg = gg;
  $rootScope.usuarios = [{}];
  $scope.searchName = searchName;
  function searchName(nameSearch){
    console.log(nameSearch);
    social.getUsersByName(nameSearch).then(function (response){
      $rootScope.usuarios = response.data;
      $location.path('/profiles');
    })
  }
  console.log("ta dentro do feed controller");
console.log("user ");
  console.log($rootScope.usuario);
  getUsuarioperfil($rootScope.usuario.username);

  function gg(post){
    var liked = false;
    var x;
    for (p of post.contentLikes){
      if(p.idUser === $rootScope.usuario.idUser){
        liked = true;
        x = post.contentLikes.indexOf(p);
        console.log(x);
        break;
      }
    }
    if(liked){
      post.contentLikes.splice(x,1);
    }else{
      post.contentLikes.push($rootScope.usuario);
    }

    social.postGG(post).then(function (response){
      getRelationshipPostContents();
    })
  }
  function getRelationshipPostContents(){
    social.getRelationshipPostContents($rootScope.usuario.idUser).then(function (response){
      $scope.postContents = response.data;
    })
  }

  function getUsuarioperfil(username){
    console.log(username + " username");
    social.getByUsername(username).then( function (response){
      console.log("pegando perfil do usuario");
      $rootScope.usuario = response.data;

      console.log($rootScope.usuario);
      $rootScope.usuario.username = username;
      console.log("pegou tudo ja");
      console.log($rootScope.usuario);
      getRelationshipPostContents();
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
  //$scope.postContent = postCont;
  $scope.userPosts = [{}];
  $scope.idUser = $routeParams.idUser;
  $scope.add = add;
  $scope.searchName = searchName;
  function searchName(nameSearch){
    console.log(nameSearch);
    social.getUsersByName(nameSearch).then(function (response){
      $rootScope.usuarios = response.data;
      $location.path('/profiles');
    })
  }
  console.log("$scope.iduser = " + $scope.idUser);
  if($scope.idUser === undefined){
    getUsuarioperfil($rootScope.usuario.username);
    getPostsUser($rootScope.usuario.idUser);
  }else if(!!$scope.idUser){
    console.log($scope.idUser);
    getUserprofile($scope.idUser);
    getPostsUser($scope.idUser);
  }else if(!!$rootScope.usuarios)
  {
    $scope.usuarios = $rootScope.usuarios;
    $rootScope.usuarios = [{}];
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
      $rootScope.usuario.username = username;
      console.log("pegou tudo ja");
      console.log($rootScope.usuario);
      console.log($rootScope.usuario);
    })
  }

  function getPostsUser(idUser){
    social.getPostsUser(idUser).then(function (response){
      $scope.userPosts = response.data;
    })
  }

  function add(profileAdd){
      var relationship = {"relationshipPK":{
        "idUser":  $rootScope.usuario.idUser,
        "idUserRelationship": profileAdd.idUser
      }};
      // relationship.userprofile = $rootScope.usuario;
      // relationship.userprofile1 = profileAdd;

      social.addRelationship(relationship).then(function (response){
        alert('Added, w8ing for response');
        $location.path('/feed');
      })
  }

});






























//

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
  $scope.friends=[];
  $scope.pending=[];

  function searchName(nameSearch){
    console.log(nameSearch);
    social.getUsersByName(nameSearch).then(function (response){
      $rootScope.usuarios = response.data;
      $location.path('/profiles');
    })
  }

  function getFrindsAndPending(){
    social.getRelations($rootScope.usuario.idUser).then(function (response){
        for (a of response.data){
          let friend = a;
            social.getUserprofileById(friend.relationshipPK.idUserRelationship).then(function (response){
              response.data.status = friend.relationshipStatus;
              if(friend.relationshipStatus != 'accepted'){
                $scope.pending.push(response.data);
              }else{
                $scope.friends.push(response.data);
              }
            })
          }
    })
  }

  getUsuarioperfil($rootScope.usuario.username);

  function gg(post){
    var liked = false;
    var pular;
    for (p of post.contentLikes){
      let ind = p;
      if(p.idUser === $rootScope.usuario.idUser){
        liked = true;
        pular = post.contentLikes.indexOf(ind);
        break;
      }
    }

    if(liked){
      post.contentLikes.splice(pular,1);
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
      getFrindsAndPending();
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
  $scope.userPosts = [{}];
  $scope.idUser = $routeParams.idUser;
  $scope.add = add;
  $scope.searchName = searchName;
  $scope.user;
  $scope.updateUser = updateUser;
  $scope.profile0 = {};
  $scope.profile0.friends=[];
  $scope.goToProfile =goToProfile;
  $scope.gg = gg;

  function gg(post){
    var liked = false;
    var pular;
    for (p of post.contentLikes){
      let ind = p;
      if(p.idUser === $rootScope.usuario.idUser){
        liked = true;
        pular = post.contentLikes.indexOf(ind);
        break;
      }
    }

    if(liked){
      post.contentLikes.splice(pular,1);
    }else{
      post.contentLikes.push($rootScope.usuario);
    }

    social.postGG(post).then(function (response){
      getPostsUser($rootScope.usuario.idUser);
    })
  }

  function goToProfile(id){
    $location.path('profile/'+id);
  }
  getFriends();

  function getFriends(){
    let id;
    $scope.idUser? id = $scope.idUser: id = $rootScope.usuario.idUser;
    social.getRelations(id).then(function (response){
        for (a of response.data){
          let friend = a;
            social.getUserprofileById(friend.relationshipPK.idUserRelationship).then(function (response){
              response.data.status = friend.relationshipStatus;
              if(friend.relationshipStatus === 'accepted'){
                $scope.profile0.friends.push(response.data);
              }
            })
          }
          console.log("termino o for pegando amigos");
    })
  }

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
  }else
  if(!!$scope.idUser){
    console.log($scope.idUser);
    getUserprofile($scope.idUser);
    getPostsUser($scope.idUser);
  }else
  if(!!$rootScope.usuarios)
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
      $rootScope.usuario.username = username;
      $scope.user = $rootScope.usuario;
      $rootScope.user.birthday = new Date($rootScope.usuario.birthday);
      console.log("helloo");
      console.log($scope.user);

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

  function updateUser(){
    social.updateUser($scope.user).then( function (response){
      $rootScope.usuario = response.data;
      $rootScope.usuario.birthday = new Date($rootScope.usuario.birthday);
      $location.path("#!/profile");
    })
  }

});


Social.controller('RequestController', function($scope, $routeParams, social, $location, $rootScope){
  $scope.controller = 'RequestController';
  $scope.searchName = searchName;
  $scope.userRelations = [];
  $scope.relations = [{}];
  $scope.accept = accept;
  $scope.decline = decline;
  $scope.unfriend = unfriend;
  $scope.friends=[];
  $scope.pending=[];
  $scope.changePassword = changePassword;

//  $scope.relationshipUpdate = relationshipUpdate;
  getUsuarioperfil($rootScope.usuario.username);
  getUserRelationship($rootScope.usuario.idUser);
  getFrindsAndPending();
  function searchName(nameSearch){
    console.log(nameSearch);
    social.getUsersByName(nameSearch).then(function (response){
      $rootScope.usuarios = response.data;
      $location.path('/profiles');
    })
  }

  function getFrindsAndPending(){
    social.getRelations($rootScope.usuario.idUser).then(function (response){
        for (a of response.data){
          let friend = a;
            social.getUserprofileById(friend.relationshipPK.idUserRelationship).then(function (response){
              response.data.status = friend.relationshipStatus;
              if(friend.relationshipStatus != 'accepted'){
                $scope.pending.push(response.data);
              }else{
                $scope.friends.push(response.data);
              }
            })
          }
    })
  }

  function getUsuarioperfil(username){
    social.getByUsername(username).then( function (response){
      $rootScope.usuario = response.data;
      $rootScope.usuario.username = username;
      $scope.user = $rootScope.usuario;
    })
  }

  function getUserRelationship(idUser) {
      social.getRelations(idUser).then(function (response){

        var relations = response.data;

        console.log(relations);

        for(rel of relations){
          let r = rel;
          social.getUserprofileById(rel.relationshipPK.idUserRelationship).then( function (response){
             resp = response.data;
             console.log(r);
             resp.status = relations[relations.indexOf(r)].relationshipStatus;
            $scope.userRelations.push(resp);
          })
        }
      })

  }

  function accept(profile){
    console.log("ta ae pra muda a relacao");
      let relationship = {"relationshipPK":{
        "idUser": $scope.usuario.idUser,
        "idUserRelationship": profile.idUser
      },
        "relationshipStatus":2
    }
      social.accept(relationship).then( function (response){
         alert('Relationship accepted');
         $route.reload();
        //  $location.path('/request');
      })
  }

  function decline(profile){
      console.log("ta ae pra muda a relacao");
        let relationship = {"relationshipPK":{
          "idUser": $scope.usuario.idUser,
          "idUserRelationship": profile.idUser
        },
          "relationshipStatus":3
      }
        social.decline(relationship).then( function (response){
           alert('Relationship decline');
           $routeParams.reload();
           $location.path('/request');
        })
    }

  function unfriend(profile){
      console.log("ta ae pra muda a relacao");
      let relationship = {"relationshipPK":{
        "idUser": $scope.usuario.idUser,
        "idUserRelationship": profile.idUser
      },
        "relationshipStatus":3
    }
        social.unfriend(relationship).then( function (response){
           alert('Relationship removed');
           $location.path('/request');
        })
    }

  function changePassword(password, password2){
      console.log("oiii");
      if(password === password2){
        console.log("dentro");
        let user = {"id": $scope.usuario.idUser,"username":$scope.usuario.username, "password":password}

        social.changePassword(user).then(function (response){
          alert('Password changed, login again!');
          $location.path('/r');
        })
        console.log("esperando sair do link");
      }else{
        alert('Passwords doesnt match!');
      }
  }
});


























//

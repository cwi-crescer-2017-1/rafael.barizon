angular.module('social').controller('LoginController2', function ($scope, authService, $rootScope, $location, social) {
$scope.controller="LoginController2";
$rootScope.usuario = {};
$scope.signIn = signIn;


  $scope.login = function (usuario) {
    console.log(usuario);
    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');

          $rootScope.usuario.username = usuario.username;
          $rootScope.logout = authService.logout;
          console.log($rootScope.usuario);
        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });
  };

  function signIn(userProfile) {
    social.signInSocial(userProfile.usersocial).then( function (response){
      userProfile.idUser = response.data;
      social.signInProfile(userProfile).then(function (response){
        $rootScope.usuario.idUser = response.data;
        console.log("termino cadastro");
        if(!!$rootScope.usuario.idUser){
          alert('Cadastro Realizado com sucesso');
          $location.path('#!/login');
        }

      })
    })

  }

});

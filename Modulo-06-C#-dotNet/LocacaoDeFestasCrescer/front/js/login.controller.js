angular.module('festaCrescer').controller('LoginController2', function ($scope, authService, $rootScope,$location) {
$scope.controller="LoginController2";

  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');
          $rootScope.usuario = response.data.dados;
          $rootScope.logout = authService.logout;
          $rootScope.logado = true;

        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
          $rootScope.logado = false;
        });
  };

});

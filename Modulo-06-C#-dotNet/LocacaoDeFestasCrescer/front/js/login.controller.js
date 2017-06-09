angular.module('festaCrescer').controller('LoginController2', function ($scope, authService, $rootScope) {
$scope.controller="LoginController2";
  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');
          $rootScope.usuario = response.data.dados;

        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });
  };

});

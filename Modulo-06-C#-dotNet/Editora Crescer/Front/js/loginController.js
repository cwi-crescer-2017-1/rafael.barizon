
myapp.controller('LoginController', function($scope, $routeParams, authService,$rootScope,$location){
  console.log("hi");
  $scope.controller = 'LoginController';

  $rootScope.loginController = true;

  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          console.log(response);
          alert('Login com sucesso!');
          $rootScope.logado = true;
          $location.path('#!/administrativo').replace();
        },
        function (response) {
          console.log(response);
          alert('Erro no Login!');
        });
  };


});

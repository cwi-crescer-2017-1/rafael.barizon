var myapp = angular.module('myapp', ['ngRoute']);
// let livros = [{ nome : 'Senhor dos Aneis',
//   url : 'https://prodimage.images-bn.com/pimages/9780544003415_p0_v4_s192x300.jpg'
// },
// {
//   nome : "Senhor dos Aneis",
//   url : "https://prodimage.images-bn.com/pimages/9780544003415_p0_v4_s192x300.jpg"
// }]
// myapp.controller('controller', ['$scope', function($scope){
//   $scope.livros= livros;
// }]);


var myapp = angular.module('myapp', ['ngRoute']);

myapp.config(function ($routeProvider) {

  $routeProvider
    .when('/livros', {
      controller: 'LancamentosController',
      templateUrl: 'lancamentos.html'
    })
    .when('/livros/:idUrl', {
      controller: 'LivrosController',
      templateUrl: 'livros.html'
    })
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'login.html'
    })
    .otherwise({
      redirectTo: '/livros'
    });
});

var FestaCrescer = angular.module('festaCrescer',['ngRoute']);

FestaCrescer.config(function ($routeProvider) {

  $routeProvider
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'login.html'
    })
    .when('/pedido', {
      controller: 'LoginController',
      templateUrl: 'pedido.html'
    })
    // .when('/aulas/:idUrl', {
    //   controller: 'AulasController',
    //   templateUrl: 'aulas.html'
    // })
    // .when('/instrutores',{
    //   controller: 'InstrutoresController',
    //   templateUrl: 'instrutores.html'
    // })
    // .when('/instrutores/:idUrl',{
    //   controller: 'InstrutoresController',
    //   templateUrl: 'instrutores.html'
    // })
    .otherwise({
      redirectTo: '/login'
    });
});

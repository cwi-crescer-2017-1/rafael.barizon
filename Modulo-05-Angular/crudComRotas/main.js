var myapp = angular.module('myapp', ['ngRoute']);

myapp.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'AulasController',
      templateUrl: 'aulas.html'
    })
    .when('/aulas/:idUrl', {
      controller: 'AulasController',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores',{
      controller: 'InstrutoresController',
      templateUrl: 'instrutores.html'
    })
    .when('/instrutores/:idUrl',{
      controller: 'InstrutoresController',
      templateUrl: 'instrutores.html'
    })
    .otherwise({
      redirectTo: '/aulas'
    });
});

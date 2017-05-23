var myapp = angular.module('myapp', ['ngRoute']);

myapp.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'AulasController',
      templateUrl: 'aulas.html'
    })
    .when('/instrutores',{
      controller: 'InstrutoresController',
      templateUrl: 'instrutores.html'
    })
    .otherwise({
      redirectTo: '/aulas'
    });
});


myapp.controller('AulasController', function($scope, $routeParams, aulaService){
  $scope.controller = 'AulasController';
  let atualizarLista = function (){list();}
  $scope.insert = insert;
  $scope.update = update;
  $scope.delete = deleteAula;




    // Ações executadas quando criar a controller
    // findById($scope.id); // buscar aula por id (passado na url)
    list(); // listar aulas

    // Funções internas

    function insert(aula) {
      aulaService.insert(aula).then(atualizarLista)
    };

    // function findById(id) {
    //   aulaService.findById(id).then(function (response) {
    //     $scope.aula = response.data;
    //   });
    // };

    function list() {
      aulaService.list().then(function (response) {
        $scope.aulas = response.data;
      });
    }

    function update(aula) {
      aulaService.update(aula).then(atualizarLista);
    };


    function deleteAula(aula){
      aulaService.delete(aula).then(atualizarLista);
    }



})

myapp.controller('InstrutoresController', function($scope){
  $scope.controller = 'InstrutoresController';
})



















//

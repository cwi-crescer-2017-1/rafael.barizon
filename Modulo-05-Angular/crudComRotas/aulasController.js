myapp.controller('AulasController', function($scope, $routeParams, aulaService){
  $scope.controller = 'AulasController';
  let atualizarLista = function (){list();}
  $scope.insert = insert;
  $scope.update = update;
  $scope.delete = deleteAula;
  $scope.id = $routeParams.idUrl;



    // Ações executadas quando criar a controller
    if($scope.id != undefined){
      findById($scope.id); // buscar aula por id (passado na url)
    }
    atualizarLista(); // listar aulas

    // console.log($scope);

    // Funções internas

    function insert(aula) {
      if($scope.formIncluirAula.$valid){
        aulaService.insert(aula).then(atualizarLista)
        $scope.novaAula = {}
      }
    };

    function findById(id) {
      aulaService.findById(id).then(function (response) {
        $scope.aula = response.data;
      });
    };

    function list() {
      aulaService.list().then(function (response) {
        $scope.aulas = response.data;
      });
    }

    function update(aula) {
      if($scope.formAlterarAula.$valid)
      aulaService.update(aula).then(atualizarLista());
    };

    function deleteAula(aula){
      aulaService.delete(aula).then(atualizarLista);
    }

})

myapp.controller('InstrutoresController', function($scope, $routeParams,instrutorService){
  $scope.controller = 'InstrutoresController';
  let atualizarLista = function (){list();}
  $scope.insert = insert;
  $scope.update = update;
  $scope.delete = deleteInstrutor;
  $scope.id = $routeParams.idUrl;



    // Ações executadas quando criar a controller
    if($scope.id != undefined){
      findById($scope.id); // buscar instrutor por id (passado na url)
    }
    atualizarLista(); // listar instrutores
    listAulas();
    // console.log($scope);

    // Funções internas

    function insert(instrutor) {
      console.log($scope.formIncluirInstrutor);
      console.log($scope.formIncluirInstrutor);

      if(instrutor === undefined)
        return;

      if($scope.formIncluirInstrutor.$valid){
        console.log(instrutor.aula);
      instrutorService.insert(instrutor).then(atualizarLista)
      $scope.novoInstrutor = {};
      }
    };

    function findById(id) {
      instrutorService.findById(id).then(function (response) {
        $scope.instrutor = response.data;
      });
    };

    function list() {
      instrutorService.list().then(function (response) {
        $scope.instrutores = response.data;
      });
    }
    function listAulas() {
      instrutorService.listAulas().then(function (response) {
        $scope.aulas = response.data;
      });
    }

    function update(instrutor) {
      instrutorService.update(instrutor).then(atualizarLista);
    };

    function deleteInstrutor(instrutor){
      instrutorService.delete(instrutor).then(atualizarLista);
      // go
    }
})

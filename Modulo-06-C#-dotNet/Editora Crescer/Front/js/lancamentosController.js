let livros = [{ nome : 'Senhor dos Aneis',
  url : 'https://prodimage.images-bn.com/pimages/9780544003415_p0_v4_s192x300.jpg'
},
{
  nome : "Senhor dos Aneis",
  url : "https://prodimage.images-bn.com/pimages/9780544003415_p0_v4_s192x300.jpg"
}];
myapp.controller('LancamentosController', function($scope, $routeParams, lancamentosServices){
  $scope.controller = 'LancamentosController';
  $scope.lancamentos = [];
  $scope.livros = [];
  // let atualizarLista = function (){list();}
  // $scope.insert = insert;
  // $scope.update = update;
  // $scope.delete = deleteAula;
  // $scope.id = $routeParams.idUrl;
  let atulizarLancamentos = function(){ getLancamentos();}
  atulizarLancamentos();
  let atulizarLivros = function(){ getLivros();}
  atulizarLivros();
  console.log($scope.lancamentos);
  // console.log($scope.lancamentos);

    // Ações executadas quando criar a controller
    if($scope.id != undefined){
      findById($scope.id); // buscar aula por id (passado na url)
    }
  //  atualizarLista(); // listar aulas

    // console.log($scope);

    // Funções internas


    function getLancamentos() {
      lancamentosServices.lancamentos().then(function (response) {
        console.log("Response data " + response.data);
        $scope.lancamentos = response.data;
      });
      console.log("passo do then");
    }
    function getLivros() {
      lancamentosServices.livros().then(function (response) {
        console.log("Response data " + response.data);
        $scope.livros = response.data;
      });
      console.log("passo do then");
    }


});

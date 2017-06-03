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
  $scope.paginacao = [0];
  $scope.idUrl = $routeParams.idUrl;
  console.log("scope idUrl "+$scope.idUrl);
  // let atualizarLista = function (){list();}
  // $scope.insert = insert;
  // $scope.update = update;
  // $scope.delete = deleteAula;
  // $scope.id = $routeParams.idUrl;
  let atualizarLancamentos = function(){ getLancamentos();}
  atualizarLancamentos();
  let atualizarLivros = function(){ getLivros($routeParams.idUrl);}
    atualizarLivros();
  let atualizarPaginacao = function() { getPaginacao();}
  atualizarPaginacao();
  // let atualizarQtdLivros = function(){ getQtdLivros(6);}
  //   atualizarQtdLivros();


  console.log($scope.lancamentos);
  // console.log($scope.lancamentos);

    // Ações executadas quando criar a controller
    if($scope.id != undefined){
      findById($scope.id); // buscar aula por id (passado na url)
    }
  //  atualizarLista(); // listar aulas

    // console.log($scope);

    // Funções internas
    function getPaginacao() {
      lancamentosServices.paginacao().then(function (response) {
        if(response.data > 0)
          for(let a = 1; a <=response.data; a++)
            $scope.paginacao[a] = a;
      })
    }

    function getLancamentos() {
      lancamentosServices.lancamentos().then(function (response) {
        console.log("Response data " + response.data);

        for (let i = 0; i < response.data.length; i++) {
            if(i === 3) break;
            $scope.lancamentos[i]=response.data[i];
        }
      });
      console.log("passo do then");
    }
    function getLivros() {
      lancamentosServices.livros().then(function (response) {
        console.log("Response data " + response.data);
        for (let i = 0; i < response.data.length; i++) {
            if(i === 6) break;
            $scope.livros[i]=response.data[i];
        }
        // $scope.livros = response.data;
      });
      console.log("passo do then");
    }
    function getQtdLivros(qtdLivros) {
      lancamentosServices.qtdLivros(qtdLivros).then(function (response) {
        console.log("Response data " + response.data);
        for (let i = 0; i < response.data.length; i++) {
            if(i === 6) break;
            $scope.livros[i]=response.data[i];
        }
        // $scope.livros = response.data;
      });
      console.log("passo do then");
    }


});

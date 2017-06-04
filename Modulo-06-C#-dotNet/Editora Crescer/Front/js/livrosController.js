
myapp.controller('LivrosController', function($scope, $routeParams, lancamentosServices,$rootScope){
  $scope.controller = 'LivrosController';
  $scope.livros = [];
  $rootScope.paginacao = [0];
  $scope.idUrl = $routeParams.idUrl;
  // let atualizarLista = function (){list();}
  // $scope.insert = insert;
  // $scope.update = update;
  // $scope.delete = deleteAula;
  // $scope.id = $routeParams.idUrl;
  let atualizarPaginacao = function() { getPaginacao();}
  atualizarPaginacao();
  let atualizarQtdLivros = function(){ getQtdLivros($scope.idUrl);}
    atualizarQtdLivros();

    // Funções internas
    function getPaginacao() {
      lancamentosServices.paginacao().then(function (response) {
        if(response.data > 0)
          for(let a = 1; a <=response.data; a++)
            $rootScope.paginacao[a] = a;
      })
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
    }


});

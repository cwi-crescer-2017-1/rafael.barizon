myapp.controller('LancamentosController', function($scope, $routeParams, lancamentosServices,$rootScope){
  $scope.controller = 'LancamentosController';
  $scope.lancamentos = [];
  $scope.livros = [];
  $rootScope.paginacao = [0];
  $scope.idUrl = $routeParams.idUrl;

  let atualizarLancamentos = function(){ getLancamentos();}
  atualizarLancamentos();

  let atualizarLivros = function(){ getLivros($routeParams.idUrl);}
    atualizarLivros();

  let atualizarPaginacao = function() { getPaginacao();}
  atualizarPaginacao();

  console.log($scope.lancamentos);
    // Funções internas
    function getPaginacao() {
      lancamentosServices.paginacao().then(function (response) {
        if(response.data > 0)
          for(let a = 1; a <=response.data; a++)
            $rootScope.paginacao[a] = a;
      })
      console.log($rootScope.paginacao);
    };

    function getLancamentos() {
      lancamentosServices.lancamentos().then(function (response) {
        for (let i = 0; i < response.data.length; i++) {
            if(i === 3) break;
            $scope.lancamentos[i]=response.data[i];
        }
      });
    };

    function getLivros() {
      lancamentosServices.livros().then(function (response) {
        for (let i = 0; i < response.data.length; i++) {
            if(i === 6) break;
            $scope.livros[i]=response.data[i];
        }
      });
    };

    function getQtdLivros(qtdLivros) {
      lancamentosServices.qtdLivros(qtdLivros).then(function (response) {
        for (let i = 0; i < response.data.length; i++) {
            if(i === 6) break;
            $scope.livros[i]=response.data[i];
        }
      });
    };
});

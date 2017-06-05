myapp.controller('NavController', function($scope, $routeParams, lancamentosServices,$rootScope){
  $scope.search;
  $scope.assinar;



  function searchBy(pesquisa){
    if(pesquisa.metodo === 'Genero'){
      lancamentosServices.genero(pesquisa.campo).then(function (response) {

      })
    }else if (pesquisa.metodo === 'Autor'){

    }else {

    }
  }

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

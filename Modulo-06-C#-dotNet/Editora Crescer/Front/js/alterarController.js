
myapp.controller('AlterarController', function($scope, $routeParams, lancamentosServices){
  $scope.controller = 'AlterarController';
  $scope.update = alterarEscolhido;
  console.log("oi do Alterar");
  // $scope.escolhido = {};
  $scope.idUrl = $routeParams.idUrl;
  let atualizarEscolhido = function(){ getEscolhido($routeParams.idUrl);}
    atualizarEscolhido();
    // Funções internas
    function getEscolhido(id) {
      lancamentosServices.getLivroId(id).then(function (response) {
        $scope.escolhido = response.data;
        $scope.alterar = angular.copy( response.data );
        })
      };

    function alterarEscolhido(altera){
        console.log("oi");
      console.log(altera);
      lancamentosServices.alterar($scope.idUrl,altera).then(atualizarEscolhido);

    }

});

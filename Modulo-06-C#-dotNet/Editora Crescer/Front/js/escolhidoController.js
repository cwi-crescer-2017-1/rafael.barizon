
myapp.controller('EscolhidoController', function($scope, $routeParams, lancamentosServices){
  $scope.controller = 'EscolhidoController';
  console.log("oi do escolhido");
  $scope.escolhido = {};
  $scope.idUrl = $routeParams.idUrl;
  $scope.update = alterarEscolhido;
  let atualizarEscolhido = function(){ getEscolhido($routeParams.idUrl);}
    atualizarEscolhido();
    // Funções internas
    function getEscolhido(id) {
      lancamentosServices.escolhido(id).then(function (response) {
        $scope.escolhido = response.data;

        $scope.alterar = angular.copy( response.data );
        console.log($scope.alterar);
      })
        console.log($scope.escolhido);
      };
    function alterarEscolhido(alterar){
      console.log(alterar);
      lancamentosServices.alterar($scope.idUrl, alterar).then(atualizarEscolhido);
    }

});

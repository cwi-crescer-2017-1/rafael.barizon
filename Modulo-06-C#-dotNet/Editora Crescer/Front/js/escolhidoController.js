
myapp.controller('EscolhidoController', function($scope, $routeParams, lancamentosServices){
  $scope.controller = 'EscolhidoController';
  console.log("oi do escolhido");
  $scope.escolhido = {};
  let atualizarEscolhido = function(){ getEscolhido($routeParams.idUrl);}
    atualizarEscolhido();
    // Funções internas
    function getEscolhido(id) {
      lancamentosServices.escolhido(id).then(function (response) {
        $scope.escolhido = response.data;
      })
        console.log($scope.escolhido);
      };


});

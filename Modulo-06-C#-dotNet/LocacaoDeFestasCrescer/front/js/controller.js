FestaCrescer.controller('LoginController', function($scope, $routeParams, festaCrescerService){
  $scope.controller = 'LoginController';
  console.log("OIIIIIII");
  $scope.cliente = {};
  $scope.produtos = [{}];
  $scope.verificarCPF = verificarCPF;
  $scope.cadastrarCliente = cadastrarCliente;
  atualizarProdutosNaTela();
  function verificarCPF(cpf){
    festaCrescerService.getByCPF(cpf).then(function (response){
      if(response.data.dados != null){
        $scope.cliente = response.data.dados;
        $scope.cliente.DataNascimento = new Date($scope.cliente.DataNascimento);
      }
    })
  }
  function cadastrarCliente(cliente){
    if($scope.formCadastroDeCliente.$invalid){
      return;
    }
    console.log("tentando cadastrar");
    console.log(cliente);
    festaCrescerService.cadastrarCliente(cliente).then(function (response){
      console.log(response.data.dados);
    })
    console.log("terminou cadastro ou esperando cadastro");
  }

  function atualizarProdutosNaTela(){
    festaCrescerService.getProdutos().then(function (response){
      $scope.produtos = response.data.dados;
    })
  }
});

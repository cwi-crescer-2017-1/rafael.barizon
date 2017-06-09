FestaCrescer.controller('logoutController', function ($scope, authService){
  $scope.logout = authService.logout;
})
FestaCrescer.controller('LoginController', function($scope, $routeParams, festaCrescerService, $location, $rootScope){
  $scope.controller = 'LoginController';
  console.log("OIIIIIII");
  $scope.cliente = {};
  $scope.produtos = [{}];
  $scope.verificarCPF = verificarCPF;
  $scope.cadastrarCliente = cadastrarCliente;
  $scope.cadastrarPedido = cadastrarPedido;
  $scope.atrasados = [{}];
  $scope.pacotes = [{}];
  $scope.opcionais = [{}];
  $scope.pedido = {ClienteCPF:"", ProdutoID:"", ProdutoPacoteID:null, ProdutosOpcionaisIDs:null};
  $scope.gerarOrcamento = gerarOrcamento;
  $scope.orcamento;
  $scope.dataRelatorioMensal;
  $scope.obterRelatorio = obterRelatorio30Dias;
  $scope.getFinalizar = getFinalizar;
  $scope.usuario = $rootScope.usuario;
  $scope.valorGeral = 0;
  console.log($location.path());

  console.log("url agora: "  );
  function obterRelatorio30Dias(data, usuario){
    console.log(usuario);
    data = data.toISOString().split('T')[0];
    festaCrescerService.obterRelatorio30Dias(data, usuario.Gerente).then(function (response){
      $scope.relatorioMensal = response.data.dados;
  $scope.valorGeral = 0;
      for(a of $scope.relatorioMensal){
        $scope.valorGeral += a.ValorFinal;
        console.log($scope.valorGeral);
      }
    }).catch( function (){
      console.log("DEU MERDA PRA PEGAR RELATORIO");
    })
    console.log("termino a funcao de obter relatorio");
  }
  // $scope.ngInclude = 'login.html';
  if($location.path() === '/pedido'){
    atualizarProdutosNaTela();
    atualizarPacotesNaTela();
    atualizarOpcionaisNaTela();
  }

  atualizarAtrasadosNaTela();


  function getFinalizar(finalizar){
    festaCrescerService.finalizarPedido(finalizar).then( function (response){
      $scope.pedido = response.data.dados;
      console.log("volto da finalizacao");
    })
    console.log("termino a funcao de finalizar");
  }

  function verificarCPF(cpf){
    festaCrescerService.getByCPF(cpf).then(function (response){
      if(response.data.dados != null){
        $scope.cliente = response.data.dados;
        $scope.cliente.DataNascimento = new Date($scope.cliente.DataNascimento);
        $scope.pedido.ClienteCPF = response.data.dados.Cpf;
        console.log($scope.pedido.ClienteCPF);
      }
    }).catch( function (){
              $scope.cliente = {};
              $scope.cliente.Cpf = cpf;
              $scope.pedido.ClienteCPF = undefined;
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
      $scope.pedido.ClienteCPF = response.data.dados.Cpf;
      console.log($scope.pedido.ClienteCPF);
    })
    console.log("terminou cadastro ou esperando cadastro");
  }

  function atualizarProdutosNaTela(){
    festaCrescerService.getProdutos().then(function (response){
      $scope.produtos = response.data.dados;
    })
  }
  function atualizarPacotesNaTela(){
    festaCrescerService.getPacotes().then(function (response){
      $scope.pacotes = response.data.dados;
    })
  }
  function atualizarOpcionaisNaTela(){
    festaCrescerService.getOpcionais().then(function (response){
      $scope.opcionais = response.data.dados;
    })
  }
  function cadastrarPedido(pedido){
    console.log(pedido);
    festaCrescerService.cadastrarPedido(pedido).then(function (response){
      console.log("Pedido Cadastrado");
    })
    .catch( function (){
      console.log("deu merda");
    })
    console.log("Cadastro Pedido Em espera ateh ter response");
  }

  function gerarOrcamento(pedido){
    console.log(pedido);
    if(pedido.DataEntregaPrevista != null){
    festaCrescerService.gerarOrcamento(pedido).then(function (response){
      $scope.orcamento = response.data.dados;
      console.log("Orcamento eh " + $scope.orcamento);
    })
    .catch( function (){
      console.log("deu merda");
    })
    console.log("Orcamento Em espera ateh ter response");
    }

    console.log("termino orcamento");
  }

    function atualizarAtrasadosNaTela(){
      console.log("entro pra epgar atrasados");
      festaCrescerService.getAtrasados().then(function(response){
        $scope.atrasados = response.data.dados;
        console.log("ACHOOOOOOO");
      })
    }
});

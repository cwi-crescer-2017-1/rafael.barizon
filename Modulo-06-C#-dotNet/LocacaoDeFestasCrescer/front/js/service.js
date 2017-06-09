FestaCrescer.factory('festaCrescerService', function($http) {

  let urlBase = 'http://localhost:49793/api/';
//http://localhost:49793/api/clientes/12345678903

/// GET ///
  function getByCPF(cpf){
    return $http.get(urlBase + 'clientes/' + cpf);
  }
  function getProdutos(){
    return $http.get(urlBase + 'produtos');
  };
  function getPacotes() {
    return $http.get(urlBase + 'produtosPacote');
  };
  function getOpcionais() {
    return $http.get(urlBase + 'produtosOpcional');
  };
  function getAtrasados() {
    return $http.get(urlBase + 'pedidos/relatorioAtrasos');
  };
  function obterRelatorio30Dias(data, gerente) {
    return $http.get(urlBase + 'pedidos/relatorioMensal/'+ gerente +'/'+ data);
  };
  function gerarOrcamento(model) {
    return $http.post(urlBase + 'pedidos/orcamento', model);
  };
  // function finalizarPedido(id){
  //   return $http.get(urlBase + 'pedidos/' + id);
  // }
/// POST ///
  function cadastrarCliente(cliente){
    return $http.post(urlBase + 'clientes', cliente);
  }
  function cadastrarPedido(modelPedido){
    return $http.post(urlBase + 'pedidos', modelPedido);
  }

  function finalizarPedido(id){
    return $http.put(urlBase + 'pedidos/' + id);
  }


  return {
    getByCPF: getByCPF,
    getProdutos: getProdutos,
    getPacotes: getPacotes,
    getOpcionais: getOpcionais,
    getAtrasados: getAtrasados,
    gerarOrcamento: gerarOrcamento,
    obterRelatorio30Dias: obterRelatorio30Dias,

    finalizarPedido:finalizarPedido,
    cadastrarCliente: cadastrarCliente,
    cadastrarPedido: cadastrarPedido

  };
});

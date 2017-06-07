FestaCrescer.factory('festaCrescerService', function($http) {

  let urlBase = 'http://localhost:49793/api/';
//http://localhost:49793/api/clientes/12345678903
  function getByCPF(cpf){
    return $http.get(urlBase + 'clientes/' + cpf);
  }
  function cadastrarCliente(cliente){
    return $http.post(urlBase + 'clientes/', cliente);
  }
  function getProdutos(){
    return $http.get(urlBase + '/produtos');
  };
  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula/' + id);
  };
  function atualizar(aula){
    return $http.put(urlBase + '/aula/' + aula.id, aula);
  };
  function incluir(aula){
    return $http.post(urlBase + '/aula', aula);
  };
  function deletar(aula){
    return $http.delete(urlBase + '/aula/' + aula.id)
  }
  return {
    getByCPF: getByCPF,
    cadastrarCliente: cadastrarCliente,
    getProdutos: getProdutos
  };
});

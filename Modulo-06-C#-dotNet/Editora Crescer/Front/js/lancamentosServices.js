myapp.factory('lancamentosServices', function($http) {
  //AQUI VAI SER A URL DA APLICACAO  - DO CSHARP .NET.....
  let urlBase = 'http://localhost:55030/api/livros/';
  function getTodosLancamentos(){
    return $http.get(urlBase + 'Lancamento');
  };
  function getTodosLivros(){
    return $http.get(urlBase );
  };
  function getQtdLivros(qtdLivros){
    return $http.get(urlBase +'qtdLivros/' +qtdLivros);
  };
  function getPaginacao(){
    return $http.get(urlBase + 'qtd')
  };
  function getEscolhido(id){
    return $http.get(urlBase + 'escolhido/' +id );
  };
  function putEscolhido(id, alterar){
    return $http.put(urlBase+id, alterar);
  }
  function getLivroEscolhido(id){
    return $http.get(urlBase + id);
  }
  return {
    lancamentos: getTodosLancamentos,
    livros: getTodosLivros,
    qtdLivros: getQtdLivros,
    paginacao: getPaginacao,
    escolhido: getEscolhido,
    alterar: putEscolhido,
    getLivroId: getLivroEscolhido
  };
});

myapp.factory('lancamentosServices', function($http) {
  //AQUI VAI SER A URL DA APLICACAO  - DO CSHARP .NET.....
  let urlBase = 'http://localhost:55030/api/Livros';
  function getTodosLancamentos(){
    return $http.get(urlBase + '/Lancamento');
  };
  function getTodosLivros(){
    return $http.get(urlBase );
  };
  function getQtdLivros(qtdLivros){
    return $http.get(urlBase +'/qtdLivros/' +qtdLivros);
  };
  function getPaginacao(){
    return $http.get(urlBase + '/qtd')
  }
  return {
    lancamentos: getTodosLancamentos,
    livros: getTodosLivros,
    qtdLivros: getQtdLivros,
    paginacao: getPaginacao
  };
});

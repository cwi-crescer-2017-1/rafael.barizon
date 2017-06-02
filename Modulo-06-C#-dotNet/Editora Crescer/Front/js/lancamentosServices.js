myapp.factory('lancamentosServices', function($http) {
  //AQUI VAI SER A URL DA APLICACAO  - DO CSHARP .NET.....
  let urlBase = 'http://localhost:55030/api';
  function getTodosLancamentos(){
    return $http.get(urlBase + '/Livros/Lancamento');
  };
  function getTodosLivros(){
    return $http.get(urlBase + '/Livros');
  };
  return {
    lancamentos: getTodosLancamentos,
    livros: getTodosLivros
  };
});

myapp.factory('instrutorService', function($http) {

  let urlBase = 'http://localhost:3000';
  let urlInstrutor = '/instrutor/';
  function getTodosOsInstrutores(){
    return $http.get        (urlBase + urlInstrutor);
  };
  function getInstrutorPorId(id) {
    return $http.get        (urlBase + urlInstrutor + id);
  };
  function atualizar(instrutor){
    instrutor = inicializar(instrutor);
    return $http.put        (urlBase + urlInstrutor + instrutor.id, instrutor);
  };
  function incluir(instrutor){
    instrutor = inicializar(instrutor);
    return $http.post       (urlBase + urlInstrutor , instrutor);
  };
  function deletar(instrutor){
    return $http.delete     (urlBase + urlInstrutor + instrutor.id)
  }
  function getTodasAsAulas(){
    return $http.get(urlBase + '/aula');
  };

  function inicializar(instrutor){
    instrutor.aula = instrutor.aula || [];
    instrutor.urlFoto = instrutor.urlFoto || "https://goo.gl/b264ge";
    return instrutor;
  }
  return {
    list: getTodosOsInstrutores,
    findById: getInstrutorPorId,
    update: atualizar,
    insert: incluir,
    listAulas: getTodasAsAulas,
    delete: deletar
  };
});

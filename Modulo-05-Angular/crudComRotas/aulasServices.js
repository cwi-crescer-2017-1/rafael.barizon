myapp.factory('aulaService', function($http) {

  let urlBase = 'http://localhost:3000';

  function getTodasAsAulas(){
    return $http.get(urlBase + '/aula');
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
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    insert: incluir,
    delete: deletar
  };
});

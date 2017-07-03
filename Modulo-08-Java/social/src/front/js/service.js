Social.factory('social', function($http) {

  let urlBase = 'http://localhost:9090/';

  function getByUsername(username){
    return $http.post(urlBase + 'userprofile/' , username);
  }
  function postContentWithUser(post) {
    return $http.post(urlBase + 'postcontents/save', post);
  }
  function getPostsUser(id) {
    console.log(id + " dentro da service pra ver se ta undefined");
    return $http.get(urlBase + 'postcontents/'+id)
  }
  function signInSocial(usersocial) {
    return $http.post(urlBase + 'usersocial/cadastro', usersocial);
  }
  function signInProfile(userprofile) {
    return $http.post(urlBase + 'userprofile/cadastro', userprofile);
  }
  function getUsersByName(name) {
    return $http.get(urlBase + 'userprofile/name/' + name);
  }
  function getUserprofileById(idUser) {
    return $http.get(urlBase + 'userprofile/' + idUser);
  }

  return {
      getByUsername:getByUsername,
postContentWithUser:postContentWithUser,
       getPostsUser:getPostsUser,
       signInSocial:signInSocial,
      signInProfile:signInProfile,
     getUsersByName:getUsersByName,
 getUserprofileById:getUserprofileById
  };
});

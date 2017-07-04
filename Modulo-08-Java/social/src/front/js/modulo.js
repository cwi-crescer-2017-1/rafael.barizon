var Social = angular.module('social',['ngRoute', 'auth']);

Social.config(function ($routeProvider) {

  $routeProvider
    .when('/login', {
      controller: 'LoginController2',
      templateUrl: 'login.html'
    })
    .when('/signin', {
      controller: 'LoginController2',
      templateUrl: 'signin.html'
    })
    .when('/feed', {
      controller: 'FeedController',
      templateUrl: 'feed.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/changePassword', {
      controller: 'RequestController',
      templateUrl: 'changePassword.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/profile', {
      controller: 'ProfileController',
      templateUrl: 'profile.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/edit', {
      controller: 'ProfileController',
      templateUrl: 'edit.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/profile/:idUser', {
      controller: 'ProfileController',
      templateUrl: 'profile0.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/profiles', {
      controller: 'ProfileController',
      templateUrl: 'profiles.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/request', {
      controller: 'RequestController',
      templateUrl: 'request.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .otherwise({
      redirectTo: '/login'
    });
});

Social.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/logged-user',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/feed',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});

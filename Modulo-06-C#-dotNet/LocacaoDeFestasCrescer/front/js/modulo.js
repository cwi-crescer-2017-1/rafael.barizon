var FestaCrescer = angular.module('festaCrescer',['ngRoute', 'auth']);

FestaCrescer.config(function ($routeProvider) {

  $routeProvider
    .when('/login', {
      controller: 'LoginController2',
      templateUrl: 'login.html'
    })
    .when('/pedido', {
      controller: 'LoginController',
      templateUrl: 'pedido.html',
      resolve: {

        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/atrasos', {
      controller: 'LoginController',
      templateUrl: 'atrasos.html',
      resolve: {

        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/relatorio', {
      controller: 'LoginController',
      templateUrl: 'relatorio.html',
      resolve: {

        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/finalizar', {
      controller: 'LoginController',
      templateUrl: 'finalizar.html',
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

FestaCrescer.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:49793/api/usuarios/auth',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/pedido',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});

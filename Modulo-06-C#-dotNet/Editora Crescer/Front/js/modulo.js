var myapp = angular.module('myapp', ['ngRoute', 'auth']);

myapp.config(function ($routeProvider) {

  $routeProvider
    .when('/livros', {
      controller: 'LancamentosController',
      templateUrl: 'lancamentos.html'
    })
    .when('/livros/:idUrl', {
      controller: 'LivrosController',
      templateUrl: 'livros.html'
    })
    .when('/escolhido/:idUrl', {
      controller: 'EscolhidoController',
      templateUrl: 'escolhido.html'
    })
    .when('/alterar/:idUrl', {
      controller: 'AlterarController',
      templateUrl: 'alterar.html'
    })
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'login.html'
    })
    .when('/administrativo', {
      controller: 'administrativoController',
      templateUrl: 'administrativo.html',
      resolve: {
        // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .otherwise({
      redirectTo: '/livros'
    });
});

myapp.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:55030/api/usuarios',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/privado',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});
























//

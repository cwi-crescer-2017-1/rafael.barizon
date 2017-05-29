var modulo = angular.module('chat-app', []);

modulo.controller('ChatController', function ($scope, chatService) {
    $scope.mensagemsChat = {};
    $scope.enviarMensagem = enviarMensagem;
    $scope.usuarios = {};
    $scope.usuario = {};
    $scope.usuario.nome = window.localStorage.getItem('NovoUsuario.nome');
    $scope.usuario.url = window.localStorage.getItem("NovoUsuario.url");


    localStorage();
    obterChat();
    obterUsuarios();
    console.log($scope.usuarios);
    obterUsuario($scope.usuario.nome);

    setInterval(() => {
      obterChat();
    }, 500);
    function obterChat() {
        chatService
        .obterChat()
        .then(response => {
            $scope.mensagemsChat = response.data;
        })
    }
    function obterUsuarios() {
        chatService
        .obterUsuarios()
        .then(response => {
            console.log(response.data);
            $scope.usuarios = response.data;
            console.log($scope.usuarios)
        })
    }
    function obterUsuario(nome) {
      console.log(nome);
        chatService
        .obterUsuario(nome)
        .then(response => {
          console.log($scope.usuario);
          console.log(response.data);
            // $scope.usuario.nome = response.data.Nome;
            // $scope.usuario.url = response.data.url;
            // $scope.usuario.id = response.data.id;
            $scope.usuario = response.data;
            console.log($scope.usuario);
        })
    }

    function enviarMensagem(mensagem) {
      console.log($scope.usuario.id);
        mensagem.IDAutor = $scope.usuario.id;
        chatService
        .enviarMensagem(mensagem)
        .then(mensagemsChat => {
            obterChat();
        })
        $scope.mensagem = {};
    }

    function enviarUsuario(usuario) {
        chatService
        .enviarUsuario(usuario)
        .then(usuarios => {
            obterUsuarios();
        })
    }

    function localStorage(){
      console.log($scope.usuario.nome);
       if($scope.usuario.nome == null){
        var nome = prompt("Digite seu nome:");
        var foto = prompt("Link da sua foto:");
        window.localStorage.setItem('NovoUsuario.nome', nome );
        $scope.usuario.nome = window.localStorage.getItem('NovoUsuario.nome');
        window.localStorage.setItem('NovoUsuario.url', foto );
        $scope.usuario.url = window.localStorage.getItem('NovoUsuario.url');
        }
      enviarUsuario($scope.usuario);
    }
});

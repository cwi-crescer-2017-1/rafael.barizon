var modulo = angular.module('chat-app', []);

modulo.controller('ChatController', function ($scope, chatService) {
    $scope.mensagemsChat = {};
    $scope.enviarMensagem = enviarMensagem;
    $scope.usuario = {};
    $scope.usuario.nome = window.localStorage.getItem('NovoUsuario.nome');
    $scope.usuario.foto = window.localStorage.getItem("NovoUsuario.foto");


    localStorage();
    obterChat();

    // setInterval(() => {
    //   obterChat();
    // }, 500);
    function obterChat() {
        chatService
        .obterChat()
        .then(response => {
            $scope.mensagemsChat = response.data;
        })
    }

    function enviarMensagem(mensagem) {
        mensagem.autor = $scope.usuario.nome;
        chatService
        .enviarMensagem(mensagem)
        .then(mensagemsChat => {
            obterChat();
        })
        $scope.mensagem = {};
    }

    function localStorage(){
      console.log($scope.usuario.nome);
       if($scope.usuario.nome === 'null'){
        var nome = prompt("Digite seu nome:");
        var foto = prompt("Link da sua foto:");
        window.localStorage.setItem('NovoUsuario.nome', nome );
        $scope.usuario.nome = window.localStorage.getItem('NovoUsuario.nome');
        window.localStorage.setItem('NovoUsuario.foto', foto );
        $scope.usuario.foto = window.localStorage.getItem('NovoUsuario.foto');
        }
    }
});

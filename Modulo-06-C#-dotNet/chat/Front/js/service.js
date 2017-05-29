modulo.factory("chatService", function ($http) {
    return ({
        obterChat: obterChat,
        enviarMensagem: enviarMensagem
    });

    function obterChat() {
        return $http.get("http://localhost:59785/api/chat");
    }

    function enviarMensagem(mensagem) {
        return $http({
            method: "post",
            url: "http://localhost:59785/api/chat",
            data: {"mensagem": mensagem.mensagem,
                  "autor": mensagem.autor}
            })
    }
});

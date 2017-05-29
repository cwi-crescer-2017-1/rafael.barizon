modulo.factory("chatService", function ($http) {
    return ({
        obterChat: obterChat,
        enviarMensagem: enviarMensagem,
        obterUsuarios: obterUsuarios,
        enviarUsuario: enviarUsuario,
        obterUsuario: obterUsuario,
    });

    function obterChat() {
        return $http.get("http://localhost:59785/api/chat");
    }

    function obterUsuarios() {
        return $http.get("http://localhost:59785/api/usuarios");
    }
    function obterUsuario(nome) {
        return $http.get("http://localhost:59785/api/usuarios?nome="+nome);
    }

    function enviarMensagem(mensagem) {
        return $http({
            method: "post",
            url: "http://localhost:59785/api/chat",
            data: {"mensagem": mensagem.mensagem,
                  "IDAutor": mensagem.idAutor
                  }
            })
    }
    function enviarUsuario(usuario) {
        return $http({
            method: "post",
            url: "http://localhost:59785/api/usuarios",
            data: {"Nome": usuario.nome,
                  "url": usuario.url
                  }
            })
    }
});

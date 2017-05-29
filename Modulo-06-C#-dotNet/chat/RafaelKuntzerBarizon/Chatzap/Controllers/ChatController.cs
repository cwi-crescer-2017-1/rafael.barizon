using Chatzap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Web.Http;

namespace Chatzap.Controllers
{
    public class ChatController : ApiController
    {
        private static List<Mensagem> mensagemsChat = new List<Mensagem>();

        public List<Mensagem> Get()
        {
            return mensagemsChat;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
                return BadRequest();
            else
            {
                var usuario = UsuariosController.Usuarios.FindIndex(u => u.id == mensagem.IDAutor);

                string pattern = @"(andre)|(nunes)";
                
                RegexOptions options = RegexOptions.IgnoreCase;
                Regex regex = new Regex(pattern, options);
                string illuminati = @"$$$$$$$$$";
                var mensagemOriginal = mensagem.mensagem;

                mensagem.mensagem = regex.Replace(mensagemOriginal, illuminati);
                mensagem.id = mensagemsChat.Count;
                
                mensagemsChat.Add(mensagem);
                return Ok();

                
            }
        }

    }
}

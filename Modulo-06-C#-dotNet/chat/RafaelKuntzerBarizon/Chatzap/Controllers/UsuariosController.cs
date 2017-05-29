using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Chatzap.Controllers
{
    public class UsuariosController : ApiController
    {
        public static List<Usuario> Usuarios = new List<Usuario>();
        private int idUsuarios = 0;
        public List<Usuario> Get()
        {
            return Usuarios;
        }

        public Usuario Get(string nome)
        {
            if(Usuarios.Count > 0)
            return Usuarios.Where(usuario => usuario.nome == nome).ToList()[0];

            return null;
        }   

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
                return BadRequest();
            else
            {
                usuario.id = idUsuarios++;
                if (usuario.url == null || usuario.url == "")
                    usuario.url = "https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png";

                Usuarios.Add(usuario);
                return Ok();
            }
        }
    }
}

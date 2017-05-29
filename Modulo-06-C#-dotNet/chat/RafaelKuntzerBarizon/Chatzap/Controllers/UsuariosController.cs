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
        private static List<Usuario> Usuarios = new List<Usuario>();

        public List<Usuario> Get()
        {
            return Usuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
                return BadRequest();
            else
            {
                usuario.id = Usuarios.Count;
                if (usuario.url == null || usuario.url == "")
                    usuario.url = "https://media.lovemondays.com.br/logos/e3b058/cwi-software-original.png";

                Usuarios.Add(usuario);
                return Ok();
            }
        }
    }
}

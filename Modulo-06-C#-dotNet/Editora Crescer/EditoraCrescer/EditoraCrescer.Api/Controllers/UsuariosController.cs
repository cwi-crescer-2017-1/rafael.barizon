using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Usuarios")]
    public class UsuariosController : ApiController, IDisposable
    {
        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        [Route("{auth}")]
        [HttpGet]
        public IHttpActionResult Get(string auth)
        {
            var autorizacao = repositorio.AuthUsuario(auth);
            if (autorizacao)
                return Ok("Autenticado");
            else
                return BadRequest();
        }

    }
}

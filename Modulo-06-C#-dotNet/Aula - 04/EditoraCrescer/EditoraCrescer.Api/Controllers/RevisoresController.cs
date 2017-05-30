using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            if (repositorio.Inserir(revisor))
                return Ok(revisor);
            return BadRequest();
        }

        public IHttpActionResult Delete(int id)
        {
            if (repositorio.Delete(id))
                return Ok();
            return BadRequest();
        }
    }
}

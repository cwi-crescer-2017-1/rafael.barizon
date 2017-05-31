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
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController, IDisposable
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }
        //GET    api/Revisores/{id}
        [Route("{id}")]
        [HttpGet]
        public IHttpActionResult GetId(int id)
        {
            var revisor = repositorio.ObterByID(id);

            return Ok(revisor);
        }

        public IHttpActionResult Post(Revisor revisor)
        {
            if (repositorio.Inserir(revisor))
                return Ok(revisor);
            return BadRequest();
        }
        [Route("{id}")]
        [HttpPut]
        public IHttpActionResult Put(int id, Revisor revisor)
        {
            if (repositorio.Alterar(id, revisor))
                return Ok(revisor);
            return BadRequest();
        }


        [Route("{id}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            if (repositorio.Delete(id))
                return Ok();
            return BadRequest();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController, IDisposable
    {
        private AutorRepositorio repositorio = new AutorRepositorio();


        //GET api/Autores(busca todos)
        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();
            return Ok(autores);
        }
        //GET    api/Autores/{id}
        [Route("{id}")]
        [HttpGet]
        public IHttpActionResult GetAutorId(int id)
        {
            var autor = repositorio.ObterId(id);
            return Ok(autor);
        }
        //GET    api/Autores/{id}/Livros 
        [Route("{id}/Livros")]
        [HttpGet]
        public IHttpActionResult GetAutorLivros(int id)
        {
            var livrosAutor = repositorio.ObterLivrosAutorId(id);
            return Ok(livrosAutor);
        }
        //POST api/Autores(apenas cria, não altera)
        public IHttpActionResult Post(Autor autor)
        {
            if (repositorio.Incluir(autor))
                return Ok(autor);
            return BadRequest();
        }
        //DELETE api/Autores/{id}(deleta pelo id)
        [Route("{id}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            if (repositorio.Delete(id))
                return Ok();
            return BadRequest();
        }
        //PUT    api/Autores/{id}
        [Route("{id}")]
        public IHttpActionResult Put(int id, Autor autor)
        {
            if (repositorio.Alterar(id, autor))
                return Ok(autor);
            return BadRequest();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}

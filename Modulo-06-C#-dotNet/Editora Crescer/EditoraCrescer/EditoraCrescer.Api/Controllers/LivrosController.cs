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
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController, IDisposable
    {
        private LivroRepositorio repositorio = new LivroRepositorio();
        
        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(livros);
        }
        [Route("{isbn:int}")]
        [HttpGet]
        public IHttpActionResult GetIsbn(int isbn)
        {
            var livro = repositorio.ObterIsbn(isbn);

            return Ok(livro);
        }
        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult GetGenero(string genero)
        {
            var livros = repositorio.ObterGenero(genero);

            return Ok(livros);
        }
        [Route("lancamento")]
        [HttpGet]
        public IHttpActionResult GetLancamento()
        {
            var livros = repositorio.ObterLancamento();

            return Ok(livros);
        }
        public IHttpActionResult Post(Livro livro)
        {
            if (repositorio.Inserir(livro))
                return Ok(livro);
            return BadRequest();
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Delete(int isbn)
        {
            if (repositorio.Delete(isbn))
                return Ok();
            return BadRequest();
        }

        //PUT    api/Livros/{isbn}
        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            if (repositorio.Alterar(isbn, livro))
                return Ok(livro);
            return BadRequest();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

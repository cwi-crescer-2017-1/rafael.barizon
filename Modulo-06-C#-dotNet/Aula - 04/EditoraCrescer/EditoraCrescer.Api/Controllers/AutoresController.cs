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
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();


        //GET api/Autores(busca todos)
        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();
            return Ok(autores);
        }
        //POST api/Autores(apenas cria, não altera)
        public IHttpActionResult Post(Autor autor)
        {
            if (repositorio.Incluir(autor))
                return Ok(autor);
            return BadRequest();
        }
        //DELETE api/Autores/{id}(deleta pelo id)
        public IHttpActionResult Delete(int id)
        {
            if (repositorio.Delete(id))
                return Ok();
            return BadRequest();
        }
    }
}

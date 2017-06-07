using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Api.Controllers
{
    [RoutePrefix("api/ProdutosPacote")]
    public class ProdutosPacoteController : ControllerBasica, IDisposable
    {
        readonly ProdutoPacoteRepositorio _produtoPacoteRepositorio;

        public ProdutosPacoteController()
        {
            _produtoPacoteRepositorio = new ProdutoPacoteRepositorio();
        }

        [HttpGet]
        public HttpResponseMessage Get()
        {
            var ProdutosPacote = _produtoPacoteRepositorio.ObterTodos();
            if (ProdutosPacote == null)
            {
                return ResponderErro();
            }
            else
            {
                return ResponderOK(ProdutosPacote);
            }
        }
        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage Get(int id)
        {
            var ProdutoPacote = _produtoPacoteRepositorio.ObterById(id);
            if (ProdutoPacote == null)
            {
                return ResponderErro();
            }
            else
            {
                return ResponderOK(ProdutoPacote);
            }
        }

        protected override void Dispose(bool disposing)
        {
            _produtoPacoteRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Produtos")]
    public class ProdutosController : ControllerBasica, IDisposable
    {
        readonly ProdutoRepositorio _produtoRepositorio;

        public ProdutosController()
        {
            _produtoRepositorio = new ProdutoRepositorio();
        }
        
        [HttpGet]
        public HttpResponseMessage Get()
        {
            var produtos = _produtoRepositorio.ObterTodos();
            if( produtos == null)
            {
                return ResponderErro("Nao tem produtos registrados");
            }
            else
            {
                return ResponderOK(produtos);
            }
        }
        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage Get(int id)
        {
            var produto = _produtoRepositorio.ObterById(id);
            if (produto == null)
            {
                return ResponderErro("Produto nao encontrado");
            }
            else
            {
                return ResponderOK(produto);
            }
        }

        protected override void Dispose(bool disposing)
        {
            _produtoRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

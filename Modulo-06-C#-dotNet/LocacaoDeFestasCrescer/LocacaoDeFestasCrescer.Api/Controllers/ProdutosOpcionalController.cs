using LocacaoDeFestasCrescer.Dominio.Entidades;
using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Api.Controllers
{
    [RoutePrefix("api/ProdutosOpcional")]
    public class ProdutosOpcionalController : ControllerBasica, IDisposable
    {
        readonly ProdutoOpcionalRepositorio _produtoOpcionalRepositorio;

        public ProdutosOpcionalController()
        {
            _produtoOpcionalRepositorio = new ProdutoOpcionalRepositorio();
        }

        [HttpGet]
        public HttpResponseMessage Get()
        {
            var ProdutosOpcionais = _produtoOpcionalRepositorio.ObterTodos();
            if (ProdutosOpcionais == null)
            {
                return ResponderErro("Opcionais Inexistentes");
            }
            else
            {
                return ResponderOK(ProdutosOpcionais);
            }
        }
        //[HttpPut, Route("{id:int}")]
        //public HttpResponseMessage Put(int id, int quantidade)
        //{
        //    var ProdutoOpcional = _produtoOpcionalRepositorio.ObterId(id);
        //    if(ProdutoOpcional != null)
        //    {
        //        if(ProdutoOpcional.Quantidade > quantidade)
        //        {
        //            ProdutoOpcional.AlterarQuantidade(quantidade);
        //            _produtoOpcionalRepositorio.AtualizarEstoque(ProdutoOpcional);
        //            return ResponderOK("Estoque Atualizado");
        //        }
        //    }
        //    return ResponderErro("Produto ou Quantidade inexistente");
        //}

        protected override void Dispose(bool disposing)
        {
            _produtoOpcionalRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

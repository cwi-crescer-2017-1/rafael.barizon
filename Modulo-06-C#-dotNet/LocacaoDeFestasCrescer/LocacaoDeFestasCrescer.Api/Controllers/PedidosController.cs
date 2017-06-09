using LocacaoDeFestasCrescer.Api.Models;
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
    [RoutePrefix("api/Pedidos")]
    public class PedidosController : ControllerBasica, IDisposable
    {
        readonly PedidoRepositorio _pedidoRepositorio;

        public PedidosController()
        {
            _pedidoRepositorio = new PedidoRepositorio();
        }

        [HttpGet]
        public HttpResponseMessage ObterTodos()
        {
            var pedidos = _pedidoRepositorio.ObterTodos();
            if (pedidos == null)
            {
                return ResponderErro("Nao existem pedidos registrados");
            }
            return ResponderOK(pedidos);
        }
        [Route("relatorioMensal/{gerente:bool}/{data:datetime}")]
        [HttpGet]
        public HttpResponseMessage ObterRelatorioMensal(bool gerente, DateTime data)
        {

            if (gerente == false)
            {
                return ResponderErro("Usuario nao eh Gerente");
            }
            else
            {
                var relatorio = _pedidoRepositorio.ObterRelatorio(data);

                if (relatorio == null)
                {
                    return ResponderErro("Nao existe Relatorio para os ultimos 30 dias da data informada");
                }
                else
                {
                    return ResponderOK(relatorio);
                }
            }

        }
        
        [Route("relatorioAtrasos")]
        [HttpGet]
        public HttpResponseMessage ObterRelatorioMensal(Usuario gerente)
        {
            if (gerente==null || gerente.Gerente == false)
            {
                return ResponderErro("Usuario nao eh Gerente");
            }
            else
            {
                var atrasados = _pedidoRepositorio.ObterAtrasos();
                if (atrasados == null)
                {
                    return ResponderErro("Nao existem clientes atrasados");
                }
                else
                {
                    return ResponderOK(atrasados);
                }
            }
        }

        [HttpPost, Route]
        public HttpResponseMessage Post([FromBody]RegistrarPedidoModel model)
        {
            //return ResponderOK();
            var cliente = new ClienteRepositorio().ObterClienteCPF(model.ClienteCPF);
            var produto = new ProdutoRepositorio().ObterById(model.ProdutoID);
            ProdutoPacote produtoPacote = null;
            if (model.ProdutoPacoteID != null)
            {
                produtoPacote = new ProdutoPacoteRepositorio().ObterById(model.ProdutoPacoteID.Value);
            }

            List<ProdutoOpcional> produtosOpcionais = null;
            if (model.ProdutosOpcionaisIDs != null)
            {
                produtosOpcionais = new List<ProdutoOpcional>();
                foreach (var idOpcionais in model.ProdutosOpcionaisIDs)
                {
                    var opcionalBanco = new ProdutoOpcionalRepositorio().ObterId(idOpcionais);
                    if (opcionalBanco.VerificarQuantidade(1))
                        opcionalBanco.AlterarQuantidade(1);
                    else return ResponderErro(opcionalBanco.Descricao + " nao possui quantidade suficiente");
                    produtosOpcionais.Add(opcionalBanco);
                }
            }

            var pedido = new Pedido(cliente, produto, produtoPacote, produtosOpcionais, model.DataEntregaPrevista);

            if (pedido.Validar())
            {
                _pedidoRepositorio.Criar(pedido);
                return ResponderOK(pedido);
            }
            return ResponderErro(pedido.Mensagens);
        }
        [Route("orcamento")]
        [HttpPost]
        public HttpResponseMessage GetOrcamento([FromBody]RegistrarPedidoModel model)
        {
            var cliente = new Cliente();

            var produto = new ProdutoRepositorio().ObterById(model.ProdutoID);
            ProdutoPacote produtoPacote = null;
            if (model.ProdutoPacoteID != null)
            {
                produtoPacote = new ProdutoPacoteRepositorio().ObterById(model.ProdutoPacoteID.Value);
            }

            List<ProdutoOpcional> produtosOpcionais = null;
            if (model.ProdutosOpcionaisIDs != null)
            {
                produtosOpcionais = new List<ProdutoOpcional>();
                foreach (var idOpcionais in model.ProdutosOpcionaisIDs)
                {
                    var opcionalBanco = new ProdutoOpcionalRepositorio().ObterId(idOpcionais);
                    if (opcionalBanco.VerificarQuantidade(1))
                        opcionalBanco.AlterarQuantidade(1);
                    else return ResponderErro(opcionalBanco.Descricao + " nao possui quantidade suficiente");
                    produtosOpcionais.Add(opcionalBanco);
                }
            }

            var pedido = new Pedido(cliente, produto, produtoPacote, produtosOpcionais, model.DataEntregaPrevista);

            return ResponderOK(pedido.ValorTotal);
        }

        [HttpPut, Route("{id:int}")]
        public HttpResponseMessage finalizarPedido(int id)
        {
            var pedido = _pedidoRepositorio.ObterById(id);
            if(pedido == null)
            {
                return ResponderErro("Pedido nao encontrado para este ID");
            }
            else
            {
                pedido.CalcularValorReal();
                _pedidoRepositorio.FinalizarPedido(pedido);
                return ResponderOK(pedido);
            }

        }
        protected override void Dispose(bool disposing)
        {
            _pedidoRepositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

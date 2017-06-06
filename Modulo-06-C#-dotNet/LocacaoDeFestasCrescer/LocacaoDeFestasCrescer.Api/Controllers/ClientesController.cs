using LocacaoDeFestasCrescer.Dominio.Entidades;
using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Clientes")]
    public class ClientesController : ApiController, IDisposable
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [Route("{cpf}")]
        [HttpGet]
        public HttpResponseMessage GetByCPF(string cpf)
        {
            var Cliente = repositorio.ObterClienteCPF(cpf);
            if (Cliente == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                    new { mensagens = new string[] { "CPF nao Encontrado" } });
            }
            else
            {
                return Request.CreateResponse(HttpStatusCode.OK,
                   new { dados = Cliente });
            }
        }
        
        [HttpPost]
        public HttpResponseMessage Post(Cliente Cliente)
        {
            if (Cliente.Validar())
            {
                repositorio.IncluirCliente(Cliente);
                return Request.CreateResponse(HttpStatusCode.OK, new { dados = Cliente });
            }
            else
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = Cliente.Mensagens });
            }
        }

        [Route("{cpf}")]
        [HttpPut]
        public HttpResponseMessage Put(string cpf, Cliente cliente)
        {
            var clienteRepositorio = repositorio.ObterClienteCPF(cpf);
            if (clienteRepositorio != null)
            {
                clienteRepositorio.AlterarCliente(cliente.Nome, cliente.Cpf, cliente.Endereco, cliente.Genero, cliente.DataNascimento);
                if(clienteRepositorio.Validar())
                    repositorio.AlterarCliente(clienteRepositorio);
                // adicionar controller basica 
                //return ResponderOk(clienteRepositorio);
                return Request.CreateResponse(HttpStatusCode.OK, new { dados = clienteRepositorio });
            }
            else
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest,
                    new { mensagens = "Cliente não Existe" });
            }
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

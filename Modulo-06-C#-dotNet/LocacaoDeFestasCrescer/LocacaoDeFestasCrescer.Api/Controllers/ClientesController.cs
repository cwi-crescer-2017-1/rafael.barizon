using LocacaoDeFestasCrescer.Dominio.Entidades;
using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Api.Controllers
{
    [RoutePrefix("api/clientes")]
    public class ClientesController : ControllerBasica, IDisposable
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [HttpGet, Route("{cpf}")]
        public HttpResponseMessage GetByCPF(string cpf)
        {
            var Cliente = repositorio.ObterClienteCPF(cpf);
            if (Cliente == null)
            {
                return ResponderErro("CPF nao Encontrado");
            }
            else
            {
                return ResponderOK(Cliente);
            }
        }

        [HttpPost, Route]
        public HttpResponseMessage Post([FromBody]Cliente cliente)
            {
            if(cliente == null)
            {
                return ResponderErro("Cliente Nulo");
            }
            if (cliente.Validar())
            {
                repositorio.IncluirCliente(cliente);
                return ResponderOK(cliente);
            }
            else
            {
                return ResponderErro(cliente.Mensagens);
            }
        }

        [Route("{cpf}")]
        [HttpPut]
        public HttpResponseMessage Put(string cpf, [FromBody]Cliente cliente)
        {
            var clienteAlterar = repositorio.ObterClienteCPF(cpf);
            if (clienteAlterar != null)
            {
                clienteAlterar.AlterarCliente(cliente.Nome, cliente.Cpf, cliente.Endereco, cliente.Genero, cliente.DataNascimento);
                if (clienteAlterar.Validar())
                {
                    repositorio.AlterarCliente(clienteAlterar);
                    return ResponderOK(clienteAlterar);
                }
                return ResponderErro(clienteAlterar.Mensagens);
            }
            else
            {
                return ResponderErro("Cliente não Existe");
            }
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

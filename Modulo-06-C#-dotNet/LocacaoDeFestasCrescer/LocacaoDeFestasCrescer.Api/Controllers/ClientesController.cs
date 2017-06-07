using LocacaoDeFestasCrescer.Dominio.Entidades;
using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using System;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocacaoDeFestasCrescer.Api.Controllers
{
    [RoutePrefix("api/Clientes")]
    public class ClientesController : ControllerBasica, IDisposable
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        [Route("{cpf}")]
        [HttpGet]
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
        
        [HttpPost]
        public HttpResponseMessage Post(Cliente Cliente)
        {
            if (Cliente.Validar())
            {
                repositorio.IncluirCliente(Cliente);
                return ResponderOK(Cliente);
            }
            else
            {
                return ResponderErro(Cliente.Mensagens);
            }
        }

        [Route("{cpf}")]
        [HttpPut]
        public HttpResponseMessage Put(string cpf, Cliente cliente)
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

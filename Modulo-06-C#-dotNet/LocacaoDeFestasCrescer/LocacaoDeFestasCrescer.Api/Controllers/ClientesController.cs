using LocacaoDeFestasCrescer.Infraestrutura.Repositorios;
using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
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




        public IHttpActionResult Post(Cliente Cliente)
        {

            return BadRequest();
        }




        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}

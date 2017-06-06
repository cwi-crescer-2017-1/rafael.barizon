using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio: IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Cliente> ObterClientes()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente ObterClienteCPF(string cpf)
        {
            return contexto.Clientes.FirstOrDefault(x => x.Cpf == cpf);
        }





        public void Dispose()
        {
            contexto.Dispose();
        }

        public void IncluirCliente(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }
    }
}
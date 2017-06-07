using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        
        public List<Produto> ObterTodos()
        {
            return contexto.Produtos.ToList();
        }

        public Produto ObterById(int id)
        {
            return contexto.Produtos.FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

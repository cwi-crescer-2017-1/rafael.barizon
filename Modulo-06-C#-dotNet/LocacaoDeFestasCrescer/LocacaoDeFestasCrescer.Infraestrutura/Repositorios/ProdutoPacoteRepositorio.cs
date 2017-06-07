using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class ProdutoPacoteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        
        public List<ProdutoPacote> ObterTodos()
        {
            return contexto.ProdutosPacotes.ToList();
        }

        public ProdutoPacote ObterById(int id)
        {
            return contexto.ProdutosPacotes.FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

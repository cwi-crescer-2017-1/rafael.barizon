using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class ProdutoOpcionalRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<ProdutoOpcional> ObterTodos()
        {
            return contexto.ProdutosOpcionais.ToList();
        }

        public ProdutoOpcional ObterId(int id)
        {
            return contexto.ProdutosOpcionais.FirstOrDefault(x => x.Id == id);
        }

        public void AtualizarEstoque(ProdutoOpcional produtoOpcional)
        {
            contexto.Entry(produtoOpcional).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

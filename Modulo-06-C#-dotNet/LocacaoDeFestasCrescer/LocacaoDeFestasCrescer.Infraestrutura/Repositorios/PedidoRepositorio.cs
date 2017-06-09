using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Pedido> ObterTodos()
        {
            return contexto.Pedidos.ToList();
        }

        public dynamic ObterRelatorio(DateTime data)
        {
            var data2 = data.AddDays(-30.00);
           return contexto.Pedidos
                .Where(x =>
                           x.DataEntregaReal.Value != null &&
                           x.DataEntregaReal.Value <= data &&
                           x.DataEntregaReal.Value >= data2)
                           .Select(x => new
                           {
                               PedidoId = x.Id,
                               Festa = x.Produto.Festa.ToString(),
                               ClientePedido = x.Cliente.Nome,
                               ValorFinal = x.ValorTotalReal
                           })
                .ToList();
        }

        public dynamic ObterAtrasos()
        {
            return contexto.Pedidos
                .Where(x =>
                       x.DataEntregaReal == null &&
                       x.DataEntregaPrevista <= DateTime.UtcNow)
                .OrderBy(x => x.DataEntregaPrevista)
                .Select(x => new
                {
                    PedidoId = x.Id,
                    Festa = x.Produto.Festa.ToString(),
                    ClientePedido = x.Cliente.Nome,
                    Pacote = x.ProdutoPacote.Descricao,
                    Opcionais = x.ProdutosOpcionais,
                    Valor = x.ValorTotal
                })
                       .ToList();
        }

        public void Criar(Pedido pedido)
        {
            contexto.Pedidos.Add(pedido);
            contexto.Entry(pedido.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(pedido.Produto).State = System.Data.Entity.EntityState.Unchanged;

            if (pedido.ProdutoPacote != null)
            {
                contexto.Entry(pedido.ProdutoPacote).State = System.Data.Entity.EntityState.Unchanged;
            }

            if (pedido.ProdutosOpcionais != null)
            {
                foreach (var produtoOpcional in pedido.ProdutosOpcionais)
                {
                    contexto.Entry(produtoOpcional).State = System.Data.Entity.EntityState.Modified;
                }
            }

            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public Pedido ObterById(int id)
        {
            return contexto.Pedidos.Where(x => x.Id == id)
                .Include(x => x.Produto)
                .Include(x => x.ProdutoPacote)
                .Include(x => x.ProdutosOpcionais)
                .FirstOrDefault();
        }

        public void FinalizarPedido(Pedido pedido)
        {
            contexto.Entry(pedido).State = EntityState.Modified;
            contexto.SaveChanges();
        }
    }
}

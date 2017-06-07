using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio: IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Pedido> ObterTodos()
        {
            return contexto.Pedidos.ToList();
        }

        public List<Pedido> ObterRelatorio(DateTime data)
        {
            return contexto.Pedidos
                .Where( x => 
                            x.DataEntregaReal.Value != null &&
                            x.DataEntregaReal.Value.Subtract(data).TotalDays <= 30.00)
                .ToList();
        }

        public List<Pedido> ObterAtrasos()
        {
            return contexto.Pedidos
                .Where(x =>
                       x.DataEntregaReal == null &&
                       x.DataEntregaPrevista <= DateTime.UtcNow)
                       .OrderByDescending(x => x.DataEntregaReal)
                       .ToList();
        }

        public void Criar(Pedido pedido)
        {
            contexto.Pedidos.Add(pedido);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

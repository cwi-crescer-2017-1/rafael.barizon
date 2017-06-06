using LocacaoDeFestasCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocacaoDeFestasCrescer.Infraestrutura
{
    internal class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedidos");
            HasKey(x => x.Id);
            //CLIENTE
            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));
            //.HasForeignKey(x => x.Id_Cliente);
            //PRODUTO
            HasRequired(x => x.Produto)
                .WithMany()
                .Map(x => x.MapKey("IdProduto"));
            //.HasForeignKey(x => x.Id_Produto);
            //PACOTE
            HasOptional(x => x.ProdutoPacote)
                .WithMany()
                .Map(x => x.MapKey("IdProdutoPacote"));
            //.HasForeignKey(x => x.Id_ProdutoPacote);

            HasMany(x => x.ProdutosOpcionais)
                .WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdPedido");
                    x.MapRightKey("IdProdutoPacote");
                    x.ToTable("ProdutosOpcionaisPedido");
                });
        }
    }
}
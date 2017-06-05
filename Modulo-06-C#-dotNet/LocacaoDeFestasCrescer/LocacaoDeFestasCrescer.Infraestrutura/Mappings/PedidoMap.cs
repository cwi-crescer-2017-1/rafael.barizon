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
                .HasForeignKey(x => x.Id_Cliente);
            //PRODUTO
            HasRequired(x => x.Produto)
                .WithMany()
                .HasForeignKey(x => x.Id_Produto);
            //PACOTE
            HasOptional(x => x.ProdutoPacote)
                .WithMany()
                .HasForeignKey(x => x.Id_ProdutoPacote);
            //OPCIONAL
            HasOptional(x => x.ProdutoOpcional)
                .WithMany()
                .HasForeignKey(x => x.Id_ProdutoOpcional);
        }
    }
}
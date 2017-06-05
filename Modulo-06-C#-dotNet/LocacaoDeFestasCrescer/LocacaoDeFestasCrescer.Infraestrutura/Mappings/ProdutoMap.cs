using LocacaoDeFestasCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocacaoDeFestasCrescer.Infraestrutura
{
    internal class ProdutoMap : EntityTypeConfiguration<Produto>
    {
        public ProdutoMap()
        {
            ToTable("Produtos");
            HasKey(x => x.Id);
        }
    }
}
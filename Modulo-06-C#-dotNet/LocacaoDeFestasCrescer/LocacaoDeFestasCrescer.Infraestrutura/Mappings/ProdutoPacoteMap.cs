using LocacaoDeFestasCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocacaoDeFestasCrescer.Infraestrutura
{
    internal class ProdutoPacoteMap : EntityTypeConfiguration<ProdutoPacote>
    {
        public ProdutoPacoteMap()
        {
            ToTable("ProdutosPacotes");
            HasKey(x => x.Id);
        }
    }
}
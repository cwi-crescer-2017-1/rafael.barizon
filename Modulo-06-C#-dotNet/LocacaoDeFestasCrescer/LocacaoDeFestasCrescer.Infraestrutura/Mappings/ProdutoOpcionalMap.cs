using LocacaoDeFestasCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocacaoDeFestasCrescer.Infraestrutura
{
    internal class ProdutoOpcionalMap : EntityTypeConfiguration<ProdutoOpcional>
    {
        public ProdutoOpcionalMap()
        {
            ToTable("ProdutosOpcionais");
            HasKey(x => x.Id);
        }
    }
}
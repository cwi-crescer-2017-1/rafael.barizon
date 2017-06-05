using LocacaoDeFestasCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace LocacaoDeFestasCrescer.Infraestrutura
{
    internal class OperadorMap : EntityTypeConfiguration<Operador>
    {
        public OperadorMap()
        {
            ToTable("Operadores");
            HasKey(x => x.Id);
            Property(x => x.Nome).HasMaxLength(100);
            Property(x => x.Usuario).HasMaxLength(15);
        }
    }
}
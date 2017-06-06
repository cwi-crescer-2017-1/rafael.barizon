using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocacaoDeFestasCrescer.Infraestrutura.Mappings
{
    internal class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuarios");
            HasKey(x => x.Id);
            Property(x => x.Nome).HasMaxLength(100);
            Property(x => x.Email).HasMaxLength(50);
        }
    }
}

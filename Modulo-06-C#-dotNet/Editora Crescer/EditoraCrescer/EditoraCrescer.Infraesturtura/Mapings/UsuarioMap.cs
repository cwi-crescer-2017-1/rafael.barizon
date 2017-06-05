using AutDemo.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraesturtura
{
    internal class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
                ToTable("Usuarios");
                HasKey(x => x.Id);
        }
    }
}
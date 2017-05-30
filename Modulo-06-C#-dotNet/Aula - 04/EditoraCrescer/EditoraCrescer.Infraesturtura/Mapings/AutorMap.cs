using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraesturtura
{
    internal class AutorMap : EntityTypeConfiguration<Autor>
    {
        public AutorMap()
        {
            ToTable("Autores");
            HasKey(x => x.Id);
        }
    }
}
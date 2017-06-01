using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraesturtura
{
    internal class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");
            HasKey(x => x.Id);
        }
    }
}
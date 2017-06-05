using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace EditoraCrescer.Infraesturtura
{
    internal class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livros");
            HasKey(x => x.Isbn);
            ////Property(x)

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);
            HasOptional(x => x.Revisor)
                .WithMany()
                .HasForeignKey(x => x.IdRevisor);
        }
    }
}
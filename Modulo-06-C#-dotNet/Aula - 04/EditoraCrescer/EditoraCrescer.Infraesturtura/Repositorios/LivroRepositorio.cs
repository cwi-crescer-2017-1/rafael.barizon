using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public dynamic Obter()
        {
            //return contexto.Livros
            //    .Include(x => x.Autor)
            //    .Include(x => x.Revisor)
            //    .ToList();
            return contexto.Livros
                .Select(x => new
                {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero
                });
        }

        public Livro ObterIsbn(int isbn)
        {
            return contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
        }

        public dynamic ObterGenero(string genero)
        {
            return contexto.Livros
                .Where(x => x.Genero.Contains(genero))
                .Select(x => new {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero
                }); 
        }

        public dynamic ObterLancamento()
        {
            DateTime data = DateTime.Now.AddDays(-7);
            return contexto.Livros
                .Where(x => x.DataPublicacao >= data)
                .Select(x => new {
                    Isbn = x.Isbn,
                    Titulo = x.Titulo,
                    Capa = x.Capa,
                    NomeAutor = x.Autor.Nome,
                    Genero = x.Genero
                });
        }

        public bool Inserir(Livro livro)
        {
            try
            { 
                contexto.Livros.Add(livro);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Delete(int isbn)
        {
            try
            {
                var livroDelete = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
                contexto.Livros.Remove(livroDelete);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Alterar(int isbn, Livro livro)
        {
            try
            {
                if (isbn != livro.Isbn)
                    return false;
                if (contexto.Livros.Count(x => x.Isbn == isbn) > 0)
                {
                    contexto.Entry(livro).State = EntityState.Modified;
                    contexto.SaveChanges();
                    return true;
                }
                return false;
            }
            catch
            {
                return false;
            }
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

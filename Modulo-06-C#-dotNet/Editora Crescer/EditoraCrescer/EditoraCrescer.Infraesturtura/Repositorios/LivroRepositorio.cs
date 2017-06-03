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
        private int quantidade = 0;
        private int qtdLivros = 0;
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

        public dynamic ObterQuantidadePagina(int qtd)
        {
            qtdLivros = contexto.Livros.Count();

            var pegarQtos = qtdLivros - quantidade;
            if (pegarQtos > 0);
            {
                if (qtdLivros - quantidade >= 6)
                {
                    quantidade += 6;
                    return contexto.Livros.OrderBy(x => x.Isbn).Skip(quantidade-6).Take(qtd);
                }
                else
                {
                    quantidade += pegarQtos;
                    return contexto.Livros.OrderBy(x => x.Isbn).Skip(quantidade - pegarQtos).Take(pegarQtos);
                }
            }
        }

        public int Paginacao()
        {
            return contexto.Livros.Count();
        }

        public dynamic ObterLancamento()
        {
            DateTime data = DateTime.Now.AddDays(-7);
            qtdLivros = contexto.Livros.Count();
            if (qtdLivros > 6) quantidade = 6;
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
                qtdLivros++;
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
                qtdLivros--;
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

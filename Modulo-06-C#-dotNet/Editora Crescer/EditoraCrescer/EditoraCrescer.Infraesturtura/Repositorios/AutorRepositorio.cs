using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;
using System.Data.Entity;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutorRepositorio: IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public bool Incluir(Autor autor)
        {
            try
            {
                contexto.Autores.Add(autor);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
            
        }

        public bool Delete(int id)
        {
            try
            {
                var autorDelete = contexto.Autores.FirstOrDefault(x => x.Id == id);
                var temLivro = contexto.Livros.FirstOrDefault(x => x.IdAutor == autorDelete.Id);
                if (temLivro == null)
                    return false;
                contexto.Autores.Remove(autorDelete);
                contexto.SaveChanges();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public List<Livro> ObterLivrosAutorId(int id)
        {
            return contexto.Livros.Where(x => x.IdAutor == id).ToList();
        }

        public Autor ObterId(int id)
        {
            return contexto.Autores.FirstOrDefault(x => x.Id == id);
        }

        public bool Alterar(int id, Autor autor)
        {
            try
            {
                if (id != autor.Id)
                    return false;
                if (contexto.Autores.Count(x => x == autor) > 0)
                {
                    contexto.Entry(autor).State = EntityState.Modified;
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

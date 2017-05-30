using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutorRepositorio
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
    }
}

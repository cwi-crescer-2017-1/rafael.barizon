using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public bool Inserir(Revisor revisor)
        {
            try
            {
                contexto.Revisores.Add(revisor);
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
                var revisorDelete = contexto.Revisores.FirstOrDefault(x => x.Id == id);
                var temLivro = contexto.Livros.FirstOrDefault(x => x.IdRevisor == revisorDelete.Id);
                if (temLivro == null)
                    return false;
                contexto.Revisores.Remove(revisorDelete);
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

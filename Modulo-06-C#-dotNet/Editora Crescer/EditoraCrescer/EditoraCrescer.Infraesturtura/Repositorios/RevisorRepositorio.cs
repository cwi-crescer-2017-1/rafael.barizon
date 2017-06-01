using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisorRepositorio: IDisposable
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

        public bool Alterar(int id, Revisor revisor)
        {
            try
            {
                if (id != revisor.Id)
                    return false;
                if (contexto.Revisores.Count(x => x == revisor) > 0)
                {
                    contexto.Entry(revisor).State = EntityState.Modified;
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

        public Revisor ObterByID(int id)
        {
            return contexto.Revisores.FirstOrDefault(x => x.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

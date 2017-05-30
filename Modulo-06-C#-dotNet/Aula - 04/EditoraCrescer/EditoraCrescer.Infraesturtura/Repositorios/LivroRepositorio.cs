using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public object Obter()
        {
            return contexto.Livros.ToList();
        }
    }
}

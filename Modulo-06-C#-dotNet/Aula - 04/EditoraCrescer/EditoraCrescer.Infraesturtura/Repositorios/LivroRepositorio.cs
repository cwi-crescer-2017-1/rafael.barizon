﻿using EditoraCrescer.Infraesturtura.Entidades;
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

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
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

        public bool Delete(int id)
        {
            try
            {
                var livroDelete = contexto.Livros.FirstOrDefault(x => x.Isbn == id);
                contexto.Livros.Remove(livroDelete);
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

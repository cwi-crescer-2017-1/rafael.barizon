﻿using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Entidades
{
    public class Livro
    {
        public int Isbn { get; set; }
        public string Titulo { get; set; }
        public string Descricao { get; set; }
        public string Genero { get; set; }
        public string Capa { get; set; }
        public DateTime? DataPublicacao { get; set; }
        public int IdAutor { get; set; }
        public Autor Autor { get; set; }
        public int? IdRevisor { get; set; }
        public virtual Revisor Revisor { get; private set; }
        public DateTime? DataRevisao { get; set; }
    }
}
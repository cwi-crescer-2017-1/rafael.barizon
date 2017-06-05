using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        public Festa Festa { get; set; }
        public decimal Valor { get; set; }
    }
}
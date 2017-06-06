using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; private set; }
        public Festa Festa { get; private set; }
        public decimal Valor { get; set; }

        protected Produto () { }

        public Produto(Festa festa, decimal valor)
        {
            Festa = festa;
            Valor = valor;
        }

        public void AlterarProduto(Festa festa, decimal valor)
        {
            Festa = festa;
            Valor = valor;
        }
    }
}
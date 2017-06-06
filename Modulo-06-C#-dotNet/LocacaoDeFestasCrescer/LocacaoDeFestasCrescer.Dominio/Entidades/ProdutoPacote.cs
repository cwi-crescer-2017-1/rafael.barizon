using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class ProdutoPacote
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Descricao { get; private set; }
        public decimal Valor { get; set; }

        protected ProdutoPacote() { }

        public ProdutoPacote(string nome, string descricao, decimal valor)
        {
            Nome = nome;
            Descricao = descricao;
            Valor = valor;
        }
        public void AlterarProdutoPacote(string nome, string descricao, decimal valor)
        {
            Nome = nome;
            Descricao = descricao;
            Valor = valor;
        }

    }
}
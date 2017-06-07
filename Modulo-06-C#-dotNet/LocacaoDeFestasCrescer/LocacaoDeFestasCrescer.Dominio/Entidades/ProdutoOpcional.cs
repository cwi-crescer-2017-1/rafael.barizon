using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class ProdutoOpcional
    {
        public int Id { get; private set; }
        public string Descricao { get; private set; }
        public decimal Valor { get; set; }
        public int Quantidade { get; set; }

        protected ProdutoOpcional() { }

        public ProdutoOpcional(string descricao, decimal valor, int quantidade)
        {
            Descricao = descricao;
            Valor = valor;
            Quantidade = quantidade;
        }
        public bool VerificarQuantidade(int QuantidadeProdutoOpcionalBanco)
        {
            return QuantidadeProdutoOpcionalBanco <= Quantidade;
        }

        public void AlterarQuantidade (int quantidade)
        {
                Quantidade = Quantidade - quantidade;
        }
    }
}
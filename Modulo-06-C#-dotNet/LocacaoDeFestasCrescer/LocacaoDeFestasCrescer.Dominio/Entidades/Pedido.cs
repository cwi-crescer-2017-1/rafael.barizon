using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public int Id_Cliente { get; set; }
        public Cliente Cliente { get; set; }
        public int Id_Produto { get; set; }
        public Produto Produto { get; set; }
        public int? Id_ProdutoPacote { get; set; }
        public ProdutoPacote ProdutoPacote { get; set; }
        public int? Id_ProdutoOpcional { get; set; }
        public ProdutoOpcional ProdutoOpcional { get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaReal { get; set; }
        public decimal ValorTotal { get; set; }
        public decimal ValorTotalReal { get; set; }
    }
}
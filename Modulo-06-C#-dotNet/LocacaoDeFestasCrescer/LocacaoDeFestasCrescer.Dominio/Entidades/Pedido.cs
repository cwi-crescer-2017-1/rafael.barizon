using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; private set; }
        public Cliente Cliente { get; private set; }
        public Produto Produto { get; private set; }
        public ProdutoPacote ProdutoPacote { get; private set; }
        public List<ProdutoOpcional> ProdutosOpcionais { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaReal { get; private set; }
        public decimal ValorTotal { get; private set; }
        public decimal? ValorTotalReal { get; private set; }

        protected Pedido() { }

        public Pedido(
                    Cliente cliente,
                    Produto produto,
                    ProdutoPacote produtoPacote,
                    List<ProdutoOpcional> produtosOpcionais,
                    DateTime dataEntregaPrevista)
        {
            Cliente = cliente;
            Produto = produto;
            ProdutoPacote = produtoPacote;
            ProdutosOpcionais = produtosOpcionais;
            DataPedido = DateTime.UtcNow;
            DataEntregaPrevista = dataEntregaPrevista;
            CalcularValor();
        }

        private void CalcularValor()
        {
            decimal valorTotal = Produto.Valor;
            
            // Somando Valor do Produto Pacote
            if (ProdutoPacote != null)
            {
                valorTotal += ProdutoPacote.Valor;
            }
            // Somando Valor dos Produtos Opcionais
            if (ProdutosOpcionais != null)
            {
                foreach (var produtoOpcional in ProdutosOpcionais)
                {
                    valorTotal += (produtoOpcional.Valor * produtoOpcional.Quantidade);
                }
            }

            var diasPrevistoPedido = DataEntregaPrevista.Subtract(DataPedido);
            int dias;
            int.TryParse(diasPrevistoPedido.ToString(), out dias);

            // ValorTotal determinado
            ValorTotal = valorTotal * dias;
        }

        private void CalcularValorReal()
        {
            DataEntregaReal = DateTime.UtcNow;
            var diasPrevistoPedido = DataEntregaReal.Value.Subtract(DataEntregaPrevista);
            int dias;
            int.TryParse(diasPrevistoPedido.ToString(), out dias);

            if(dias == 0)
            {
                ValorTotalReal = ValorTotal;
                return;
            }

            decimal valorTotalReal = Produto.Valor;
            
            // Somando Valor do Produto Pacote
            if (ProdutoPacote != null)
            {
                valorTotalReal += 300.00m;
            }
            // Somando Valor dos Produtos Opcionais
            if (ProdutosOpcionais != null)
            {
                foreach (var produtoOpcional in ProdutosOpcionais)
                {
                    valorTotalReal += (produtoOpcional.Valor * produtoOpcional.Quantidade);
                }
            }

            ValorTotalReal = valorTotalReal * dias;

        }

        public void AlterarPedido(
                    Cliente cliente,
                    Produto produto,
                    ProdutoPacote produtoPacote,
                    List<ProdutoOpcional> produtosOpcionais,
                    DateTime dataEntregaPrevista)
        {
            Cliente = cliente;
            Produto = produto;
            ProdutoPacote = produtoPacote;
            ProdutosOpcionais = produtosOpcionais;
            DataEntregaPrevista = dataEntregaPrevista;
            CalcularValor();
        }

    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Api.Models
{
    public class RegistrarPedidoModel
    {
        public string ClienteCPF { get; set; }
        public int ProdutoID { get; set; }
        public int? ProdutoPacoteID { get; set; }
        public List<int> ProdutosOpcionaisIDs { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
    }
}
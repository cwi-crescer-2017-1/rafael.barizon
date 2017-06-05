using LocacaoDeFestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace LocacaoDeFestasCrescer.Infraestrutura
{
    public class Contexto: DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        { }

        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Operador> Operadores { get; set; }
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<ProdutoOpcional> ProdutosOpcionais { get; set; }
        public DbSet<ProdutoPacote> ProdutosPacotes { get; set; }
        public DbSet<Pedido> Pedidos { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new OperadorMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new ProdutoOpcionalMap());
            modelBuilder.Configurations.Add(new ProdutoPacoteMap());
            modelBuilder.Configurations.Add(new PedidoMap());
        }
    }
}
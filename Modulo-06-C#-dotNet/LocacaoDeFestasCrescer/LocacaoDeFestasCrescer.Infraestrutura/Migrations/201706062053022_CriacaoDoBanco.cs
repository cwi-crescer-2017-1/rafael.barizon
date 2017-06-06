namespace Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Cpf = c.String(maxLength: 11, fixedLength: true),
                        Endereco = c.String(),
                        Genero = c.Int(nullable: false),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Operadores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Usuario = c.String(maxLength: 15),
                        Senha = c.String(),
                        Gerente = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaReal = c.DateTime(),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        ValorTotalReal = c.Decimal(precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdProduto = c.Int(nullable: false),
                        IdProdutoPacote = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Produtos", t => t.IdProduto, cascadeDelete: true)
                .ForeignKey("dbo.ProdutosPacotes", t => t.IdProdutoPacote)
                .Index(t => t.IdCliente)
                .Index(t => t.IdProduto)
                .Index(t => t.IdProdutoPacote);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Festa = c.Int(nullable: false),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProdutosPacotes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Descricao = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProdutosOpcionais",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProdutosOpcionaisPedido",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdProdutoPacote = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdProdutoPacote })
                .ForeignKey("dbo.Pedidos", t => t.IdPedido, cascadeDelete: true)
                .ForeignKey("dbo.ProdutosOpcionais", t => t.IdProdutoPacote, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdProdutoPacote);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ProdutosOpcionaisPedido", "IdProdutoPacote", "dbo.ProdutosOpcionais");
            DropForeignKey("dbo.ProdutosOpcionaisPedido", "IdPedido", "dbo.Pedidos");
            DropForeignKey("dbo.Pedidos", "IdProdutoPacote", "dbo.ProdutosPacotes");
            DropForeignKey("dbo.Pedidos", "IdProduto", "dbo.Produtos");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropIndex("dbo.ProdutosOpcionaisPedido", new[] { "IdProdutoPacote" });
            DropIndex("dbo.ProdutosOpcionaisPedido", new[] { "IdPedido" });
            DropIndex("dbo.Pedidos", new[] { "IdProdutoPacote" });
            DropIndex("dbo.Pedidos", new[] { "IdProduto" });
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropTable("dbo.ProdutosOpcionaisPedido");
            DropTable("dbo.ProdutosOpcionais");
            DropTable("dbo.ProdutosPacotes");
            DropTable("dbo.Produtos");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Operadores");
            DropTable("dbo.Clientes");
        }
    }
}

namespace LocacaoDeFestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoBancoDeDados : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Cpf = c.String(),
                        Endereco = c.String(maxLength: 150),
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
                        Senha = c.String(maxLength: 15),
                        Gerente = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Id_Cliente = c.Int(nullable: false),
                        Id_Produto = c.Int(nullable: false),
                        Id_ProdutoPacote = c.Int(),
                        Id_ProdutoOpcional = c.Int(),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaReal = c.DateTime(),
                        ValorTotal = c.Decimal(nullable: false, precision: 10, scale: 2),
                        ValorTotalReal = c.Decimal(nullable: true, precision: 10, scale: 2),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.Id_Cliente, cascadeDelete: true)
                .ForeignKey("dbo.Produtos", t => t.Id_Produto, cascadeDelete: true)
                .ForeignKey("dbo.ProdutosOpcionais", t => t.Id_ProdutoOpcional)
                .ForeignKey("dbo.ProdutosPacotes", t => t.Id_ProdutoPacote)
                .Index(t => t.Id_Cliente)
                .Index(t => t.Id_Produto)
                .Index(t => t.Id_ProdutoPacote)
                .Index(t => t.Id_ProdutoOpcional);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Festa = c.Int(nullable: false),
                        Valor = c.Decimal(nullable: false, precision: 10, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProdutosOpcionais",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(maxLength: 100),
                        Valor = c.Decimal(nullable: false, precision: 10, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ProdutosPacotes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Descricao = c.String(maxLength: 100),
                        Valor = c.Decimal(nullable: false, precision: 10, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Pedidos", "Id_ProdutoPacote", "dbo.ProdutosPacotes");
            DropForeignKey("dbo.Pedidos", "Id_ProdutoOpcional", "dbo.ProdutosOpcionais");
            DropForeignKey("dbo.Pedidos", "Id_Produto", "dbo.Produtos");
            DropForeignKey("dbo.Pedidos", "Id_Cliente", "dbo.Clientes");
            DropIndex("dbo.Pedidos", new[] { "Id_ProdutoOpcional" });
            DropIndex("dbo.Pedidos", new[] { "Id_ProdutoPacote" });
            DropIndex("dbo.Pedidos", new[] { "Id_Produto" });
            DropIndex("dbo.Pedidos", new[] { "Id_Cliente" });
            DropTable("dbo.ProdutosPacotes");
            DropTable("dbo.ProdutosOpcionais");
            DropTable("dbo.Produtos");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Operadores");
            DropTable("dbo.Clientes");
        }
    }
}

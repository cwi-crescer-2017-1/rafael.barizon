namespace LocacaoDeFestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UpdatePedido : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Pedidos", "Id_ProdutoOpcional", "dbo.ProdutosOpcionais");
            DropIndex("dbo.Pedidos", new[] { "Id_ProdutoOpcional" });
            CreateTable(
                "dbo.ProdutosOpcionaisPedido",
                c => new
                    {
                        ID_Pedido = c.Int(nullable: false),
                        ID_ProdutoOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.ID_Pedido, t.ID_ProdutoOpcional })
                .ForeignKey("dbo.Pedidos", t => t.ID_Pedido, cascadeDelete: true)
                .ForeignKey("dbo.ProdutosOpcionais", t => t.ID_ProdutoOpcional, cascadeDelete: true)
                .Index(t => t.ID_Pedido)
                .Index(t => t.ID_ProdutoOpcional);
            
            AlterColumn("dbo.Clientes", "Cpf", c => c.String(maxLength: 11, fixedLength: true));
            DropColumn("dbo.Pedidos", "Id_ProdutoOpcional");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Pedidos", "Id_ProdutoOpcional", c => c.Int());
            DropForeignKey("dbo.ProdutosOpcionaisPedido", "ID_ProdutoOpcional", "dbo.ProdutosOpcionais");
            DropForeignKey("dbo.ProdutosOpcionaisPedido", "ID_Pedido", "dbo.Pedidos");
            DropIndex("dbo.ProdutosOpcionaisPedido", new[] { "ID_ProdutoOpcional" });
            DropIndex("dbo.ProdutosOpcionaisPedido", new[] { "ID_Pedido" });
            AlterColumn("dbo.Clientes", "Cpf", c => c.String());
            DropTable("dbo.ProdutosOpcionaisPedido");
            CreateIndex("dbo.Pedidos", "Id_ProdutoOpcional");
            AddForeignKey("dbo.Pedidos", "Id_ProdutoOpcional", "dbo.ProdutosOpcionais", "Id");
        }
    }
}

namespace LocacaoDeFestasCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UpdateBancoTirandoIDs : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Pedidos", name: "Id_Cliente", newName: "IdCliente");
            RenameColumn(table: "dbo.Pedidos", name: "Id_Produto", newName: "IdProduto");
            RenameColumn(table: "dbo.Pedidos", name: "Id_ProdutoPacote", newName: "IdProdutoPacote");
            RenameColumn(table: "dbo.ProdutosOpcionaisPedido", name: "ID_Pedido", newName: "IdPedido");
            RenameColumn(table: "dbo.ProdutosOpcionaisPedido", name: "ID_ProdutoOpcional", newName: "IdProdutoPacote");
            RenameIndex(table: "dbo.Pedidos", name: "IX_Id_Cliente", newName: "IX_IdCliente");
            RenameIndex(table: "dbo.Pedidos", name: "IX_Id_Produto", newName: "IX_IdProduto");
            RenameIndex(table: "dbo.Pedidos", name: "IX_Id_ProdutoPacote", newName: "IX_IdProdutoPacote");
            RenameIndex(table: "dbo.ProdutosOpcionaisPedido", name: "IX_ID_Pedido", newName: "IX_IdPedido");
            RenameIndex(table: "dbo.ProdutosOpcionaisPedido", name: "IX_ID_ProdutoOpcional", newName: "IX_IdProdutoPacote");
            AlterColumn("dbo.Pedidos", "ValorTotalReal", c => c.Decimal(precision: 10, scale: 2));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Pedidos", "ValorTotalReal", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            RenameIndex(table: "dbo.ProdutosOpcionaisPedido", name: "IX_IdProdutoPacote", newName: "IX_ID_ProdutoOpcional");
            RenameIndex(table: "dbo.ProdutosOpcionaisPedido", name: "IX_IdPedido", newName: "IX_ID_Pedido");
            RenameIndex(table: "dbo.Pedidos", name: "IX_IdProdutoPacote", newName: "IX_Id_ProdutoPacote");
            RenameIndex(table: "dbo.Pedidos", name: "IX_IdProduto", newName: "IX_Id_Produto");
            RenameIndex(table: "dbo.Pedidos", name: "IX_IdCliente", newName: "IX_Id_Cliente");
            RenameColumn(table: "dbo.ProdutosOpcionaisPedido", name: "IdProdutoPacote", newName: "ID_ProdutoOpcional");
            RenameColumn(table: "dbo.ProdutosOpcionaisPedido", name: "IdPedido", newName: "ID_Pedido");
            RenameColumn(table: "dbo.Pedidos", name: "IdProdutoPacote", newName: "Id_ProdutoPacote");
            RenameColumn(table: "dbo.Pedidos", name: "IdProduto", newName: "Id_Produto");
            RenameColumn(table: "dbo.Pedidos", name: "IdCliente", newName: "Id_Cliente");
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        private string stringConexao =
                @"Server=13.65.101.67;
                  User id=rafael.barizon;
                  Password=123456;
                  Database=aluno05db";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE PEDIDO SET NomeCliente = @nomeCliente WHERE Id = @id";
                    comando.Parameters.AddWithValue("@id", pedido.Id);
                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
                using (var comando = conexao.CreateCommand())
                {
                    foreach(var itemPedido in pedido.Itens)
                    {
                        comando.CommandText =
                        @"UPDATE ItemPedido SET ProdutoId = @produtoId, 
                                                Quantidade = @quantidade 
                            WHERE Id = @id";
                        comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);
                        comando.Parameters.AddWithValue("@id", itemPedido.Id);
                        // Executa o comando e 
                        // retorna somente a quantidade de linhas afetads
                        comando.ExecuteNonQuery();
                    }
                    
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"INSERT INTO Pedido(NomeCliente) 
                                            VALUES(@nomeCliente)";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.ExecuteNonQuery();
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "select @@IDENTITY";
                    var resultado = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)resultado;
                }

                foreach (var itemPedido in pedido.Itens)
                {

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"INSERT INTO ItemPedido(PedidoId, ProdutoId, Quantidade) 
                                            VALUES(@pedidoId, @produtoId, @quantidade)";

                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);
                        comando.ExecuteNonQuery();
                    }
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"UPDATE PRODUTO SET Estoque -= @quantidade WHERE Id = @produtoId";
                        comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);
                        comando.ExecuteNonQuery();
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = "select @@IDENTITY";
                        var resultado = (decimal)comando.ExecuteScalar();
                        itemPedido.Id = (int)resultado;
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE ItemPedido WHERE PedidoId = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
                
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT pedido.Id, pedido.NomeCliente,
                        itemPedido.id, itemPedido.PedidoId, itemPedido.ProdutoId, itemPedido.Quantidade  
                        FROM pedido, ItemPedido";

                    var dataReader = comando.ExecuteReader();
                    var pedido = new Pedido();
                    while (dataReader.Read())
                    {
                        if (pedido == null)
                        {
                            pedido.Id = (int)dataReader["pedido.Id"];
                            pedido.NomeCliente = (string)dataReader["pedido.NomeCliente"];
                        }
                        else if (pedido.Id != (int)dataReader["pedido.Id"])
                        {
                            pedidos.Add(pedido);
                            pedido.Id = (int)dataReader["pedido.Id"];
                            pedido.NomeCliente = (string)dataReader["pedido.NomeCliente"];
                        }

                        var itemPedido = new ItemPedido()
                        {
                            ProdutoId = (int)dataReader["itemPedido.ProdutoId"],
                            Id = (int)dataReader["itemPedido.id"],
                            Quantidade = (int)dataReader["itemPedido.Quantidade"]
                        };
                        pedido.Itens.Add(itemPedido);
                    }
                    pedidos.Add(pedido);

                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            // Não é bom pois toda vez vai pegar a lista completa, nao somente o pedido de id = id
            return Listar().FirstOrDefault(pedido => pedido.Id == id);
        }
    }
}

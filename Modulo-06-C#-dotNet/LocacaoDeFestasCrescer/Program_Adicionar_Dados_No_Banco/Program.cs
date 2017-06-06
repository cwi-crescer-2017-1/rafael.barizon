using LocacaoDeFestasCrescer.Dominio.Entidades;
using LocacaoDeFestasCrescer.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Program_Adicionar_Dados_No_Banco
{
    class Program
    {
        static void Main(string[] args)
        {
            var Produto1 = new Produto()
            {
                Festa = (Festa)0,
                Valor = 800.00m
            };
            var Produto2 = new Produto()
            {
                Festa = (Festa)1,
                Valor = 1200.00m
            };
            var Produto3 = new Produto()
            {
                Festa = (Festa)2,
                Valor = 1600.00m
            };
            var Produto4 = new Produto()
            {
                Festa = (Festa)3,
                Valor = 2000.00m
            };

            var ProdutoPacote1 = new ProdutoPacote()
            {
                Nome = "Basico",
                Descricao = "Decoracao",
                Valor = 300.00m
            };
            var ProdutoPacote2 = new ProdutoPacote()
            {
                Nome = "Intermediario",
                Descricao = "Decoracao + Instalacao",
                Valor = 400.00m
            };
            var ProdutoPacote3 = new ProdutoPacote()
            {
                Nome = "Avancado",
                Descricao = "Decoracao + Instalacao + Equipe",
                Valor = 600.00m
            };

            var ProdutoOpcional1 = new ProdutoOpcional()
            {
                Descricao = "Piscina de Bolinhas",
                Valor = 100.00m,
                Quantidade = 10
            };
            var ProdutoOpcional2 = new ProdutoOpcional()
            {
                Descricao = "Carrinho de Algodao Doce",
                Valor = 60.00m,
                Quantidade = 5
            };
            var ProdutoOpcional3 = new ProdutoOpcional()
            {
                Descricao = "Cama Elastica",
                Valor = 150.00m,
                Quantidade = 10
            };
            var ProdutoOpcional4 = new ProdutoOpcional()
            {
                Descricao = "Escorregador Inflavel",
                Valor = 200.00m,
                Quantidade = 5
            };

            var Operador1 = new Operador()
            {
                Nome = "Rafael",
                Usuario = "rafael",
                Senha = "123456",
                Gerente = true
            };
            var Operador2 = new Operador()
            {
                Nome = "Roberto",
                Usuario = "roberto",
                Senha = "123456",
                Gerente = false
            };
            var Operador3 = new Operador()
            {
                Nome = "Junior",
                Usuario = "junior",
                Senha = "123456",
                Gerente = false
            };
            var Operador4 = new Operador()
            {
                Nome = "Alex",
                Usuario = "alex",
                Senha = "123456",
                Gerente = false
            };

            var Cliente1 = new Cliente()
            {
                Cpf = "12345678901",
                Nome = "Rafael",
                Genero = (Genero)1,
                DataNascimento = new DateTime(1994, 04, 18),
                Endereco = "Av. Cristo Rei #20 - Sao Leopoldo/RS"
            };
            var Cliente2 = new Cliente()
            {
                Cpf = "12345678902",
                Nome = "Roberto",
                Genero = (Genero)1,
                DataNascimento = new DateTime(1995, 07, 08),
                Endereco = "R. da Saudade #530 - Sao Leopoldo/RS"
            };
            var Cliente3 = new Cliente()
            {
                Cpf = "12345678903",
                Nome = "Anna",
                Genero = (Genero)2,
                DataNascimento = new DateTime(1996, 09, 15),
                Endereco = "R. Independencia #1630 - Sao Leopoldo/RS"
            };

            using (var contexto = new Contexto())
            {
                contexto.Produtos.Add(Produto1);
                contexto.Produtos.Add(Produto2);
                contexto.Produtos.Add(Produto3);
                contexto.Produtos.Add(Produto4);

                contexto.ProdutosPacotes.Add(ProdutoPacote1);
                contexto.ProdutosPacotes.Add(ProdutoPacote2);
                contexto.ProdutosPacotes.Add(ProdutoPacote3);

                contexto.ProdutosOpcionais.Add(ProdutoOpcional1);
                contexto.ProdutosOpcionais.Add(ProdutoOpcional2);
                contexto.ProdutosOpcionais.Add(ProdutoOpcional3);
                contexto.ProdutosOpcionais.Add(ProdutoOpcional4);

                contexto.Operadores.Add(Operador1);
                contexto.Operadores.Add(Operador2);
                contexto.Operadores.Add(Operador3);
                contexto.Operadores.Add(Operador4);

                contexto.Clientes.Add(Cliente1);
                contexto.Clientes.Add(Cliente2);
                contexto.Clientes.Add(Cliente3);

                contexto.SaveChanges();
            }

            Console.WriteLine("Termino de fazer a inclusao no banco!");
            Console.ReadKey();
        }
    }
}

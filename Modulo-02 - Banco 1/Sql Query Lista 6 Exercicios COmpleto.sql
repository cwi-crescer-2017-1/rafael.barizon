/*
Exerc�cio 1

Primeiro nome
Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
Exemplo de resultado esperado:
PrimeiroNome	TotalOcorrencias
Juvenita	7
*/
select top 1 c.nome as PrimeiroNome, count(c.nome) as TotalOcorrencias 
	from (Select (Substring(c2.nome, 1, charindex(' ', c2.nome) -1)) AS Nome 
			from cliente as c2) as c
	group by c.Nome
	order by TotalOcorrencias desc;

/*
Exerc�cio 2
Total do M�s
Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017.
Exemplo de resultado esperado:
Quantidade	ValorPedido
469	22,817,022.06
*/
select * from Pedido;

select count(*) as Quantidade, Sum(ValorPedido) as ValorPedido 
	from Pedido
	where month(DataPedido) = 04 
	and year(DataPedido) = 2017;			

/*
Exerc�cio 3

Estados x Clientes
Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), liste tamb�m qual o Estado possu� o menor n�mero de clientes.
Exemplo de resultado esperado:
UF	TotalClientes
AC	24
MG	2008
*/

select * from (
select Top 1 c.UF, count(cli.idCliente) as TotalClientes
	from cidade c
	inner join cliente cli on cli.IDCidade = c.IDCidade
	group by c.uf
	order by TotalClientes) as Top1Asc
union
select * from (
select Top 1 c.UF, count(cli.idCliente) as TotalClientes
	from cidade c
	inner join cliente cli on cli.IDCidade = c.IDCidade
	group by c.uf
	order by TotalClientes desc) as Top1Desc;

/*

Exerc�cio 4

Novo Produto

Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:

Nome: Galocha Maragato
Pre�o de custo: 35.67
Pre�o de venda: 77.95
Situa��o: A

*/

begin transaction
insert into Produto(nome, PrecoCusto,PrecoVenda,Situacao)
values ('Galocha Maragato', 35.67, 77.95, 'A');
commit
select * from Produto order by IDProduto desc;
/*
Exerc�cio 5
Produtos n�o comprados
Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
=> Obs.: o produto criado anteriormente dever� ser listado (apenas este)
*/
select * from Produto Pro
	where not EXISTS 
 	(Select * from PedidoItem as PedI 
 		  where PedI.IDProduto = Pro.IDProduto);

/*
Exerc�cio 6
Principais Produtos
Liste os 30 produtos que mais geraram lucro em 2016.
*/

select top 30 Sum(PedI.Quantidade * (PedI.PrecoUnitario -Prod.PrecoCusto)) as Lucro, Prod.Nome 
	from PedidoItem PedI
	inner join Produto as Prod on Prod.IDProduto = PedI.IDProduto
	inner join Pedido as Ped on Ped.IDPedido = PedI.IDPedido
	and year(Ped.DataEntrega) = 2016 
	group by Prod.Nome 
	order by lucro desc;

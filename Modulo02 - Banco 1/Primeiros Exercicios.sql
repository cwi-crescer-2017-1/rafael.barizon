/*Exercício 1
Cópia de uma tabela
Crie a tabela CidadeAux a partir de uma cópia da tabela Cidade. Considere todos os registros existentes.
*/
select * into CidadeAux from Cidade;

/*Exercício 2
Copiando dados parciais
Limpe a tabela CidadeAux (Truncate table CidadeAux). E em seguida insira todas os registros da tabela Cidade onde o estado seja RS.
*/

truncate table CidadeAux;
select * from CidadeAux;

insert into CidadeAux(IDCidade,nome,UF) 
	select IDCidade,nome,UF from Cidade 
	where cidade.UF = 'RS';

/*Exercício 3
Criando uma tabela
Crie uma tabela para armazenar informações de produtos. Devem ter os seguintes atributos:
Código de identificação;
Nome curto,
Nome descritivo,
Data da criação,
Local no estoque,
Quantidade e
Preço.
*/

create table Produtos(
	IDProduto		int	IDENTITY				not null,
	NomeCurto		varchar(20)					not null,
	NomeDescritivo	varchar(50)					not null,
	DataCriacao		date default (getdate())	not null,
	LocalNoEstoque	varchar(30)					not null,
	Quantidade		int							not null,
	Preco			float						not null

	constraint PK_IDProduto primary key (IDProduto)
);

/*Exercício 4
Inserindo registros
Crie dois registros nessa tabela nova (produto).
*/


insert into Produtos (NomeCurto,NomeDescritivo, LocalNoEstoque,Quantidade,Preco)
values ('Caneca','Canecas com Imagem de Cafe','Setor 5 Lado B',15,10.50);

insert into Produtos (NomeCurto,NomeDescritivo, LocalNoEstoque,Quantidade,Preco)
values ('Jaqueta','Jaqueta com imagem de uma lontra tomando cafe','Setor 7 Lado A',50,65);

select * from Produtos;


delete from Produtos where IDProduto = 3;
-- 013 = DD/MM/AAAA
select CONVERT ( DATETIME, '13/05/2017', 103);
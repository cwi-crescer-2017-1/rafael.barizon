/*Exerc�cio 1
M�ltiplos acessos
Liste o nome do empregado, o nome do gerente e o departamento de cada um.
*/

select	e.NomeEmpregado, 
		dE.NomeDepartamento as departamentoEmpregado , 
		g.NomeEmpregado as NomeGerente , 
		dG.NomeDepartamento as departamentoGerente
	from Empregado e
	inner join Empregado g on e.IDGerente = g.IDEmpregado
	inner join departamento dE on e.IDDepartamento = dE.IDDepartamento
	inner join departamento dG on g.IDDepartamento = dG.IDDepartamento;

/*
Exerc�cio 2
Maior Sal�rio
Liste o deparamento (id e nome) com o empregado de maior sal�rio.
*/
-- mesmo departamento tem 2 empregados com o mesmo salario entao mostra duas vezes entao top 1 para mostrar somente o primeiro
select top 1 d.IDDepartamento, d.NomeDepartamento
from Departamento d
inner join Empregado e on e.IDDepartamento = d.IDDepartamento 
where e.Salario = (select max(Salario) 
					from empregado 
					where IDDepartamento is not null);

/*Exerc�cio 3
Reajuste salarial
Aplique uma altera��o salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, 
este reajuste deve ser de 17,3%. Por seguran�a fa�a uma c�pia da tabela Empregado antes de iniciar esta tarefa.
*/

select * into newTable 
	from empregado  ;

update e
	set e.Salario = e.Salario * 1.173
	from Empregado e
	inner join Departamento d on e.IDDepartamento = d.IDDepartamento
	and d.Localizacao = 'SAO PAULO';

/*
Exerc�cio 4
Cidades duplicadas
Liste todas as cidades duplicadas (nome e UF iguais).
*/
select * from Cidade order by Nome
create view viewCidadedesDuplicadas as
select nome, uf 
	from Cidade
	group by nome, uf
	having count(*) > 1;

/*
Exerc�cio 5
Definindo Cidades
Fa�a uma altera�ao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. 
Mas aten��o! apenas a cidade com maior ID deve ser alterada.

  */
 
update c
	set c.Nome = c.Nome + '*'
	from Cidade c
	inner join Cidade c2 on c.IDCidade != c2.IDCidade
	and c.Nome = c2.Nome
	and c.UF = c2.UF
	where c.IDCidade > c2.IDCidade


















/*Exercício 1
Datas
Faça uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão.
*/
select empregado.IDEmpregado, empregado.NomeEmpregado,DateDiff( year,DataNascimento,DataAdmissao) as Idade 
from Empregado
where DataAdmissao <'1981-01-01';

/*Exercício 2
Ranking
Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. ** 
DICA: Pesquise recursos específicos para esta funcionalidade.
*/

select top 1  Empregado.Cargo,
		COUNT(1) as NumeroEmpregados
	from Empregado
	group by Cargo
	order by count(1) desc;
	
/*Exercício 3
Contagem
Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/

select Cidade.UF,
	count(Cidade.UF) as numeroDeCidades
	from Cidade
	group by Cidade.uf
	order by numeroDeCidades asc;

/*Exercício 4
Alterando dados
Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. 
Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 'Atendente' devem ser ter o departamento (IDDepartamento)
 atualizado para este novo registro (inovação).
*/

insert into Departamento(IDDepartamento, NomeDepartamento, Localizacao)
	values (70, 'Inovacao', 'SAO LEOPOLDO');

update Empregado
	set Empregado.IDDepartamento = 70
	where month(Empregado.DataAdmissao) = 12 
	and Empregado.Cargo not like 'Atendente';
	 
		


















/*Exerc�cio 1
Datas
Fa�a uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admiss�o.
*/
select empregado.IDEmpregado, empregado.NomeEmpregado,DateDiff( year,DataNascimento,DataAdmissao) as Idade 
from Empregado
where DataAdmissao <'1981-01-01';

/*Exerc�cio 2
Ranking
Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. ** 
DICA: Pesquise recursos espec�ficos para esta funcionalidade.
*/

select top 1  Empregado.Cargo,
		COUNT(1) as NumeroEmpregados
	from Empregado
	group by Cargo
	order by count(1) desc;
	
/*Exerc�cio 3
Contagem
Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/

select Cidade.UF,
	count(Cidade.UF) as numeroDeCidades
	from Cidade
	group by Cidade.uf
	order by numeroDeCidades asc;

/*Exerc�cio 4
Alterando dados
Crie um novo departamento, denominado 'Inova��o' com localiza��o em 'S�O LEOPOLDO'. 
Todos os empregados que foram admitidos no m�s de dezembro (qualquer ano) que n�o ocupam o cargo de 'Atendente' devem ser ter o departamento (IDDepartamento)
 atualizado para este novo registro (inova��o).
*/

insert into Departamento(IDDepartamento, NomeDepartamento, Localizacao)
	values (70, 'Inovacao', 'SAO LEOPOLDO');

update Empregado
	set Empregado.IDDepartamento = 70
	where month(Empregado.DataAdmissao) = 12 
	and Empregado.Cargo not like 'Atendente';
	 
		
















/*
Exercício 1

Auditoria Loteria

Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. A auditoria deve 
monitorar tanto as apostas quanto os números de cada aposta.

*/

select * from LogAposta;

Create table LogAposta (
  IDLogAposta     integer not null,
  IDAposta        integer not null,
  IDConcurso      integer,
  IDConcurso_Novo integer not null,
  Operacao        char(1) not null,
  Data            date default sysdate,
  Data_Hora       date,
  Data_Hora_Nova  date,
  Usuario varchar2(50),
    constraint PK_LogAposta 
       primary key (IDLogAposta)
);

Create sequence sqLogAposta;

select * from numero_aposta; 

Create table LogNumeroAposta (
  IDLogNumeroAposta integer not null,
  IDNumero_Aposta   integer not null,
  IDAposta          integer,
  IDAposta_Nova     integer not null,
  NUMERO            integer,
  NUMERO_Novo       integer not null,
  Operacao          char(1) not null,
  Data            date default sysdate,
  Usuario varchar2(50),
    constraint PK_LogNumeroAposta 
       primary key (IDLogNumeroAposta)
);

Create sequence sqLogNumeroAposta;

/*
Exercício 2

TOP Estados

Liste os estados com maior número de apostas, e maior valor arrecadado em cada concurso. 
Adicionalmente também deve ser exibido o total de acertadores e o valor da premiação em cada estado.

*/

select * from aposta;
select * from aposta_premiada;

select apo.idconcurso, count(1) as qtdApostas, cid.uf,  sum(apo.valor) as valorArrecadado, 
count(appre.idaposta) as qtdganhadores, sum(appre.valor) as premiacaoEstado
from aposta apo
join cidade cid on cid.idcidade = apo.idcidade
left join aposta_premiada apPre on apPre.idaposta = apo.idaposta
group by cid.uf, apo.idconcurso
order by idconcurso;

/*
Exercício 3

Identificação de Fraude

Crie uma view para consultar possibilidades de fraudes. Inicialmente identifique 
apostas com registro (log) de criação/alteração executado após a data do sorteio.

*/
create or replace view vwFraudes as 
select LogAposta.idlogaposta as logApostaID, LogAposta.operacao as logApostaOpe, LogNumeroAposta.idlognumeroaposta as logNumApostaID, LogNumeroAposta.operacao  as logNumApostaOpe from LogAposta 
join LogNumeroAposta on LogNumeroAposta.IDAposta_Nova = LogAposta.IDAPOSTA
join concurso co on co.idconcurso = LogAposta.IDConcurso_Novo
where LogAposta.data > co.data_sorteio;










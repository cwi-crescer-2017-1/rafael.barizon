/*Exercício 1

Cidades Duplicadas

A partir do conhecimento de procedures/functions e packages obtidos (rapidamente) 
crie uma package que permita eliminar cidades duplicadas. 
Para essa tarefa respeiteas seguintes regras: 

-> identifique as cidades duplicadas; 
-> identifique os clientes que estão relacionados com ela; 
-> altere no cliente (idcidade) para manter apenas a cidade duplicada de menor ID; 
-> certificando-se que não há mais clientes utilizando cidades duplicadas elimine-as.

Utilize uma codificação que possibilite o uso de teste unitário.*/
create or replace package pck_Cidades_Duplicadas as
procedure clientes_cidades_duplicadas;
 function busca_cidade_retorna_menor_id 
          (NomeEntrada in varchar2, UfEntrada in varchar2) return cidade.idcidade%type;
end;

create or replace package body pck_Cidades_Duplicadas as

  procedure clientes_cidades_duplicadas is
    cursor c_cidades is
       select Nome, UF
       from   Cidade
       group  by Nome, UF
       having count(1) >1;
  ----
  cursor c_clientes (pNome in varchar2,
                     pUF   in varchar2) is
     select cli.IDCliente
     from   Cliente cli
      inner join Cidade cid on cid.IDCidade = cli.IDCidade
     where  cid.Nome = pNome
     and    cid.UF   = pUF;
     vIdCidade cidade.idcidade%type;
    begin
      FOR c in c_cidades LOOP
          vIdCidade:= busca_cidade_retorna_menor_id(c.Nome, c.uf);
          FOR i in c_clientes (c.Nome, c.UF) LOOP
            update cliente 
              set idcidade = vIdCidade
              where idcliente = i.idcliente;
          END LOOP;
          delete from cidade
            where NOME = c.nome
            and UF = c.uf
            and IDCIDADE != vIdCidade;
      END LOOP;
end; --procedure clientes_cidades_duplicadas

  function busca_cidade_retorna_menor_id 
          (NomeEntrada in varchar2, UfEntrada in varchar2) return cidade.idcidade%type is
  vIDCidade cidade.idcidade%type;
  begin
  
    select min(idcidade) 
    into vIDCidade
    from cidade
    where nome = NomeEntrada
    and uf = UfEntrada;
    
    return vIDCidade;
  end;
  
end pck_Cidades_Duplicadas;

begin
 pck_Cidades_Duplicadas.clientes_cidades_duplicadas;
 dbms_output.put_line('EXECUTO ALGUMA COISA');
end;

select Nome, UF
from   Cidade
group  by Nome, UF
having count(1) >1;

select count(1) from cidade;

select count(1) from cliente;

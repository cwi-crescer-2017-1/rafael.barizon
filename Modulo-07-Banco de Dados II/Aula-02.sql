/*select * from cidade order by nome;

Select Nome, count(nome), uf
     From   Cidade
     group by nome, uf


Cidades Duplicadas

Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
Fa�a um c�digo (PL/SQL) que liste quais s�o as cidades duplicadas. Ap�s isso 
liste todos os clientes que est�o relacionados com estas cidades
*/
--select * from cidade
/*
DECLARE
 CURSOR c_ListaCliente IS
    select cliente.nome 
      from cliente 
      join cidade on cliente.idcidade = cidade.idcidade 
      where cidade.nome in (select nome from (
                               Select Nome, count(nome) as quantidade, uf
                                 From   Cidade
                                 group by nome, uf
                                 having count(nome) > 1)
                               );
BEGIN 
   for clienteLista in c_ListaCliente loop
    DBMS_OUTPUT.PUT_LINE(clienteLista.nome);
   end loop;
END;

*/

/*
Exerc�cio 2

Atualizando Valor do Pedido

Fa�a uma rotina que permita atualizar o valor do pedido a partir dos seus itens. 
Esta rotina deve receber por parametro o IDPedido e ent�o verificar o valor 
total de seus itens (quantidade x valor unit�rio).
*/
--select * from pedido;
--select * from pedidoitem;


declare
  cursor C_ItensPedido(idPed in number) is
    select quantidade, precounitario
    from pedidoitem
    where idpedido = idPed;
  vValorTotal pedido.valorpedido%type;
  vIdPedido pedido.idpedido%type;
begin
  vValorTotal := 0.0;
  vIdPedido := 15;

  for item in C_ItensPedido(vIdPedido) loop
   vValorTotal := vValorTotal + (item.quantidade * item.precounitario);
  end loop;

   update pedido set valorpedido = vValorTotal 
     where idPedido = vIdPedido;
end;










--
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

DECLARE
 CURSOR c_ListaCliente IS
    select cliente.nome 
      from cliente 
      join cidade on cliente.idcidade = cidade.idcidade 
      where (cidade.nome, cidade.uf )in (
                               Select Nome, uf
                                 From   Cidade
                                 group by nome, uf
                                 having count(nome) > 1
                               );
BEGIN 
   for clienteLista in c_ListaCliente loop
    DBMS_OUTPUT.PUT_LINE(clienteLista.nome);
   end loop;
END;


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
  vIdPedido := 123;

  for item in C_ItensPedido(vIdPedido) loop
   vValorTotal := vValorTotal + (item.quantidade * item.precounitario);
  end loop;

   update pedido set valorpedido = vValorTotal 
     where idPedido = vIdPedido;
end;

select * from pedido where idpedido = 123;

/*Exerc�cio 3

Atualiza��o de Clientes

Crie uma rotina que atualize todos os clientes que n�o realizaram nenhum pedido 
nos �ltimos 6 meses (considere apenas o m�s, dia 01 do 6� m�s anterior). 
Definir o atributo Situacao para I.
*/
--update cliente situacao = 'I' where idcliente not in (C_ClientesAtivos6Meses)
begin
  update cliente 
    set situacao = 'I' 
    where idcliente not in (
    select c.IDCLIENTE
        from cliente c
        join pedido p on p.idcliente = c.idcliente 
        and p.datapedido >= add_months(trunc(sysdate), -6 )
        group by c.idcliente
        );
end;
/*
Exerc�cio 4

Previs�o de Materiais
Fa�a uma rotina que receba dois par�metros:
IDProduto
M�s e Ano
E ent�o fa�a uma rotina que verifique no ANO/M�S para o produto informado
qual a lista de materiais (incluindo a quantidade) � necess�rio para atender 
todos os Pedidos desde per�odo. Deve imprimir o nome do material e quantidade total.
*/

declare
  cursor c_ListaQuantidadeDoPedido(ano in numeric, mes in numeric, idProd in numeric) is
      select sum(pedItem.quantidade) as soma from pedido ped
      join pedidoitem pedItem on pedItem.IDPEDIDO = ped.IDPEDIDO
      and pedItem.IDPRODUTO = idProd
      where extract(year from ped.datapedido) = ano and
            extract(month from ped.datapedido) = mes;
  cursor c_ListaMatQtdDesc(idProd in numeric) is
      select mat.descricao, mat.PESOLIQUIDO, prodm.quantidade 
      from produtomaterial prodM 
      join material mat on mat.idmaterial = prodm.idmaterial
      where prodM.idproduto = idProd;
 
  vAno numeric;
  vMes numeric;
  vIDProduto numeric;
  vQuantidadeTOtalPedido PEDIDOITEM.QUANTIDADE%type;
  vPesoVesesQtd MATERIAL.PESOLIQUIDO%type;
begin
  vAno := 2017;
  vMes := 04;
  vIDProduto := 4246;
  vQuantidadeTOtalPedido := 0.0;
  vPesoVesesQtd := 0.0;
  
  for somaLista in c_ListaQuantidadeDoPedido(vAno, vMes, vIDProduto) loop
    vQuantidadeTOtalPedido := vQuantidadeTOtalPedido + somaLista.soma;
    DBMS_OUTPUT.PUT_LINE(somaLista.soma);
  end loop;
  
  for materialLista in c_ListaMatQtdDesc(vIDProduto)loop 
    --DBMS_OUTPUT.PUT_LINE(materialLista.PESOLIQUIDO || ' - ' || materialLista.quantidade || ' - ' || vQuantidadeTOtalPedido);
    vPesoVesesQtd := vQuantidadeTOtalPedido * (  materialLista.PESOLIQUIDO * materialLista.quantidade );
    if (vPesoVesesQtd > 0) then
    DBMS_OUTPUT.PUT_LINE(materialLista.descricao || ' - ' || to_char(vPesoVesesQtd) );
    end if;
    --Deve imprimir o nome do material e quantidade total.
  end loop;
end;




--
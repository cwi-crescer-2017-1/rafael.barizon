/*select * from cidade order by nome;

Select Nome, count(nome), uf
     From   Cidade
     group by nome, uf


Cidades Duplicadas

Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
Faça um código (PL/SQL) que liste quais são as cidades duplicadas. Após isso 
liste todos os clientes que estão relacionados com estas cidades
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
Exercício 2

Atualizando Valor do Pedido

Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens. 
Esta rotina deve receber por parametro o IDPedido e então verificar o valor 
total de seus itens (quantidade x valor unitário).
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

/*Exercício 3

Atualização de Clientes

Crie uma rotina que atualize todos os clientes que não realizaram nenhum pedido 
nos últimos 6 meses (considere apenas o mês, dia 01 do 6º mês anterior). 
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
Exercício 4

Previsão de Materiais
Faça uma rotina que receba dois parâmetros:
IDProduto
Mês e Ano
E então faça uma rotina que verifique no ANO/MÊS para o produto informado
qual a lista de materiais (incluindo a quantidade) é necessário para atender 
todos os Pedidos desde período. Deve imprimir o nome do material e quantidade total.
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
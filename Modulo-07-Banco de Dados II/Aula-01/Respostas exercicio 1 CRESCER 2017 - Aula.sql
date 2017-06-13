--Exerc�cio 1
--Produtos inativos
--Liste os produtos (id e nome) que n�o tiveram nenhuma compra nos �ltimos quatro meses.

select * from produto where situacao='n'; 
select * from pedidoitem;
select * from pedido;

--create view vw4Meses as 
select prod.idproduto, prod.nome
from produto prod 
where prod.idproduto not in
(
select idproduto
from  pedidoitem 
inner join pedido on pedidoitem.idpedido = pedido.idpedido
where pedido.datapedido >= add_months(trunc(sysdate), -4)
)
order by prod.idproduto;

--select * from user_tables;
--exec dbms_stats.gather_schema_stats(USER);

--Exerc�cio 2
--Alterando status
--Altere o status dos produtos (campo situacao) que n�o tiveram nenhum pedido nos �ltimos quatro meses.


update produto set SITUACAO = 'i'  where idproduto in (SELECT idproduto from vw4meses);
commit;
--Exerc�cio 3
--Parametro
--Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade 
--de itens na tabela PedidoItem com este IDProduto foram vendidos no �ltimo ano (desde janeiro/2017).
select * from produto where idproduto = 2;

define prodID;

select sum(item.quantidade) qtde
from pedidoitem item
  inner join pedido ped on ped.idpedido = item.idpedido
  where item.idproduto = :p_IDProduto
 and ped.datapedido >= trunc(sysdate, 'yyyy');


select  sum(pedidoitem.QUANTIDADE) total
from pedidoitem 
join pedido on pedidoitem.idpedido = pedido.idpedido 
          and pedidoitem.idproduto = :prodid 
          and pedido.DATAENTREGA >= trunc(sysdate, 'YYYY');




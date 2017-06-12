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
select prod.idproduto
from produto prod
inner join pedidoitem on pedidoitem.idproduto = prod.idproduto
inner join pedido on pedidoitem.idpedido = pedido.idpedido
where pedido.datapedido > sysdate-120 
);



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

select prod.idproduto, count(prod.idproduto) total
from produto prod
join pedidoitem on pedidoitem.idproduto = prod.idproduto and pedidoitem.idproduto = :prodid
join pedido on pedidoitem.idpedido = pedido.idpedido and pedido.DATAENTREGA >= to_date(201701, 'YYYYMM')
group by prod.idproduto;




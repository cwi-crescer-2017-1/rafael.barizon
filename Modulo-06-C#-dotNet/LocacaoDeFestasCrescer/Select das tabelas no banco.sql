SELECT * FROM Clientes;

SELECT * FROM Usuarios;

SELECT * FROM produtos;

SELECT * FROM produtosPacotes;

SELECT * FROM produtosOpcionais;

SELECT * FROM Pedidos;

insert into usuarios (nome, email, senha, gerente) 
values ('Rafael Barizon', 'rafael.barizon@cwi.com.br', '5bd31a775b78d72af46d99b409ec19c6', 0)

update usuarios set email = 'rafael' where id = 2  
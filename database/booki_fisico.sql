CREATE DATABASE booki;

USE booki;

CREATE TABLE Autores (
id_autor INTEGER PRIMARY KEY auto_increment,
nome_autor VARCHAR(50)
);

CREATE TABLE Editoras (
id_editora INTEGER PRIMARY KEY auto_increment,
nome_editora VARCHAR(50)
);

CREATE TABLE Livros (
id_livro INTEGER PRIMARY KEY auto_increment,
nome_livro VARCHAR(80),
preco_livro DECIMAL(5,2),
publicacao_livro DATE,
id_editora INTEGER,
id_autor INTEGER,
FOREIGN KEY(id_editora) REFERENCES Editoras (id_editora),
FOREIGN KEY(id_autor) REFERENCES Autores (id_autor)
);

CREATE TABLE Usuarios (
id_usuario INTEGER PRIMARY KEY auto_increment,
email_usuario VARCHAR(80),
nome_usuario VARCHAR(80),
senha_usuario VARCHAR(10),
id_permissao INTEGER
);

CREATE TABLE Permissoes (
id_permissao INTEGER PRIMARY KEY auto_increment,
tipo_permissao VARCHAR(20)
);

CREATE TABLE Itens_compra (
qtd_itens INTEGER,
valor_itens DECIMAL(5),
id_livro INTEGER,
id_compra INTEGER,
FOREIGN KEY(id_livro) REFERENCES Livros (id_livro)
);

CREATE TABLE Compra (
id_compra INTEGER PRIMARY KEY auto_increment,
data_compra DATETIME,
valor_compra DECIMAL(5),
id_usuario INTEGER,
FOREIGN KEY(id_usuario) REFERENCES Usuarios (id_usuario)
);

ALTER TABLE Usuarios ADD FOREIGN KEY(id_permissao) REFERENCES Permissoes (id_permissao);
ALTER TABLE Itens_compra ADD FOREIGN KEY(id_compra) REFERENCES Compra (id_compra);


CREATE VIEW livros_completo as
SELECT l.id_livro, l.nome_livro, l.preco_livro, l.publicacao_livro, e.id_editora, e.nome_editora, a.id_autor, a.nome_autor 
FROM livros l, editoras e, autores a 
where l.id_editora = e.id_editora and l.id_autor = a.id_autor order by l.id_livro asc;


select * from autores;
select * from editoras;
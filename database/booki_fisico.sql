CREATE DATABASE booki;

USE booki;

CREATE TABLE autores (
id_autor INTEGER PRIMARY KEY auto_increment,
nome_autor varchar(50)
);

CREATE TABLE Editoras (
id_editora INTEGER PRIMARY KEY auto_increment,
nome_editora varchar(50)
);




select * from autores;
select * from editoras;
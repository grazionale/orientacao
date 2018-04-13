create database orientacaoweb;

use orientacaoweb;

create table usuario(
	idUsuario int auto_increment primary key,
    nomeUsuario text not null,
    emailUsuario text not null,
    senhaUsuario text not null
);

create table professor(
	idProfessor int auto_increment primary key,
    nomeProfessor text not null
);


create table orientacao(
	idOrientacao int auto_increment primary key,
    descricaoOrientacao text not null,
    orientadoOrientacao text not null,
    idProfessorOrientacao int not null,
    CONSTRAINT fkProfessorOrientacao FOREIGN KEY (idProfessorOrientacao) REFERENCES professor (idProfessor)
);

describe orientacao;


insert into usuario values(1, "admin", "admin@admin.com", "admin");  

select * from usuario;

    
    
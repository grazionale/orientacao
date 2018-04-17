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
insert into professor values(1, "Nardi");
insert into professor values(2, "Erika");
insert into orientacao values(1, "TCC 1", "Juninho", 1);
insert into orientacao values(2, "TCC 1 tbm", "João Capriel", 2);    

select * from usuario;

    
    
CREATE TABLE estudante (
	id integer PRIMARY KEY,
	nome varchar(200) NOT NULL,
	telefone varchar(14),
	email varchar(100)
);

insert into estudante (id, nome, telefone, email) values (1, 'Scott', '95656-1248', 'scott@tiger.com.br');
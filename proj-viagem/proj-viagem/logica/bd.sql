use java;

create or replace table contato(
id int(10) auto_increment not null,
nome varchar(70) not null,
email varchar(100) not null unique,
primary key(id)
);

create or replace table destino(
id int(10) auto_increment not null,
nome varchar(80) not null,
continente varchar(20) not null,
pais varchar(80),
preco int(15) not null,
desconto int(3),
preco_desconto int(15),
duracao varchar(80) not null,
primary key(id)
);

create or replace table cliente(
id int(10) auto_increment not null,
nome varchar(70) not null,
senha varchar(80) not null,
data_criado datetime,
ativo bit not null,
primary key(id)
);

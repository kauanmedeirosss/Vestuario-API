CREATE TABLE vestimentas(
    id bigint not null auto_increment,
    nome varchar(150) not null,
    cor varchar(30) not null,
    tamanho char(2) not null,
    tipo char(9) not null,
    loja varchar(50) not null,
    preco numeric(6,2) not null,

    primary key (id)
);
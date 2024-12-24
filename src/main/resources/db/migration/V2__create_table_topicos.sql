create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(100) not null unique,
    data_criacao datetime not null,
    status varchar(255) not null DEFAULT "NAO_RESPONDIDO",
    autor bigint not null,

    primary key(id),
    constraint fk_topicos_autor foreign key(autor) references usuarios(id)
);
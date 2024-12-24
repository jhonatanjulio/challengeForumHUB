create table respostas(
    id bigint not null auto_increment,
    mensagem varchar(255) not null,
    data_criacao datetime not null,
    topico bigint not null,
    autor bigint not null,
    solucao tinyint(1) not null default 0,

    primary key(id),
    constraint fk_respostas_autor foreign key(autor) references usuarios(id),
    constraint fk_respostas_topico foreign key(topico) references topicos(id)
);
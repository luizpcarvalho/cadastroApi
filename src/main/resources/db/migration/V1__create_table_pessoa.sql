create table if not exists pessoa (
    id varchar(100) PRIMARY KEY,
    nome varchar(100) not null,
    nascimento date not null,
    cep varchar(10) not null
);
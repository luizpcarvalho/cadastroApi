create table if not exists endereco (
    id_endereco varchar(100) PRIMARY KEY,
    logradouro varchar(100),
    complemento varchar(50),
    localidade varchar(20),
    uf varchar(2)
);

create table if not exists pessoa (
    id_pessoa varchar(100) PRIMARY KEY,
    nome varchar(100) not null,
    nascimento date not null,
    cep varchar(10) not null,
    endereco varchar(100) references endereco(id_endereco)
);

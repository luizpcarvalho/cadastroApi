create table if not exists endereco (
    id_endereco varchar(100) PRIMARY KEY,
    logradouro varchar(100),
    complemento varchar(50),
    localidade varchar(20),
    uf varchar(2)
);

alter table pessoa
rename column id to id_pessoa;

alter table pessoa add endereco varchar(100) references endereco(id_endereco);

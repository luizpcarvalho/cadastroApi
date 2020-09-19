create table if not exists endereco (
    id_endereco bigserial PRIMARY KEY,
    logradouro varchar(100),
    complemento varchar(50),
    localidade varchar(20),
    uf varchar(2)
);

alter table pessoa
rename column id to id_pessoa;

alter table pessoa add endereco bigint references endereco(id_endereco);

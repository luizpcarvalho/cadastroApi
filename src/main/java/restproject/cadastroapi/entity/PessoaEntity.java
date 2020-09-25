package restproject.cadastroapi.entity;

import restproject.cadastroapi.request.PessoaRequest;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity(name = "pessoa")
public class PessoaEntity {

    public PessoaEntity(final PessoaRequest pessoaRequest, final EnderecoEntity endereco) {
        this.id = UUID.randomUUID().toString();
        this.nome = pessoaRequest.getNome();
        this.nascimento = LocalDate.parse(pessoaRequest.getNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.cep = pessoaRequest.getCep();
        this.endereco = endereco;
    }

    @Id
    @Column(name = "id_pessoa")
    private String id;

    private String nome;

    private LocalDate nascimento;

    private String cep;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id_endereco", nullable = false)
    private EnderecoEntity endereco;

    public PessoaEntity(){}

    public PessoaEntity(String id, String nome, LocalDate nascimento, String cep, EnderecoEntity endereco) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cep = cep;
        this.endereco = endereco;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getNascimento() { return nascimento; }

    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public EnderecoEntity getEndereco() { return endereco; }

    public void setEndereco(EnderecoEntity endereco) { this.endereco = endereco; }

}

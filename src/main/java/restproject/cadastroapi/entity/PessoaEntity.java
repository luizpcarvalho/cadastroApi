package restproject.cadastroapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "pessoa")
public class PessoaEntity {

    @Id
    private String id;

    private String nome;

    private LocalDate nascimento;

    private String cep;

    public PessoaEntity(){}

    public PessoaEntity(String id, String nome, LocalDate nascimento, String cep) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cep = cep;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getNascimento() { return nascimento; }

    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }
}

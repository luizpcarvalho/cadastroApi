package restproject.cadastroapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PessoaEntity {

    @Id
    private String id;
    private String nome;
    private Date nascimento;
    private String cep;

    public PessoaEntity(String id, String nome, Date nascimento, String cep) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cep = cep;
    }
}

package restproject.cadastroapi.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Pessoa {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    //@JsonFormat(pattern = "dd-MM-yyyy")
    @NotBlank(message = "Data é obrigatória")
    private String nascimento;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

package restproject.cadastroapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Pessoa {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    //@JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Data é obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nascimento;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

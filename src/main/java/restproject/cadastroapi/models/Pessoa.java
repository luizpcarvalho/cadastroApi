package restproject.cadastroapi.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

    private String nome;
    private Date nascimento;
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

    public void setNascimento(String nascimento) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.nascimento = fmt.parse(nascimento);
        }catch (ParseException e){
            System.out.println("Data inválida");
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

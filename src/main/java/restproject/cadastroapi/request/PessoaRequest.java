package restproject.cadastroapi.request;

import restproject.cadastroapi.validation.CepValidation;
import restproject.cadastroapi.validation.DateValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PessoaRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @DateValidation
    private String nascimento;

    @CepValidation
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

    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

}

// TODO Criar estrutura para padrões de mensagem

package restproject.cadastroapi.request;

import javax.validation.constraints.NotBlank;

public class PessoaRequest {

    private String id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Data é obrigatória")
    private String nascimento;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

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

package restproject.cadastroapi.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PessoaRequest {

    private static final String REGEX_VALIDA_DATA = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    // TODO Remover o id na request
    private String id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    // TODO Criar annotation para validar data
    @NotBlank(message = "Data é obrigatória")
    @Pattern(message = "Data inválida", regexp = REGEX_VALIDA_DATA)
    private String nascimento;

    // TODO Criar annotation para validar CEP
    @NotBlank(message = "CEP é obrigatório")
    @Size(max = 10)
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

    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

}

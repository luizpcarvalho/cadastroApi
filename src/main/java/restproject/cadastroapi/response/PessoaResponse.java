package restproject.cadastroapi.response;

public class PessoaResponse {

    private String id;

    public PessoaResponse() { }

    public PessoaResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

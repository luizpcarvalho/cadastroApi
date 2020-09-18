package restproject.cadastroapi.response;

public class CepResponse {

    private String logradouro;
    private String complemento;
    private String localidade;
    private String uf;

    public CepResponse() {

    }

    public CepResponse(String cep) {
        CepResponse endereco = new ViaCepResponse(cep).getEndereco();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}

package restproject.cadastroapi.response;

public class CepResponse {

    private String rua;
    private String complemento;
    private String cidade;
    private String estado;
    private String ddd;

    public CepResponse() {

    }

    public CepResponse(final ViaCepResponse viaCep) {
        this.rua = viaCep.getLogradouro();
        this.complemento = viaCep.getComplemento();
        this.cidade = viaCep.getLocalidade();
        this.estado = viaCep.getUf();
        this.ddd = viaCep.getDdd();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}

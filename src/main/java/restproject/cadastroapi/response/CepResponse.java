package restproject.cadastroapi.response;

public class CepResponse {

    // Eu coloquei os nomes diferentes para vc entender que, essa é a classe que representa um CEP
    // em sua aplicação. veja que nessa classe o logradouro se chama rua, sua aplicação não sabe
    // o que é logradouro, ela conhece rua e por ai vai

    private String rua;
    private String complemento;
    private String cidade;
    private String estado;
    private String ddd;

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

    @Override
    public String toString() {
        return "CepResponse{" +
                "rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}

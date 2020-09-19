package restproject.cadastroapi.entity;

import restproject.cadastroapi.response.CepResponse;

import javax.persistence.*;

@Entity(name = "endereco")
public class EnderecoEntity {

    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String complemento;
    private String localidade;
    private String uf;

    public EnderecoEntity() { }

    public EnderecoEntity(CepResponse cepResponse) {
        this.logradouro = cepResponse.getLogradouro();
        this.complemento = cepResponse.getComplemento();
        this.localidade = cepResponse.getLocalidade();
        this.uf = cepResponse.getUf();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLogradouro() { return logradouro; }

    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getLocalidade() { return localidade; }

    public void setLocalidade(String localidade) { this.localidade = localidade; }

    public String getUf() { return uf; }

    public void setUf(String uf) { this.uf = uf; }

}

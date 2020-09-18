package restproject.cadastroapi.response;

import org.springframework.web.client.RestTemplate;

public class ViaCepResponse {

    private CepResponse endereco;

    public static CepResponse obterEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://viacep.com.br/ws/"+cep+"/json/";
        CepResponse endereco = restTemplate.getForObject(uri, CepResponse.class);

        return endereco;
    }

    public ViaCepResponse(String cep) {
        this.endereco = obterEndereco(cep);
    }

    public CepResponse getEndereco() {
        return endereco;
    }

    public void setEndereco(CepResponse endereco) {
        this.endereco = endereco;
    }

}

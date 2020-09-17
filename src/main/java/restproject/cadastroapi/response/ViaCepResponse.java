package restproject.cadastroapi.response;

import org.springframework.web.client.RestTemplate;

public class ViaCepResponse {

    public static CepResponse obterEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://viacep.com.br/ws/"+cep+"/json/";
        CepResponse endereco = restTemplate.getForObject(uri, CepResponse.class);

        return endereco;
    }

}

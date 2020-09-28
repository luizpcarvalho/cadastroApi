package restproject.cadastroapi.core.cep.viacep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import restproject.cadastroapi.response.ViaCepResponse;

@Component
public class ViaCepClient {

    //@Value("${cep.service.via-cep.url}")
    private String viaCepUrl = "http://viacep.com.br/ws/{cep}/json/";

    @Autowired
    private RestTemplate client = new RestTemplate();

    public ViaCepResponse get(final String cep){
        String uri = viaCepUrl.replace("{cep}", cep);
        ViaCepResponse viaCepResponse = client.getForObject(uri, ViaCepResponse.class);
        return viaCepResponse;
    }

}

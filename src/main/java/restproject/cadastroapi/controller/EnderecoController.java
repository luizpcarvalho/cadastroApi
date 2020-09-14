package restproject.cadastroapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.repository.EnderecoRepository;

@RestController
public class EnderecoController {

    public static EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public static EnderecoEntity obterEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://viacep.com.br/ws/"+cep+"/json/";
        EnderecoEntity endereco = restTemplate.getForObject(uri, EnderecoEntity.class);

        endereco.setId("1");
        enderecoRepository.save(endereco);

        return endereco;
    }

}

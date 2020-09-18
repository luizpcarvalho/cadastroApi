package restproject.cadastroapi.controller;

import org.springframework.web.bind.annotation.RestController;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.repository.EnderecoRepository;
import restproject.cadastroapi.response.CepResponse;
import restproject.cadastroapi.response.ViaCepResponse;

@RestController
public class EnderecoController {

    public static EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public static EnderecoEntity salvarEndereco(String cep, String id){
        CepResponse cepResponse = new CepResponse(cep);
        EnderecoEntity endereco = new EnderecoEntity(cepResponse);
        endereco.setId(id);
        enderecoRepository.save(endereco);

        return endereco;
    }

}

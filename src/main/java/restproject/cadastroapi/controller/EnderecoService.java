package restproject.cadastroapi.controller;

import org.springframework.stereotype.Service;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.repository.EnderecoRepository;
import restproject.cadastroapi.response.CepResponse;

@Service
public class EnderecoService {

    public static EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public static EnderecoEntity salvarEndereco(String cep){
        CepResponse cepResponse = new CepResponse(cep);
        EnderecoEntity endereco = new EnderecoEntity(cepResponse);
        enderecoRepository.save(endereco);

        return endereco;
    }

}

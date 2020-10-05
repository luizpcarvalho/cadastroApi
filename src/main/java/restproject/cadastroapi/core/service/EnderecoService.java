package restproject.cadastroapi.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restproject.cadastroapi.core.cep.CepService;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.repository.EnderecoRepository;
import restproject.cadastroapi.response.CepResponse;

@Service
public class EnderecoService {

    public static EnderecoRepository enderecoRepository;

    @Autowired
    private CepService cepService;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoEntity salvarEndereco(String cep){
        CepResponse cepResponse = cepService.findCep(cep);
        EnderecoEntity endereco = new EnderecoEntity(cepResponse);
        endereco = enderecoRepository.save(endereco);

        return endereco;
    }

    public EnderecoEntity findByCep(String cep){
        return enderecoRepository.findByCep(cep);
    }

}

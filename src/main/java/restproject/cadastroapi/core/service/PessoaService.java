package restproject.cadastroapi.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.entity.PessoaEntity;
import restproject.cadastroapi.repository.PessoaRepository;
import restproject.cadastroapi.request.PessoaRequest;
import restproject.cadastroapi.response.PessoaResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    public PessoaResponse salvarPessoa(final PessoaRequest pessoaRequest){
        EnderecoEntity enderecoEntity;

        if(enderecoService.findByCep(pessoaRequest.getCep()) != null){
            enderecoEntity = enderecoService.findByCep(pessoaRequest.getCep());
        } else {
            enderecoEntity = enderecoService.salvarEndereco(pessoaRequest.getCep());
        }

        PessoaEntity pessoaEntity = new PessoaEntity(pessoaRequest, enderecoEntity);

        pessoaEntity = pessoaRepository.save(pessoaEntity);

        return new PessoaResponse(pessoaEntity.getId());
    }

    public List<PessoaResponse> findAll(){
        return pessoaRepository.findAll()
                .stream()
                .map(item -> new PessoaResponse(item.getId()))
                .collect(Collectors.toList());
    }

    public PessoaResponse findById(String id){
        return new PessoaResponse(pessoaRepository.getOne(id).getId());
    }


}

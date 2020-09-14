package restproject.cadastroapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import restproject.cadastroapi.entity.EnderecoEntity;
import restproject.cadastroapi.entity.PessoaEntity;
import restproject.cadastroapi.response.ApiErrorResponse;
import restproject.cadastroapi.request.PessoaRequest;
import restproject.cadastroapi.response.PessoaResponse;
import restproject.cadastroapi.repository.PessoaRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {

    public static final String BASE_URL = "/pessoas";

    // TODO Criar annotation para validar data
    public static final DateTimeFormatter FORMATO_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponse salvarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
        EnderecoEntity endereco = EnderecoController.obterEndereco(pessoaRequest.getCep());
        PessoaEntity pessoaEntity = new PessoaEntity(pessoaRequest.getId(), pessoaRequest.getNome(), LocalDate.parse(pessoaRequest.getNascimento(), FORMATO_BR), pessoaRequest.getCep(), endereco);
        pessoaRepository.save(pessoaEntity);
        PessoaResponse pessoaResponse = new PessoaResponse(pessoaRequest.getId());
        return pessoaResponse;
    }

    // TODO Definir payload a ser retornado para este método, quais atributos?
    @GetMapping
    public List<PessoaEntity> listarPessoas(){
        List<PessoaEntity> pessoas = new ArrayList<>();
        pessoaRepository.findAll().forEach(pessoa -> {
            pessoas.add(pessoa);
        });
        return pessoas;
    }

    @GetMapping("/{id}")
    public PessoaEntity buscarPessoa(@PathVariable(name = "id") String id){
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).get();
        return pessoaEntity;
    }

    // TODO Refatorar Exception handler para outro pacote
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ApiErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        List<ApiErrorResponse> erros = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(er -> {
            ApiErrorResponse erro = new ApiErrorResponse();
            erro.setCampo(er.getField());
            erro.setMensagem(er.getDefaultMessage());
            erros.add(erro);
        });
        return erros;
    }

}

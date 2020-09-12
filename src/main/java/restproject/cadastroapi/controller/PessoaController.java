package restproject.cadastroapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import restproject.cadastroapi.response.ApiErrorResponse;
import restproject.cadastroapi.request.PessoaRequest;
import restproject.cadastroapi.response.PessoaResponse;
import restproject.cadastroapi.repository.PessoaRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {

    public static final String BASE_URL = "/pessoas";

    public static PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaResponse salvarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
        pessoaRepository.save(pessoaRequest);
        PessoaResponse pessoaResponse = new PessoaResponse(pessoaRequest.getId());
        return pessoaResponse;
    }

    @GetMapping
    public Iterable<PessoaRequest> listarPessoas(){
        return pessoaRepository.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
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

package restproject.cadastroapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import restproject.cadastroapi.models.ApiErrorResponse;
import restproject.cadastroapi.models.PessoaResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {

    public static final String BASE_URL = "/pessoas";

    @PostMapping
    public ResponseEntity<String> salvarPessoa(@Valid @RequestBody PessoaResponse pessoaResponse) {
        // pessoaRepository.save(pessoa);
        return ResponseEntity.ok("Dados inseridos com sucesso");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public List<ApiErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        List<ApiErrorResponse> erros = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(er -> {
            ApiErrorResponse erro = new ApiErrorResponse();
            erro.setCampo(er.getField());
            erro.setMensagem(er.getDefaultMessage());
            erro.setHttpStatus(HttpStatus.BAD_REQUEST);
            erros.add(erro);
        });
        return erros;
    }

}

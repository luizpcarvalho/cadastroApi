package restproject.cadastroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import restproject.cadastroapi.models.Pessoa;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {

    public static final String BASE_URL = "/cadastro";

    @PostMapping
    public ResponseEntity<String> salvarPessoa(@Valid @RequestBody Pessoa pessoa) {
        // pessoaRepository.save(pessoa);
        return ResponseEntity.ok("Dados inseridos com sucesso");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        Map<String, String> erros = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(erro ->
                erros.put(erro.getField(), erro.getDefaultMessage()));
        return erros;
    }

}

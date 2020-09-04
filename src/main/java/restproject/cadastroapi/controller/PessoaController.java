package restproject.cadastroapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restproject.cadastroapi.models.Pessoa;

@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {

    public static final String BASE_URL = "/cadastro";

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void salvarPessoa(@RequestBody Pessoa pessoa){
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Nascimento: " + pessoa.getNascimento());
        System.out.println("CEP: " + pessoa.getCep());
    }

}

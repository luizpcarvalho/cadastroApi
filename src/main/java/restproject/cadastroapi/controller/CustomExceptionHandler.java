package restproject.cadastroapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import restproject.cadastroapi.response.ApiErrorResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomExceptionHandler {

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

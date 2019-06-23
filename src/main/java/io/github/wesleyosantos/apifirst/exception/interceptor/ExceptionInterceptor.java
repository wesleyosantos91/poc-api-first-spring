package io.github.wesleyosantos.apifirst.exception.interceptor;

import io.github.wesleyosantos.apifirst.exception.core.ObjectNotFoundException;
import io.swagger.model.ResponseErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

/**
 * Created by wesleyosantos91 on 2019-06-23.
 */
@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ResponseErro> handlerPessoaNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {

        ResponseErro error = new ResponseErro();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setErro(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setMensagem(e.getMessage());
        error.setTimestamp(OffsetDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}

package io.github.wesleyosantos.apifirst.api;

import io.github.wesleyosantos.apifirst.event.RecursoCriadoEvent;
import io.github.wesleyosantos.apifirst.service.PessoaService;
import io.swagger.api.PessoasApi;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by wesleyosantos91 on 2019-06-03.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoasApiImpl implements PessoasApi {

    private final PessoaService pessoaService;

    private final ApplicationEventPublisher publisher;

    private final HttpServletResponse response;

    @Override
    public ResponseEntity<ResponsePessoa> alterarPessoa(Long codigo, @Valid RequestPutPessoa body) {
        return ResponseEntity.ok(this.pessoaService.alterarPessoa(codigo, body));
    }

    @Override
    public ResponseEntity<ResponsePessoa> cadastrarPessoa(@Valid RequestPostPessoa body) {

        ResponsePessoa responsePessoa = this.pessoaService.cadastrarPessoa(body);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, responsePessoa.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(responsePessoa);
    }

    @Override
    public ResponseEntity<ResponsePessoa> consultarPeloCodigo(Long codigo) {

        return ResponseEntity.ok(this.pessoaService.consultarPeloCodigo(codigo));
    }

    @Override
    public ResponseEntity<List<ResponsePessoa>> consultarTodos() {

        return ResponseEntity.ok(this.pessoaService.consultarTodos());
    }

    @Override
    public ResponseEntity<Void> excluirPessoa(Long codigo) {

        this.pessoaService.excluirPessoa(codigo);

        return ResponseEntity.noContent().build();
    }
}

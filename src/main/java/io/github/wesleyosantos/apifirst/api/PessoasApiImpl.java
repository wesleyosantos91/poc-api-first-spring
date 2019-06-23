package io.github.wesleyosantos.apifirst.api;

import io.github.wesleyosantos.apifirst.service.PessoaService;
import io.swagger.api.PessoasApi;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wesleyosantos91 on 2019-06-03.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoasApiImpl implements PessoasApi {

    private final PessoaService pessoaService;

    @Override
    public ResponseEntity<Void> alterarPessoa(Long codigo, @Valid RequestPutPessoa body) {
        return null;
    }

    @Override
    public ResponseEntity<ResponsePessoa> cadastrarPessoa(@Valid RequestPostPessoa body) {
        return null;
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
        return null;
    }
}

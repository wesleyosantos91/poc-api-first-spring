package io.github.wesleyosantos.apifirst.api;

import io.swagger.api.PessoasApi;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wesleyosantos91 on 2019-06-03.
 */
@Controller
public class PessoasApiImpl implements PessoasApi {

    @Override
    public ResponseEntity<Void> alterarPessoa(Integer codigo, @Valid RequestPutPessoa body) {
        return null;
    }

    @Override
    public ResponseEntity<ResponsePessoa> cadastrarPessoa(@Valid RequestPostPessoa body) {
        return null;
    }

    @Override
    public ResponseEntity<ResponsePessoa> consultarPeloCodigo(Integer codigo) {
        return null;
    }

    @Override
    public ResponseEntity<List<ResponsePessoa>> consultarTodos() {
        return null;
    }

    @Override
    public ResponseEntity<Void> excluirPessoa(Integer codigo) {
        return null;
    }
}

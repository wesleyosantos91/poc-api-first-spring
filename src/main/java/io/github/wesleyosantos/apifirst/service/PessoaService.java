package io.github.wesleyosantos.apifirst.service;

import io.github.wesleyosantos.apifirst.exception.core.ObjectNotFoundException;
import io.github.wesleyosantos.apifirst.model.Pessoa;
import io.github.wesleyosantos.apifirst.repository.PessoaRepository;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.ResponsePessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by wesleyosantos91 on 2019-06-22.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository pessoaRepository;


    public ResponsePessoa cadastrarPessoa(RequestPostPessoa body) {

        Pessoa pessoa = this.pessoaRepository.save(getResponsePessoa(body));

        return getResponsePessoa(pessoa);
    }


    public List<ResponsePessoa> consultarTodos() {

        return this.pessoaRepository.findAll().stream().map(p -> {
            ResponsePessoa responsePessoa = getResponsePessoa(p);
            return responsePessoa;
        }).collect(Collectors.toList());
    }

    public ResponsePessoa consultarPeloCodigo(Long codigo) {

        if(!exist(codigo)){
            throw new ObjectNotFoundException("Pessoa com esse codigo não existe: " + codigo);
        }

        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(codigo);
        return getResponsePessoa(pessoaOptional.get());

    }

    private boolean exist(Long codigo) {
        return pessoaRepository.existsById(codigo);
    }

    private ResponsePessoa getResponsePessoa(Pessoa p) {
        ResponsePessoa responsePessoa = new ResponsePessoa();
        BeanUtils.copyProperties(p, responsePessoa);
        return responsePessoa;
    }

    private Pessoa getResponsePessoa(RequestPostPessoa body) {
        Pessoa p = new Pessoa();
        BeanUtils.copyProperties(body, p);
        return p;
    }
}

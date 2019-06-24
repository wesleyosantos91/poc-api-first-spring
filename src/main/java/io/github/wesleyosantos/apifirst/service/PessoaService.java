package io.github.wesleyosantos.apifirst.service;

import io.github.wesleyosantos.apifirst.enumeration.ErroEnum;
import io.github.wesleyosantos.apifirst.exception.core.ObjectNotFoundException;
import io.github.wesleyosantos.apifirst.mapper.PessoaMapper;
import io.github.wesleyosantos.apifirst.model.Pessoa;
import io.github.wesleyosantos.apifirst.repository.PessoaRepository;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final PessoaMapper pessoaMapper;

    @Transactional
    public ResponsePessoa alterarPessoa(Long codigo, RequestPutPessoa body) {

        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(codigo);

        if (!pessoaOptional.isPresent()) {
            throw new ObjectNotFoundException(ErroEnum.PESSOA_COM_ESSE_CODIGO_NÃO_EXISTE.getDetalhe() + codigo);
        }

        BeanUtils.copyProperties(body, pessoaOptional.get(), "codigo");

        return pessoaMapper.toResponsePessoa(pessoaRepository.save(pessoaOptional.get()));
    }


    @Transactional
    public ResponsePessoa cadastrarPessoa(RequestPostPessoa body) {

        Pessoa pessoa = this.pessoaRepository.save(pessoaMapper.toPessoa(body));

        return pessoaMapper.toResponsePessoa(pessoa);
    }


    public List<ResponsePessoa> consultarTodos() {

        return this.pessoaRepository.findAll().stream().map(pessoaMapper::toResponsePessoa).collect(Collectors.toList());
    }

    public ResponsePessoa consultarPeloCodigo(Long codigo) {

        if (!exist(codigo)) {
            throw new ObjectNotFoundException(ErroEnum.PESSOA_COM_ESSE_CODIGO_NÃO_EXISTE.getDetalhe() + codigo);
        }

        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(codigo);

        return pessoaMapper.toResponsePessoa(pessoaOptional.orElseThrow(() -> new ObjectNotFoundException(ErroEnum.PESSOA_COM_ESSE_CODIGO_NÃO_EXISTE.getDetalhe() + codigo)));

    }

    public void excluirPessoa(Long codigo) {
        this.pessoaRepository.deleteById(codigo);
    }

    private boolean exist(Long codigo) {
        return pessoaRepository.existsById(codigo);
    }

}

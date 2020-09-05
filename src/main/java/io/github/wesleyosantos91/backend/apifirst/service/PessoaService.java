package io.github.wesleyosantos91.backend.apifirst.service;

import io.github.wesleyosantos91.backend.apifirst.enumeration.ErroEnum;
import io.github.wesleyosantos91.backend.apifirst.repository.PessoaRepository;
import io.github.wesleyosantos91.backend.apifirst.exception.core.ObjectNotFoundException;
import io.github.wesleyosantos91.backend.apifirst.mapper.PessoaMapper;
import io.github.wesleyosantos91.backend.apifirst.model.Pessoa;
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

        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(codigo);

        if (!pessoaOptional.isPresent()) {
            throw new ObjectNotFoundException(ErroEnum.PESSOA_COM_ESSE_CODIGO_NAO_EXISTE.getDetalhe() + codigo);
        }

        BeanUtils.copyProperties(body, pessoaOptional.get(), "codigo");

        return pessoaMapper.toResponsePessoa(pessoaRepository.save(pessoaOptional.get()));
    }


    @Transactional
    public ResponsePessoa cadastrarPessoa(RequestPostPessoa body) {

        Pessoa pessoa = pessoaRepository.save(pessoaMapper.toPessoa(body));

        return pessoaMapper.toResponsePessoa(pessoa);
    }


    public List<ResponsePessoa> consultarTodos() {

        return pessoaRepository.findAll().stream().map(pessoaMapper::toResponsePessoa).collect(Collectors.toList());
    }

    public ResponsePessoa consultarPeloCodigo(Long codigo) {

        if (!exist(codigo)) {
            throw new ObjectNotFoundException(ErroEnum.PESSOA_COM_ESSE_CODIGO_NAO_EXISTE.getDetalhe() + codigo);
        }

        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(codigo);

        return pessoaMapper.toResponsePessoa(pessoaOptional.orElseThrow(() -> new ObjectNotFoundException(ErroEnum.PESSOA_COM_ESSE_CODIGO_NAO_EXISTE.getDetalhe() + codigo)));

    }

    public void excluirPessoa(Long codigo) {
        pessoaRepository.deleteById(codigo);
    }

    private boolean exist(Long codigo) {
        return pessoaRepository.existsById(codigo);
    }

}

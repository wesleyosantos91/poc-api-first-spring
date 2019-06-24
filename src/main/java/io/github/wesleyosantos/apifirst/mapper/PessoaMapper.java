package io.github.wesleyosantos.apifirst.mapper;

import io.github.wesleyosantos.apifirst.model.Pessoa;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    RequestPutPessoa toRequestPutPessoa(Pessoa pessoa);

    RequestPostPessoa toRequestPostPessoa(Pessoa pessoa);

    ResponsePessoa toResponsePessoa(Pessoa pessoa);

    Pessoa toPessoa(RequestPutPessoa requestPutPessoa);

    Pessoa toPessoa(RequestPostPessoa requestPostPessoa);
}

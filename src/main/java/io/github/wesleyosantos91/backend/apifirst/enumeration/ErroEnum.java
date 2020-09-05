package io.github.wesleyosantos91.backend.apifirst.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by wesleyosantos91 on 2019-06-24.
 */
@Getter
@AllArgsConstructor
public enum ErroEnum {

    PESSOA_COM_ESSE_CODIGO_NAO_EXISTE("Pessoa com esse codigo não existe: ");

    private String detalhe;
}

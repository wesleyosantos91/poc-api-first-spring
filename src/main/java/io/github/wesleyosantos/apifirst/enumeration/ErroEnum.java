package io.github.wesleyosantos.apifirst.enumeration;

/**
 * Created by wesleyosantos91 on 2019-06-24.
 */
public enum ErroEnum {

    PESSOA_COM_ESSE_CODIGO_NÃO_EXISTE("Pessoa com esse codigo não existe: ");

    private String detalhe;

    ErroEnum(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getDetalhe() {
        return detalhe;
    }
}

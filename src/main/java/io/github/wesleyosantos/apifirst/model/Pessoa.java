package io.github.wesleyosantos.apifirst.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by wesleyosantos91 on 2019-06-03.
 */
@Getter
@Setter
public class Pessoa {

    private Long codigo;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email ;
}

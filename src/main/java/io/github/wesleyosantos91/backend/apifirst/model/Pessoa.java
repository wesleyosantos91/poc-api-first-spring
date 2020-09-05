package io.github.wesleyosantos91.backend.apifirst.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by wesleyosantos91 on 2019-06-03.
 */
@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;
}

package io.github.wesleyosantos91.backend.apifirst.repository;

import io.github.wesleyosantos91.backend.apifirst.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wesleyosantos91 on 2019-06-22.
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

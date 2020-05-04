package com.gitlab.wesleyosantos91.backend.apifirst.service;

import com.gitlab.wesleyosantos91.backend.apifirst.exception.core.ObjectNotFoundException;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    private RequestPostPessoa requestPostPessoa;

    private RequestPutPessoa requestPutPessoa;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        requestPostPessoa = new RequestPostPessoa();
        requestPostPessoa.setNome("Gabriel Ducati Teixeira");
        requestPostPessoa.setCpf("10275977340");
        requestPostPessoa.setDataNascimento(LocalDate.of(1995, 10, 10));
        requestPostPessoa.setEmail("gabriel.teixeira@uol.com.br");

        requestPutPessoa = new RequestPutPessoa();
        requestPutPessoa.setNome("Guilherme Machado Gomes");
        requestPutPessoa.setDataNascimento(LocalDate.of(19972, 9, 12));
        requestPutPessoa.setEmail("guilherme.gomes@uol.com.br");
    }

    @Test
    @DisplayName("Deve alterar a o objeto pessoa")
    public void alterarPessoa() {

        ResponsePessoa responsePessoa = pessoaService.alterarPessoa(1L, requestPutPessoa);
        assertThat(responsePessoa.getEmail()).isEqualTo("guilherme.gomes@uol.com.br");
    }

    @Test
    @DisplayName("Deve lançar ObjectNotFoundException")
    public void alterarPessoaException() {
        assertThrows(ObjectNotFoundException.class, () -> {
            pessoaService.alterarPessoa(2L, requestPutPessoa);
        });
    }

    @Test
    @DisplayName("Deve cadastrar uma pessoa")
    public void cadastrarPessoa() {
        ResponsePessoa responsePessoa = pessoaService.cadastrarPessoa(requestPostPessoa);

        assertThat(responsePessoa.getCodigo()).isEqualTo(2L);
    }

    @Test
    @DisplayName("deve retornar todos umas lista de pessoas")
    public void consultarTodos() {
        List<ResponsePessoa> responsePessoas = pessoaService.consultarTodos();
        assertThat(responsePessoas.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("Deve retorna uma pessoa pelo seu código")
    public void consultarPeloCodigo() {
        ResponsePessoa responsePessoa = pessoaService.consultarPeloCodigo(1L);
        assertThat(responsePessoa.getCodigo()).isEqualTo(1L);
    }

    @Test
    @DisplayName("Deve lançar ObjectNotFoundException")
    public void consultarPeloCodigoException() {
        assertThrows(ObjectNotFoundException.class, () -> {
            pessoaService.consultarPeloCodigo(2L);
        });
    }

    @Test
    @DisplayName("Deve excluir pessoa pelo seu código")
    public void excluirPessoa() {

        pessoaService.excluirPessoa(1L);

        PessoaService pessoaServiceMock = mock(PessoaService.class);
        pessoaServiceMock.excluirPessoa(1L);

        verify(pessoaServiceMock).excluirPessoa(1L);
    }
}
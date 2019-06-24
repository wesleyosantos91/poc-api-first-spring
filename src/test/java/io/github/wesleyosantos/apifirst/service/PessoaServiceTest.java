package io.github.wesleyosantos.apifirst.service;

import io.github.wesleyosantos.apifirst.exception.core.ObjectNotFoundException;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import io.swagger.model.ResponsePessoa;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    private RequestPostPessoa requestPostPessoa;

    private RequestPutPessoa requestPutPessoa;

    @Before
    public void setUp() {
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
    public void alterarPessoa() {

        ResponsePessoa responsePessoa = this.pessoaService.alterarPessoa(1L, requestPutPessoa);
        assertThat(responsePessoa.getEmail()).isEqualTo("guilherme.gomes@uol.com.br");
    }

    @Test(expected = ObjectNotFoundException.class)
    public void alterarPessoaException() {
        ResponsePessoa responsePessoa = this.pessoaService.alterarPessoa(2L, requestPutPessoa);
    }

    @Test
    public void cadastrarPessoa() {
        ResponsePessoa responsePessoa = this.pessoaService.cadastrarPessoa(requestPostPessoa);

        assertThat(responsePessoa.getCodigo()).isEqualTo(2L);
    }

    @Test
    public void consultarTodos() {
        List<ResponsePessoa> responsePessoas = this.pessoaService.consultarTodos();
        assertThat(responsePessoas.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void consultarPeloCodigo() {
        ResponsePessoa responsePessoa = this.pessoaService.consultarPeloCodigo(1L);
        assertThat(responsePessoa.getCodigo()).isEqualTo(1L);
    }

    @Test(expected = ObjectNotFoundException.class)
    public void consultarPeloCodigoException() {
        this.pessoaService.consultarPeloCodigo(2L);
    }

    @Test
    public void excluirPessoa() {
        this.pessoaService.excluirPessoa(1L);
    }
}
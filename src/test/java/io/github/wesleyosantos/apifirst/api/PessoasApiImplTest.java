package io.github.wesleyosantos.apifirst.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.swagger.model.RequestPostPessoa;
import io.swagger.model.RequestPutPessoa;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;


@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class PessoasApiImplTest {

    @LocalServerPort
    private int porta;

    private RequestPostPessoa requestPostPessoa;

    private RequestPutPessoa requestPutPessoa;


    @Before
    public void setUp() throws Exception {
        RestAssured.port = porta;

        requestPostPessoa = new RequestPostPessoa();
        requestPostPessoa.setNome("Gabriel Ducati Teixeira");
        requestPostPessoa.setCpf("10275977340");
        requestPostPessoa.setDataNascimento(LocalDate.of(1995, 10, 10));
        requestPostPessoa.setEmail("gabriel.teixeira@uol.com.br");

        requestPutPessoa = new RequestPutPessoa();
        requestPutPessoa.setNome("Guilherme Machado Gomes");
        requestPutPessoa.setDataNascimento(LocalDate.of(1972, 9, 12));
        requestPutPessoa.setEmail("guilherme.gomes@uol.com.br");
    }

    @Test
    public void alterarPessoa() {

        given()
                .pathParam("codigo", 1L)
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(requestPutPessoa)
                .when()
                .put("/pessoas/{codigo}")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.OK.value())
                .body("codigo", equalTo(1),
                        "nome", equalTo("Guilherme Machado Gomes"),
                        "data_nascimento", equalTo("1972-09-12"),
                        "cpf", equalTo("56844030932"),
                        "email", equalTo("guilherme.gomes@uol.com.br"));
    }

    @Test
    public void cadastrarPessoa() {

        given()
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(requestPostPessoa)
                .when()
                .post("/pessoas")
                .then()
                .log().headers()
                .and()
                .log().body()
                .and()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", equalTo("http://localhost:" + porta + "/pessoas/2"))
                .body("codigo", equalTo(2),
                        "nome", equalTo("Gabriel Ducati Teixeira"),
                        "data_nascimento", equalTo("1995-10-10"),
                        "cpf", equalTo("10275977340"),
                        "email", equalTo("gabriel.teixeira@uol.com.br"));
    }

    @Test
    public void consultarPeloCodigo() {
        given()
                .pathParam("codigo", 1L)
                .get("/pessoas/{codigo}")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.OK.value())
                .body("codigo", equalTo(1),
                        "nome", equalTo("Guilherme Machado Gomes"),
                        "data_nascimento", equalTo("1972-09-12"),
                        "cpf", equalTo("56844030932"),
                        "email", equalTo("guilherme.gomes@hotmail.com"));

    }

    @Test
    public void consultarPeloCodigoException() {
        given()
                .pathParam("codigo", 2L)
                .get("/pessoas/{codigo}")
                .then()
                .log().body()
                .and()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void consultarTodos() {
        given()
                .get("/pessoas")
                .then()
                .log().body().and()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(1));
    }

    @Test
    public void excluirPessoa() {
        given()
                .pathParam("codigo", 1L)
                .request()
                .header("Accept", ContentType.ANY)
                .header("Content-type", ContentType.JSON)
                .body(requestPostPessoa)
                .when()
                .delete("/pessoas/{codigo}")
                .then()
                .log().status()
                .and()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }
}
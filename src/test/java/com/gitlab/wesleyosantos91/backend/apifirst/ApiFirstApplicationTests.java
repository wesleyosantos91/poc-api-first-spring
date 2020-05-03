package com.gitlab.wesleyosantos91.backend.apifirst;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ApiFirstApplicationTests {

    @Value("${variavel.teste}")
    private String value;

    @Test
    @DisplayName("Teste para verificar a variável de ambiente")
    public void contextLoads() {
        assertEquals("springboot-test", value);
    }

    @Test
    @DisplayName("Teste do start da aplicação")
    public void ApiFirstApplicatioMain() {
        ApiFirstApplication.main(new String[]{});
    }

}

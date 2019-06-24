package io.github.wesleyosantos.apifirst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ApiFirstApplicationTests {

    @Value("${variavel.teste}")
    private String value;

    @Test
    public void contextLoads() {
        assertEquals("springboot-test", value);
    }

    @Test
    public void ApiFirstApplicatioMain() {
        ApiFirstApplication.main(new String[]{});
    }

}

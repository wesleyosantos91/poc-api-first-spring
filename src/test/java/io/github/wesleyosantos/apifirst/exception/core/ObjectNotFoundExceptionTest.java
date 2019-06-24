package io.github.wesleyosantos.apifirst.exception.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ObjectNotFoundExceptionTest {

    @Test(expected = ObjectNotFoundException.class)
    public void contextLoads() {
        throw new ObjectNotFoundException("Teste Exception", new Exception());
    }

}
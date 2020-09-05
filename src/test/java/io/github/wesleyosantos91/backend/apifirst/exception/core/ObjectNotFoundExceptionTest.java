package io.github.wesleyosantos91.backend.apifirst.exception.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
class ObjectNotFoundExceptionTest {

    @Test
    @DisplayName("Deve lançar ObjectNotFoundException")
    void contextLoads() {

        assertThrows(ObjectNotFoundException.class, () -> {
            throw new ObjectNotFoundException("Teste Exception", new Exception());
        });


    }

}
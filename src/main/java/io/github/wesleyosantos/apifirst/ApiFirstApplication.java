package io.github.wesleyosantos.apifirst;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiFirstApplication {

    @Value(value = "${minha.idade}")
    private Long idade;

    public static void main(String[] args) {
        SpringApplication.run(ApiFirstApplication.class, args);
    }

    @Bean
    public CommandLineRunner run()  {
        return args -> {
            System.out.println("Minha idade é: " + idade);
        };
    }

}

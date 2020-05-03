# POC - API FIRST

## Prova de conceito - API FIRST

> API first significa que a Application Programming Interface  é uma estratégia na qual a primeira ordem dos negócios é desenvolver uma API que coloque os interesses do desenvolvedor de destino em primeiro lugar e depois construa o produto sobre ele (seja um site, aplicativo móvel ou software SaaS). Ao desenvolver APIs com os desenvolvedores em mente, você e seus desenvolvedores estão economizando muito trabalho enquanto estabelecem as bases para que outros possam desenvolver.

# Tecnologias
- Java 8
- Spring Boot 2.2.6.RELEASE
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
    - spring-boot-devtools
- Flywaydb
- Lombok
- H2
- Mysql
- Swagger
    - swagger-annotations
    - springfox-swagger2
    - springfox-swagger-ui
- Mapstruct jdk8
- Junit 5
- Mockito
- Rest Assured
- Tomcat (Embedded no Spring Boot)
- Git (GitLab)

# Execução

A execução das aplicações são feitas através do de um comando Maven que envoca a inicialização do Spring Boot.

- Scripts
    - ```./mvnw clean spring-boot:run```
    
# Utilização

http://localhost:8080/swagger-ui.html
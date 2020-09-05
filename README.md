# POC - API FIRST

## Prova de conceito - API FIRST

> API first significa que a Application Programming Interface  é uma estratégia na qual a primeira ordem dos negócios é desenvolver uma API que coloque os interesses do desenvolvedor de destino em primeiro lugar e depois construa o produto sobre ele (seja um site, aplicativo móvel ou software SaaS). Ao desenvolver APIs com os desenvolvedores em mente, você e seus desenvolvedores estão economizando muito trabalho enquanto estabelecem as bases para que outros possam desenvolver.

# Integração contínua
[![Build Status](https://travis-ci.com/wesleyosantos91/poc-api-first.svg?branch=master)](https://travis-ci.com/wesleyosantos91/poc-api-first)

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=wesleyosantos91_poc-api-first)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=security_rating)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)

[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)

[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=bugs)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=code_smells)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=sqale_index)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=wesleyosantos91_poc-api-first&metric=ncloc)](https://sonarcloud.io/dashboard?id=wesleyosantos91_poc-api-first)

# License
![GitHub](https://img.shields.io/github/license/wesleyosantos91/poc-api-first)

# Tecnologias
- Java 11
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
    ### Executar docker-compose
    - 1° comando: ``` cd src/main/docker/``` 
    - 2° comando: ```docker-compose -f docker-compose.yml up``` 
    ### Executar a aplicação
    -  ```./mvnw clean compile spring-boot:run```
    ### Executar testes
    -  ```./mvnw clean compile verify sonar:sonar```
    
# Utilização

## Swagger
http://localhost:8080/swagger-ui.html

## Sonar
http://localhost:9000/



# POC - API FIRST

## Prova de conceito - API FIRST

> API first significa que a Application Programming Interface  é uma estratégia na qual a primeira ordem dos negócios é desenvolver uma API que coloque os interesses do desenvolvedor de destino em primeiro lugar e depois construa o produto sobre ele (seja um site, aplicativo móvel ou software SaaS). Ao desenvolver APIs com os desenvolvedores em mente, você e seus desenvolvedores estão economizando muito trabalho enquanto estabelecem as bases para que outros possam desenvolver.

# Qualidade

[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=alert_status)](https://sonarcloud.io/dashboard?id=pocs8_poc-api-first)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=coverage)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=coverage&view=list)

[![SQALE_RATING](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=sqale_rating&template=FLAT)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=sqale_rating&view=list)
[![SECURITY_RATING](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=security_rating&template=FLAT)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=security_rating)
[![RELIABILITY_RATING](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=reliability_rating&template=FLAT)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=reliability_rating)

[![DUPLICATED_LINE](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=duplicated_lines_density&template=FLAT)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=duplicated_lines&view=list)

[![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=vulnerabilities)](https://sonarcloud.io/project/issues?id=pocs8_poc-api-first&resolved=false&types=VULNERABILITY)

[![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=bugs)](https://sonarcloud.io/project/issues?id=pocs8_poc-api-first&resolved=false&types=BUG)
[![CODE_SMELLS](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=code_smells&template=FLAT)](https://sonarcloud.io/project/issues?id=pocs8_poc-api-first&resolved=false&types=CODE_SMELL)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=sqale_index&template=FLAT)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=sqale_index&view=list)

[![LINES_OF_CODE](https://sonarcloud.io/api/project_badges/measure?project=pocs8_poc-api-first&metric=ncloc&template=FLAT)](https://sonarcloud.io/component_measures?id=pocs8_poc-api-first&metric=ncloc)
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



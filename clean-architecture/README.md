
# Clean Architecture: Um Projeto de Estudo com Estruturação em Camadas e Independência de Dependências 🍃

##### Neste projeto de estudo, explorei a Clean Architecture (Arquitetura Limpa), adotando uma estrutura em camadas e respeitando rigorosamente as regras de dependência. A base dessa arquitetura é a camada de domínio (domain), que concentra todas as regras de negócio e validações. Para acessá-las em outros contextos, utilizei interfaces adaptadoras (application interfaces). Também implementei DTOs, serviços e adaptadores na camada de infraestrutura de dados (infra.data), que convertem as entidades de domínio em entidades do JPA para interagir com o banco de dados. 

##### As interfaces dos repositórios foram definidas na camada de repositorys, garantindo a abstração do acesso aos dados. Na camada de infraestrutura de IoC (Inversion of Control), concentrei toda a configuração do projeto, incluindo aspectos de segurança. Por fim, a camada de API abriga os controllers e o exception handler, permitindo a interação com o sistema.

##### Este projeto apresenta uma estrutura organizada e modular, promovendo a separação de preocupações e facilitando a manutenção e evolução do código. Ao seguir as diretrizes da Clean Architecture, você terá um projeto robusto e altamente adaptável às mudanças futuras.

#### Versões usadas no projeto
###### - java : 11
###### - Spring Boot : 2.7.4 🍃

===========================================================================

### Para rodar o projeto localmente, faça o seguinte:

#### Certifique-se de ter os seguintes pré-requisitos instalados:

* JDK 11 [Dowload JDK](https://www.oracle.com/java/technologies/downloads/#java11)
* Clone o repositório do projeto:
* Clone HTTPS: https://github.com/brunoonofre64/dslist.git
* Abra o projeto em sua IDE favorita (por exemplo, IntelliJ IDEA, Eclipse)
* Certifique-se de que o JDK 11 esteja configurado como o JDK do projeto

#### Executando o projeto
* No diretório raiz do projeto, compile e construa o projeto usando o seguinte comando:

*****./mvnw clean install*****

* Após a conclusão bem-sucedida do comando acima, você pode executar o projeto usando o seguinte comando:

*****./mvnw spring-boot:run*****

* Isso iniciará o projeto Spring Boot e ele estará acessível localmente.

*****http://localhost:8080*****

* O projeto está configurado para usar o banco de dados H2 incorporado. Durante a execução, você pode acessar o console do H2 para visualizar e gerenciar o banco de dados.

URL do Console do H2: *****http://localhost:8080/h2-console*****


===========================================================================

### Camada domain

##### Isenta de depdências!

### Camada de application

DEPENDÊNCIAS  | REFERÊNCIA
------------ | ---------------
SPRING BOOT STARTER PARENT | [STARTER PARENT](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent)
SPRING BOOT STARTER | [SPRING BOOT STARTER](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter)
CAMADA DE DOMAIN | [DOMAIN](URL DOMAIN)

### Camada de infra.data

DEPENDÊNCIAS  | REFERÊNCIA
------------ | ---------------
SPRING BOOT STARTER PARENT | [STARTER PARENT](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent)
SPRING DATA JPA | [JPA](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa)
H2 DATABASE | [H2](https://mvnrepository.com/artifact/com.h2database/h2)
FLYWAY CORE | [FLYWAY CORE](https://mvnrepository.com/artifact/org.flywaydb/flyway-core)
FLYWAY MYSQL | [FLYWAY MYSQL](https://mvnrepository.com/artifact/org.flywaydb/flyway-mysql)
MYSQL | [MYSQL](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
CAMADA DE DOMAIN | [DOMAIN](URL DOMAIN)
CAMADA DE APP | [APP](URL APP)

### Camada de infra.ioc

DEPENDÊNCIAS  | REFERÊNCIA
------------ | ---------------
SPRING BOOT STARTER PARENT | [STARTER PARENT](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent)
SPRING FOX BOOT STARTER | [SPRING FOX](https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter)
SWAGGER UI | [SWAGGER UI](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui)
SPRING WEB | [SPRING WEB](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
SPRING SECURITY| [SPRING SECURITY](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
JAVA JWT | [JAVA JWT](https://mvnrepository.com/artifact/com.auth0/java-jwt)
CAMADA DE DOMAIN | [DOMAIN](URL DOMAIN)
CAMADA DE APP | [APP](URL APP)
CAMADA DE INFRA.DATA | [INFRA.DATA](URL INFRA.DATA)

### Camada de api

DEPENDÊNCIAS  | REFERÊNCIA
------------ | ---------------
SPRING BOOT STARTER PARENT | [STARTER PARENT](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent)
SPRING WEB | [SPRING WEB](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
SPRING DEV TOOLS | [SPRING DEV TOOLS](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
CAMADA DE INFRA.IOC | [INFRA.DATA](URL INFRA.IOC)

===========================================================================

##### Voce também pode acessar o diagrama de classes abaixo clicando aqui [MERMAID_CLASS_DIAGRAM](https://mermaid.live/view#pako:eNrlWW1v2zYQ_iuC9iVd48BJ8yoEBuw4ad3mxbAdDB0MBIzEOFplUqOkpG6X_7476o2kaNnbpwFLAEcin-d4d7w7Hp2frs8D6nquH5EkGYZkIchyzhz4CUJB_TTkzLme5CP5p0Q6H8mSXrI0TFfOz3wcfzpOGHjONBUhW6ijgIuobSLxuYCJIc8eI6pOrCgRnjNiKV1QoU4sKBNWUXFE0iculoltMlwu7kVk1eCZi3RIE1-EMVprw0ScLdZC3ubMdMx1mKTbO4cBo1XkgKICMDv-ostbSGa9FeYc6uEZGrWvYNP6sV7eU3XRnM-TMHeNtmXGMhMelUHjbOMZAfjbTd65T6jY3tl0SUJrHMQg65WLtXpAWKETz2sbelZ1Zo8PGWj0IDmmRnK0XMFzrr4Y08hsTssV8LeOsOHsDmXrVjbyrJFfjbxq5JM1j5r505Y3LfnypluBDl1jyZqkqLk3IdvWCQ2b_4k1hvMx2qp1jWCqoCX4c0wmVKYGFzI6z89D0EI8EZ_2IHzGsCuh7yxp-syDxEm5E8Mk-N4hzsXkfthwWKu0904ChvrPgxX6dSeCj1HlmHdF-BauGwv-R17dJfEpZMFgNQp2QpWgFhbLzrUqo-CrkrEtAX28wdJc4Uv0_462C6D2ndxBEp3XlUFy6HdQOlnHeuSQmoRpimCub1CkFDopStWOWbNU0bWjR0wCcX_ktuTY3jtbkWkGfr17Vp0WFDZ-513xOMN0qN6-QohULyOZB9Xr1EgCnDAWn1LxEvoUl82N6UfA12ML0mNDUAFC4efxCrjWiM2lWsJwo0pFlelpxbSONI0fcRLg4GCFn1iEGoEiKwBNYTCROUde6E4mI_bPjMqVvCKCy_eSlFudxQFJDbG7Dkq4lzOVgOpV5wc0ok1-eXxJ9rh-Ae4LDwObbwqZPaxkLyQKcbUBhfJD69V32vTKtS7O3jrZqiWNTNIcLd0mZH7Vbpto77ocddsvOEuBG1HxXwrEbbTaEIumiP9nOBpxYzrlX4fOpRAc_JDEnCW0OMFxSG8eliCCLGPQivskGoLNMxjDOQfvStOUpBn0RlBz5RjAE7IwepVGx3IBzJscmZdsyrIlFUSewGDy5c149vXhejSdzdnH_s3lw-3d7OHq7v4WeoBfMDszau2iLr_7VNbqT4QFhYfyxyS3DbqKZ8FfmfO4gifq9McjUB36C-g0Ejwlwx80cF6JfsRPMoaOqKSj2CsuHJGPF6I1CmxlfxxWDNn6wphD4hAOyXJUowwTTLR-HEMTJD0hPaO858cZRJZ5FBWuHGRoKcTHU7jI3Zo_Z0KhV4vDzvNM-AWrEDGVQxiEE4rZRh4xjtYCPU2N6StZLGTWtikAHkD5Q-5_ozJmYGDEnjgO9vNHTepv9LFVYgfiUCR3IoSeSmnS38vhEk0FigdRNy9-PVaso1zeO52_enqf6kFQpZQFSY5T-h-JrbnQUi_jiC4pS5NSqnLz3SjZ6CEr6bUMcwXzmtq6hK3tlARDirmIcp9slW90qRJbc02pytW3VarRckpszbW53OZCrUfE0E4zwSpGeRBXcFWTEUNavUMNsL5tNUHtpSpn2IBqL1DZZwPmSijlv9KhoDe1tYEVK3RtTbBiga6tCVQsMLWtDSsbDMX9FkDeUBgY3e_qVVkB6v4uj2Rtsy0OXKOVgtmoWYVt102D2bVTK9Hc3Z-7nc7c7e7t_Tp3B-qXTp9IYpYXCXfa8EaaV_L3beA6cQ09tK9zCnCdj1uA4Ww3z-hOp2e0sYiVh3YLWg9vhQEcrbFBginFcwZZGAWyBUhSkfmwCxSpjWMb2ebxr9QnC-Mc9re5nqreMk5la133E7iK0hMZUXbL0ysOh-82-DlrtBFOnfuqw_AZWomknWG6uWbhr63xQN0aEvGbUrzy6y1CK7Q-99slUj8TEHsFFr0PTH0Uz_p-QOIULaj2zmC2rjK4EKs43Qb5-TW9T8NoHeiCLyEsKXbLF1mS8mU_gyCE-MoBV2GUVu45LyoFXnTKS4MNrti0USaqpRsury8BNMQqm4vwh12hO-bTcXV_alHALqJ1_Tlzd124B0CLG7ieK78tnrtgC1w4XA8eAyK-zV1o2wBHspRPV8x3PUhguuvmN7fifzblYEyY6_10v7te5-hg76zbPTk9ODk77B4eHR7vuivXO_qwd3zaPTw7-HB8sN_tdk_fdt0fnIOA_b3uydnJyfHB6QmwTo9ODqW43-VkLp0GeETfFP8ywj9vfwNnwj3Q)


````mermaid
---
title: REGRA DE DEPENDENCIA
---

graph LR

subgraph Domain
    D(Domain)
end

subgraph Application
    A(Application)
    A -->|Depende de Domain| D
end

subgraph InfrastructureData
    ID(Infra.Data)
    ID -->|Depende de Domain| D
end

subgraph InfrastructureIoC
    II(Infra.IoC)
    II -->|Depende de Domain| D
    II -->|Depende de Application| A
    II -->|Depende de InfrastructureData| ID
end

subgraph API
    API(API)
    API -->|Depende de Infra.IoC| II
end



````

===========================================================================


===========================================================================

### Contratos e endpoints para consumo da API localmente ou de produção usando interface do swagger - OpenAPI.

* *****LOCAL*****
* *****http://localhost:8080/swagger-ui/index.html*****

#### A API está protegida por autenticação e autorização via JWT, que tenha autorização de realizar operações de entrada de dados, é necessário que usando o postman, você no endpoint ***/login*** envie um método POST, onde selecionando o ***Body*** e a opção ***x-www-form-urlencoded*** você insira ***email*** e ***senha*** de acesso, como mostra o exemplo abaixo:


Key  | Value
------------ | ---------------
username | guest
password | guest

#### Agora use o ***access_token*** gerado para acessar via ***Bearer*** ***Token.***



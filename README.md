<h1 align="center">People Rest API</h1>

<p align="center">REST API para cadastro de pessoas</p>

Acesse a API rodando no Heroku [aqui](https://luizsac-people-api.herokuapp.com/api/v1/people).

- [Tecnologias](#tecnologias)
- [Como usar](#como-usar)
  - [Pré-requisitos](#pré-requisitos)
  - [Como executar](#como-executar)
- [Funcionalidades](#funcionalidades)
  - [Cadastrar pessoa](#cadastrar-pessoa)
  - [Recuperar lista de pessoas](#recuperar-lista-de-pessoas)
  - [Recuperar pessoa pelo id](#recuperar-pessoa-pelo-id)
  - [Atualizar pessoa](#atualizar-pessoa)
  - [Deletar pessoa](#deletar-pessoa)
- [Licença](#licença)
- [Autor](#autor)

## Sobre
Esta é uma API construída para o projeto "Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring
Boot" da plataforma DIO. É uma aplicação Spring Boot que utiliza os módulos Web, Data JPA e Validation. Lombok foi
incluído para a geração de código boilerplate e Mapstruct, para conversão entre models e DTOs. A versão local da
aplicação usa o H2 como banco em memória e a versão do Heroku tem o PostgreSQL como banco de dados. Swagger foi
utilizado para documentar a aplicação e os testes unitários foram implementados com a bibioteca de testes do Spring Boot.
  
## Tecnologias
- [Java](https://openjdk.java.net/)
- [Spring Boot](https://spring.io/) (Web, Data JPA, Validation, Test)
- [Gradle](https://gradle.org/)
- [Swagger](https://swagger.io/)
- [Mapstruct](https://mapstruct.org/)
- [Project Lombok](https://projectlombok.org/)
- [H2](https://www.h2database.com/html/main.html)
- [PostgreSQL](https://www.postgresql.org/) (no Heroku)

## Como usar
### Pré requisitos
- [Git](https://git-scm.com/downloads)
- [Java Runtime Environment](https://www.java.com/pt-BR/download/)

### Como executar

Clone o repositório: `git clone https://github.com/luizsac/people-rest-api.git`

Entre na pasta do projeto: `cd people-rest-api`

Execute a aplicação: `.\gradlew bootRun` no Windows ou `./gradlew bootRun` no Linux/Mac

## Funcionalidades
### Cadastrar pessoa
#### Request
`POST /api/v1/people`

<pre>
{
  "firstName": "Foo",
  "lastName": "Bar",
  "cpf": "78946699035",
  "birthDate": "13-12-1912",  
  "phones": [
    {
      "number": "5587864567786",
      "type": "COMMERCIAL"
    }
  ]
}
</pre>

Obs.: O CPF deve ser válido. Acesse um gerador clicando [aqui](https://www.4devs.com.br/gerador_de_cpf).

### Response
    HTTP/1.1 201 Created
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 201 Created
    Content-Type: application/json

<pre>
{
    "id": 1,
    "firstName": "Foo",
    "lastName": "Bar",
    "cpf": "78946699035",
    "birthDate": "1912-12-13",
    "phones": [
        {
            "id": 1,
            "type": "COMMERCIAL",
            "number": "5587864567786"
        }
    ]
}
</pre>


## Recuperar lista de pessoas
### Request
`GET /api/v1/people`

### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
[
    {
        "id": 1,
        "firstName": "Bar",
        "lastName": "Foo",
        "cpf": "02788745095",
        "birthDate": "1987-04-23",
        "phones": [
            {
                "id": 1,
                "type": "MOBILE",
                "number": "5548997685748"
            }
        ]
    },
    {
        "id": 2,
        "firstName": "Foo",
        "lastName": "Bar",
        "cpf": "78946699035",
        "birthDate": "1912-12-13",
        "phones": [
            {
                "id": 2,
                "type": "COMMERCIAL",
                "number": "5587864567786"
            }
        ]
    }
]
</pre>

## Recuperar pessoa pelo id
### Request
`GET /api/v1/people/id`

### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
    {
        "id": 2,
        "firstName": "Foo",
        "lastName": "Bar",
        "cpf": "78946699035",
        "birthDate": "1912-12-13",
        "phones": [
            {
                "id": 2,
                "type": "COMMERCIAL",
                "number": "5587864567786"
            }
        ]
    }
</pre>

## Atualizar pessoa
### Request
`PUT /api/v1/people/id`

<pre>
{
  "firstName": "Foo",
  "lastName": "Bar",
  "cpf": "78946699035",
  "birthDate": "30-04-1945",  
  "phones": [
    {
      "number": "5543934328786",
      "type": "COMMERCIAL"
    }
  ]
}
</pre>

### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
{
    "id": 2,
    "firstName": "Foo",
    "lastName": "Bar",
    "cpf": "78946699035",
    "birthDate": "1945-04-30",
    "phones": [
        {
            "id": 3,
            "type": "COMMERCIAL",
            "number": "5543934328786"
        }
    ]
}
</pre>

## Deletar pessoa
### Request
`DELETE /api/v1/people/id`

### Response
    HTTP/1.1 200 OK
    Date: Mon, 28 Feb 2022 20:50:05 GMT
    Status: 200 OK
    Content-Type: application/json

<pre>
{
    "id": 2,
    "firstName": "Foo",
    "lastName": "Bar",
    "cpf": "78946699035",
    "birthDate": "1945-04-30",
    "phones": [
        {
            "id": 3,
            "type": "COMMERCIAL",
            "number": "5543934328786"
        }
    ]
}
</pre>

## Licença
Essa API está sob a licença MIT. Veja o arquivo [LICENSE](https://github.com/luizsac/people-rest-api/blob/main/LICENSE) para mais informações.

## Autor
[![Linkedin Badge](https://img.shields.io/badge/Luiz_Henrique_Salgado_Andrade_Cardoso-0a66c2?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/luizsac/)](https://www.linkedin.com/in/luizsac/)
[![Linkedin Badge](https://img.shields.io/badge/luizhenriquesalgado@outlook.com.br-0073c6?style=flat-square&logo=Microsoft-Outlook&logoColor=white&link=mailto:luizhenriquesalgado@outlook.com.br)](mailto:luizhenriquesalgado@outlook.com.br)

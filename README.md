<h1 align="center">People Rest API</h1>

<p align="center">REST API para cadastro de pessoas</p>

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
  - [Cadastrar pessoa](#cadastrar-pessoa)
  - [Recuperar lista de pessoas](#recuperar-lista-de-pessoas)
  - [Recuperar pessoa pelo id](#recuperar-pessoa-pelo-id)
  - [Atualizar pessoa](#atualizar-pessoa)
  - [Deletar pessoa](#deletar-pessoa)
  
## Sobre
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
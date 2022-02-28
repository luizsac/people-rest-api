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
## Cadastrar pessoa
### Request
`POST /api/v1/people`

#### Request body
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

#### Response body
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
`POST /thing/`

### Response

## Recuperar pessoa pelo id
### Request
`POST /thing/`

## Atualizar pessoa
### Request
`POST /thing/`

## Deletar pessoa
### Request
`POST /thing/`
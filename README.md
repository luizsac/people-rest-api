<h1 align="center">People Rest API</h1>

<p align="center">REST API para cadastro de pessoas</p>

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
  - [Cadastrar pessoa](#cadastrar-pessoa)
  - [Recuperar lista de pessoas](#recuperar-lista-de-pessoas)
  - [Recuperar pessoa pelo id](#recuperar-pessoa-pelo-id)
  - [Atualizar pessoa](#atualizar-pessoa)
  - [Deletar pessoa](#deletar-pessoa)

<!--#
INDENT=&nbsp;&nbsp;&nbsp;&nbsp;
$-->
  
## Sobre
## Funcionalidades
## Cadastrar pessoa
### Request
`POST /api/v1/people`

{<br>
{{ INDENT }}"firstName": "Foo",<br>
&nbsp;&nbsp;&nbsp;&nbsp;"lastName": "Bar",<br>
&nbsp;&nbsp;&nbsp;&nbsp;"cpf": "78946699035",<br>
&nbsp;&nbsp;&nbsp;&nbsp;"birthDate": "12-12-1972",<br>
&nbsp;&nbsp;&nbsp;&nbsp;"phones": [<br>
    {<br>
      "number": "5565433456568",<br>
      "type": "COMMERCIAL"<br>
    }<br>
  ]<br>
}

### Response


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
# Parte 1 

## Enunciado

Você está avaliando uma API REST que controla veículos de usuários. A API deve ser composta de **pelo menos** 3 endpoints: 

- o cadastro do usuário
- o cadastro de veículo
- a listagem dos veículos para um usuário específico. 

O primeiro serviço é de cadastro de usuários, sendo obrigatórios os dados: nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos. 

O segundo serviço é de cadastro de veículos, sendo obrigatórios os dados: Marca, Modelo do Veículo e Ano. Sendo que o serviço deve consumir a API da FIPE para obter os dados do Valor do Veículo baseado nos dados informados. Link para API da FIPE, abaixo: https://deividfortuna.github.io/fipe/ 

O terceiro serviço é o de retorno de um usuário com a lista de todos seus veículos cadastrados. 

_Observações: Caso os cadastros estejam corretos, é necessário voltar ao Status 201. Caso haja erros de preenchimento de dados, o Status deve ser 400. Caso a busca esteja correta, é necessário voltar ao Status 200. Caso haja erro na busca, retornar o status adequado e uma mensagem de erro amigável. Segue Collection do Postman com os comandos REST implementados na solução apresentada (link abaixo para copiar e colar):  https://www.getpostman.com/collections/0a95939f289339e039ca_

_P.S: Você deve substituir dentro do Postman o {hackerrank-session-url} pela URL fornecida na HackerRank ao acessar o "Preview" dentro da aba "Run" -> "Open Preview" (dentro da IDE visualizada ao lado)._

## Resources

Segue CURL's embaixo, caso você use outra ferramenta. 

CURL's 

### Add User 

```
curl --location --request POST '{hackerrank-session-url}/users/' \ --header 'Content-Type: application/json' \ --data-raw '{ "name": "Joao Batista Cordeiro Neto", "cpf": "05960712997", "email": "netowww@gmail.com", "birthdate": "1993-12-03" }' 
```

### Get User 

```
curl --location --request GET '{hackerrank-session-url}/users/05960712997'
```

### Add Vehicle 

```
curl --location --request POST '{hackerrank-session-url}/vehicles/05960712997' \ --header 'Content-Type: application/json' \ --data-raw '{ "id": 2, "brand": "7", "model": "8819", "yearAndfuel":"2021-1" }' 
```

### Get Vehicle 

```
curl --location --request GET '{hackerrank-session-url}/vehicles/05960712997' 
```

# Parte 2 

No endpoint que irá listar os veículos, serão considerados numa segunda parte algumas configurações a serem exibidas para o usuário final.  

Foram criados dois novos atributos no objeto do carro, sendo eles: 

1. Dia do rodízio deste carro, baseado no último número do ano do veículo, considerando as condicionais: 
- Final 0-1: segunda-feira 
- Final 2-3: terça-feira 
- Final 4-5: quarta-feira 
- Final 6-7: quinta-feira 
- Final 8-9: sexta-feira 
  
2. Também devemos criar um atributo de rodízio ativo, onde nós devemos pegar a data atual do sistema e comparar com as condicionais anteriores, onde, quando for o dia ativo do rodízio retornar TRUE, caso contrário, FALSE. 
 
_Exemplo A: hoje é segunda-feira, o carro é da marca Fiat, modelo Uno do ano de 2001, ou seja, seu rodízio será às segundas-feiras e o atributo de rodízio ativo será TRUE._

_Exemplo B: hoje é quinta-feira, o carro é da marca Hyundai, modelo HB20 do ano de 2021, ou seja, seu rodízio será às segundas-feiras e o atributo de rodízio ativo será FALSE._

Vamos desenvolver o método gerando o atributo de Rodízio (TryRotation) na classe FeignService.java durante a entrevista, pois no momento ele foi configurado para retornar sempre TRUE, independentemente do cenário. 

# Parte 3 

O objetivo dessa tarefa é de entregar um serviço funcional e seguindo as boas práticas para atualizar os dados de um usuário, a partir do seu CPF.

Caso um novo EMAIL seja informado, será preciso garantir que ele não esteja presente no banco de dados. 

Para implementar essa solução, o candidato pode usar a estrutura existente, e eventualmente criar novas classes ou interfaces, do momento que justifique o seu raciocínio.

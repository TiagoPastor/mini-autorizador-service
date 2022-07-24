# mini-autorizador-service: Aplicação para cadastrar cartões de Vale Alimentação e Vale Refeição, consultar saldo e autorizar transações.

 Objetivos
  - Permitir criar cartões VR/VA;
  - Obter o saldo do cartão;
  - Autorizar transações;
  
### Stack utilizada

* Java 11
* Spring Boot Web; JPA; Data; Actuator
* Maven
* JUnit
* OpenApi (Swagger v3)
* H2 DataBase
* PostgresSQL
* Lombok
* Docker

### Instalação

```
Executar o docker-compose.yml
comando: docker-compose up -d

```

### Spring Boot Version

```
Pode importar como projeto maven existente no Spring Tool Suite 4 que foi a versão usada para desenvolver
```

#### Swagger

```
OpenAPI: http://localhost:8080/v3/api-docs
Swagger UI: http://localhost:8080/swagger-ui/4.11.1/index.html
```
### Arquivo de Collection Json - Usar no Postman

```
  - O arquivo de Collection Json está na pasta Docs. Pode copiar e importar no postman para testar os payloads da api
```


### Versionamento da API

```
O versionamento foi feito pela url, onde a api foi construida como api/v1.

```

###Observação:

```
Link para acessar o banco H2: 
http://localhost:8080/h2-console
User = sa
Password = ""
host = jdbc:h2:mem:autorizadordb

```



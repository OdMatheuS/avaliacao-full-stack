

#### Front:
- Este projeto foi feito utilizando Angular (v. 10.2.4) & "Angular Material" (v. 10.2.7) para os componentes UI;

- Instruções rodar o front:
- Instalar as dependências: `npm i`
- Para subir o ambiente local `npm start` , estará rodando neste endereço por default `http://localhost:4200/`.

#### Back:
- Este projeto foi feito utilizando Spring Boot (v. 2.7.3) , Maven, e as seguintes dependências:("Spring Web","Spring Data JPA", "H2 Database", "Spring Security").

- Spring Security: configurações para "liberar" acesso via CORS, evitar alguns conflitos caso a aplicação seja acessada, por uma outra aplicação hospedada em lugares diferentes.

- Spring Web: Um dos mais utilizados para criar aplicativos web(Java), incluindo projetos RESTful.

- H2 Database: foi escolhido o banco H2, justamente por ser um banco de dados(SQL) em memória, muito simples para se utilizar;

- Spring Data JPA: Também muito utilizado, tanto para persistir dados em armazenamentos SQL com Java Persistence API usando Spring Data e Hibernate.



- Antes de começar a usar, deve baixar as dependências & via "Maven Update" atualizar pra ver se não tem nenhum conflito de versão, dependendo da IDE que for usar possui um atalho diferente.

-  Após baixar e instalar todas as dependências, pode rodar e estará rodando no endereço local `http://localhost:8080/` por default.


#### Endpoints:

```http
GET   baseURL/agendamento
```

```http
POST  baseURL/agendamento
```



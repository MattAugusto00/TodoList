# Todo List

Este projeto é uma aplicação To-Do List desenvolvida com Spring Boot no back-end e PostgreSQL como banco de dados.
O objetivo é permitir que usuários gerenciem suas tarefas de forma simples e eficiente, com funcionalidades para criar, listar, atualizar e excluir tarefas.

O ambiente é totalmente configurado com Docker Compose, garantindo facilidade na instalação e execução, sem necessidade de configurações manuais complexas.

Além disso, a aplicação utiliza JPA/Hibernate para comunicação com o banco.

<h3>Tecnologias Utilizadas</h3>

* Java 21: Linguagem principal do back-end.
* Spring Boot: Framework para desenvolvimento rápido e estruturado da API.
* Spring Data JPA: Integração e abstração do acesso ao banco de dados.
* PostgreSQL: Banco de dados relacional utilizado para armazenar as tarefas.
* Hibernate: Implementação JPA para mapeamento objeto-relacional (ORM).
* Docker: Containerização da aplicação e do banco de dados.
* PgAdmin: Interface gráfica para gerenciamento do banco PostgreSQL.
* Maven: Gerenciador de dependências e build do projeto.
* Lombok: Redução de código boilerplate (getters, setters, construtores etc).
* Postman: Ferramenta para testar manualmente endpoints de APIs REST, permitindo enviar requisições HTTP (GET, POST, PUT, DELETE etc.)

## Testes de endpoints com Postman

A seguir, estão os endpoints testados utilizando a ferramenta Postman. Além disso, serão mostrados alguns resultados das requisições no banco de dados.

### Salvar

Endpoint para salvar novas tarefas no banco

<img width="700" height="300" alt="image" src="https://github.com/user-attachments/assets/a6335a8a-6bc4-494d-a1f4-333d9e07132b" />


<br>Resultado da nova tarefa inserida no banco PostgreSQL

<img width="700" height="300" alt="image" src="https://github.com/user-attachments/assets/d91b7fc3-ad04-4944-80b2-98149cec0761" />


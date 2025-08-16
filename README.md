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

## Testes de endpoints com Postman

A seguir, estão os endpoints testados utilizando a ferramenta Postman. Além disso, serão mostrados os resultados das requisições no banco de dados.

### Salvar

Endpoint para salvar novas tarefas no banco

<img width="700" height="300" alt="image" src="https://github.com/user-attachments/assets/04f36c6e-6571-40c0-ab46-33f53278a41a" />

<br>Resultado da requisição post no banco PostgreSQL

<img width="700" height="300" alt="image" src="https://github.com/user-attachments/assets/73aa5c87-25a2-4172-a767-bd620360d3b6" />

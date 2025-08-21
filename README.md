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

A seguir, estão os endpoints testados utilizando a ferramenta Postman. Além disso, serão mostrados alguns resultados das requisições no banco de dados. Sobre os tratamentos de erros, serão melhores implementados em breve.

### Salvar 

Endpoint para salvar novas tarefas no banco. Serão apresentados alguns casos de falhas e sucesso.

#### Caso de Sucesso

Caso a requisição seja feita conforme o esperado, a resposta obtida será "201 Created", além disso, a tarefa será inserida na tabela do banco de dados.

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/a6335a8a-6bc4-494d-a1f4-333d9e07132b" />

<br>Resultado da nova tarefa inserida no banco PostgreSQL

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/d91b7fc3-ad04-4944-80b2-98149cec0761" />

#### Caso de Falha: mesma tarefa na mesma data

Caso o usuário tente inserir uma tarefa igual na mesma data, a resposta obtida será "500 Internal Error Server", além disso, a tarefa não será inserida na tabela do banco de dados. Normalmente, tarefas repetidas podem ser feitas no mesmo dia, porém, neste projeto foi feito de forma a não permitir, para criar alguns casos de falha.

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/11122e59-a074-4a14-bb6e-f29603667899" />

#### Caso de Falha: tentar salvar sem colocar o titulo ou a data de vencimento da tarefa

Caso o usuário tente inserir uma tarefa sem o titulo ou a data de vencimento, a resposta obtida será "400 Bad Request", além disso, a tarefa não será inserida na tabela do banco de dados.

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/d5a222cf-45b8-45e4-9b93-e638c2d6a5ac" />


### <br>Listar Todas

Endpoint para listar todas as tarefas que estão salvas no banco de dados.

Abaixo está a lista de todas tarefas que foram inseridas.

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/726cd0e5-2c8b-4512-9a55-ef1967b1e724" />

No PostgreSQL:

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/bfae9a9f-7002-456c-a086-21a039506d0b" />


### <br>Atualizar

Endpoint para atualizar as tarefas selecionadas que estão salvas no banco de dados. Para realizar esta ação, a tarefa é buscada pelo ID.

Abaixo está a atualização da tarefa de titulo "trabalho", presente no dia 2021-11-07. Ela passou de PENDENTE para CONCLUIDA.

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/c3349a23-7d9f-4d15-b4b6-95e7c547f990" />

No PostgreSQL

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/2fb79d35-fafb-4bb3-bbbe-fec2f410e3b6" />

Em caso de tentar atualizar sem passar o valor da dataVencimento, é retornado um erro "400 Bad Request", em breve isso será modificado para que aceite atualização sem precisar passar esta data. Segue o exemplo abaixo:

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/a7c1f8cf-a2f8-4e8a-9e83-d9e4f1458fc4" />

### <br>Deletar

Endpoint para deletar as tarefas selecionadas que estão salvas no banco de dados. Para realizar esta ação, a tarefa é buscada pelo ID.

Abaixo temos o exemplo da tarefa com titulo "academia" do dia 2021-11-08 sendo deletada do banco:

<img width="700" height="350" alt="image" src="https://github.com/user-attachments/assets/ecb65a63-cc6d-4acd-b97d-2599cc5a00d3" />

No PostgreSQL já se pode notar sua ausência

<img width="700" height="300" alt="image" src="https://github.com/user-attachments/assets/f4f8782d-d240-47fd-9ef0-25b1709ea7e8" />


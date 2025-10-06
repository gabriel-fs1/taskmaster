# 🚀 TaskMaster

## 📝 Visão Geral

Este projeto consiste em uma **API RESTful** para gerenciamento de tarefas pessoais (to-do list), desenvolvida em Java com o framework Spring Boot. A API permite que os usuários criem, atualizem, consultem e excluam suas tarefas, seguindo as melhores práticas de desenvolvimento, incluindo validações, tratamento de exceções, paginação e uma suíte completa de testes automatizados.

O principal objetivo deste exercício é consolidar e demonstrar conhecimentos avançados na construção de APIs robustas e escaláveis com o ecossistema Spring.

---
## 👨‍💻 Criadores

* Gabriel Feitoza da Silva - GU3046567
* Nathalie Gonçalves Xavier - GU3046443
---

### Restrições Importantes:

  - Não é permitido criar tarefas com `dataLimite` anterior à data atual.
  - Tarefas com o status `concluida = true` **não podem ser editadas ou excluídas**. Qualquer tentativa resultará em um erro `409 (Conflict)`.

## 📡 Endpoints da API

A seguir, a lista de funcionalidades implementadas e seus respectivos endpoints:

| Verbo HTTP | Caminho | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/tasks` | Cria uma nova tarefa. |
| `GET` | `/api/tasks` | Lista todas as tarefas com suporte a paginação, ordenação e filtros. |
| `GET` | `/api/tasks/{id}` | Busca uma tarefa específica pelo seu ID. |
| `GET` | `/api/tasks/search` | Busca tarefas por categoria (ex: `?categoria=estudo`). |
| `PATCH` | `/api/tasks/{id}/concluir` | Marca uma tarefa como concluída. |
| `PUT` | `/api/tasks/{id}` | Atualiza todos os dados de uma tarefa existente. |
| `DELETE` | `/api/tasks/{id}` | Remove uma tarefa (desde que não esteja concluída). |

### Exemplos de Paginação e Ordenação

```
// Retorna a primeira página com 5 itens, ordenados por prioridade
GET /api/tasks?page=0&size=5&sort=prioridade,asc

// Retorna a segunda página, ordenada pela dataLimite mais recente
GET /api/tasks?page=1&size=10&sort=dataLimite,desc
```

## 🛠️ Tecnologias Utilizadas

  - **Java 17**
  - **Spring Boot 3**
  - **Spring Web**
  - **Spring Data JPA**
  - **H2 Database** (para ambiente de desenvolvimento e testes)
  - **Bean Validation**
  - **JUnit 5, Mockito & MockMvc** (para testes)
  - **ModelMapper**
  - **Maven**

## ⚙️ Como Executar o Projeto

### Pré-requisitos

  - JDK 17 ou superior
  - Apache Maven 3.8 ou superior

### Passos

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/gabriel-fs1/taskmaster.git
    cd taskmaster
    ```

2.  **Compile e execute a aplicação com o Maven:**

    ```bash
    mvn spring-boot:run
    ```

3.  A API estará disponível em `http://localhost:8080`. Você pode usar ferramentas como o [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para interagir com os endpoints.

## ✅ Executando os Testes

Para garantir a qualidade e o correto funcionamento da API, execute a suíte de testes automatizados com o seguinte comando:

```bash
mvn test
```

Este comando executará todos os testes unitários e de integração, validando as regras de negócio, o funcionamento dos endpoints e o tratamento de exceções. Os relatórios de teste podem ser encontrados em `target/surefire-reports`.

# 🚀 API REST de Gerenciamento de Alunos - Spring Boot (Semana 03)

Repositório oficial do entregável de **Desenvolvimento de APIs e Backend**, focado na implementação de um CRUD completo utilizando o padrão **DTO (Data Transfer Object)**, tratamento explícito de exceções e controle rigoroso de status HTTP.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas
* **Java 17+**
* **Spring Boot** (Spring Web, Spring Data JPA)
* **Banco de Dados Relacional** (PostgreSQL / H2)
* **IntelliJ IDEA**
* **Git & GitHub**

---

## 📁 Estrutura do Projeto
O projeto está organizado em camadas para garantir a separação de responsabilidades:
```text
src/main/java/org/example/sistema_aluno/
├── controller/
│   └── AlunoController.java       # Endpoints REST (POST, GET, PUT, DELETE)
├── dto/
│   ├── AlunoRequest.java          # DTO de entrada (dados recebidos na API)
│   └── AlunoResponse.java         # DTO de saída (dados retornados ao cliente)
├── model/
│   └── Aluno.java                 # Entidade JPA (tabela de banco de dados)
├── repository/
│   └── AlunoRepository.java       # Interface de persistência de dados
└── SistemaAlunoApplication.java   # Classe principal de inicialização do Spring Boot

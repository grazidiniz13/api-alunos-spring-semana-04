# 🚀 API RESTful - Sistema de Alunos (Spring Boot)

Repositório desenvolvido para as entregas e evoluções do projeto de Backend com Spring Boot, focado na construção de uma API REST completa para gerenciamento de alunos, aplicando boas práticas de desenvolvimento, arquitetura em camadas, persistência com JPA/Hibernate, padronização via DTOs e código limpo com Lombok.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Java 17+**
* **Spring Boot** (Web, Data JPA)
* **Maven** (Gerenciador de Dependências)
* **Lombok** (Redução de código boilerplate)
* **Banco de Dados H2** (Em memória para testes)
* **Git & GitHub**

---

## 📋 Arquitetura do Projeto

O projeto segue estritamente o padrão de separação de responsabilidades em camadas:

```text
src/main/java/org/example/sistema_aluno/
│
├── controller/     # Controladores REST (Endpoints HTTP)
├── dto/            # Objetos de Transferência de Dados (Request/Response)
├── model/          # Entidades do Banco de Dados (JPA Entities)
├── repository/     # Interfaces de Acesso ao Banco de Dados (Spring Data JPA)
└── SistemaAlunoApplication.java # Classe Principal

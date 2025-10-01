# MINI API DE CADASTRO DE USUÁRIOS

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-blue?style=for-the-badge&logo=apachemaven&logoColor=white)

---

## 💡 Sobre o Projeto

Aplicação desenvolvida em **Spring Boot** que implementa um sistema de gerenciamento de **usuários**.  

A API oferece as operações **CRUD básicas** (cadastrar, consultar).

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5**
- **Spring Data JPA**
- **H2 Database** (banco de dados local para testes)
- **Maven** (gerenciador de dependências)
- **Springdoc OpenAPI** (documentação Swagger UI)

---

## 🗂️ Entidades do Sistema

### **User**
Representa um usuário no sistema.  

**Atributos:**
- `id` *(UUID)* → Identificador único do usuário, gerado automaticamente  
- `name` *(String, máx. 50)* → Nome do usuário 
- `email` *(String, máx. 100)* → E-mail do usuário 
- `creationDate` *(LocalDate, máx. 50)* → Data de criação 

---

## 📌 Endpoints

### **Users** (`/api/users`)

- `POST /api/users` → Insere um novo usuário
- `GET /api/users` → Busca os ussários cadastrados no banco
- `GET /api/users/{id}` → Busca um usuário por ID


## 📋 Exemplos de Requisições (cURL)

### **Cadastrar usuário**

```bash
{
  "name": "Pedro",
  "email": "pedro@businessbrasil.com",
  "creationDate": "2025-09-20"
}

- O campo "ID" é gerado automaticamente, por isso não está especificado no JSON.
```

---

## 🚀 Como Executar Localmente

### **Pré-requisitos**

- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)  
- [Maven 3.9+](https://maven.apache.org/download.cgi)  

### **Instalação**


1. **Clonar o repositório**  
```bash
git clone https://github.com/devpedrosena1/teste-pratico-business-brasil.git
```

2. **Entrar na pasta do projeto**  
```bash
cd TestePraticoBackEnd
```

3. **Compilar o projeto**  
```bash
mvn clean install
```

### **Execução**

**Executar a aplicação**  
```bash
mvn spring-boot:run
```

O projeto iniciará em:  
👉 [http://localhost:8080](http://localhost:8080)

A documentação Swagger estará disponível em:  
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

O banco de dados em memória estára disponível em:  
👉 [http://localhost:8080/console](http://localhost:8080/console)

👉 Driver Class: org.h2.Driver

👉 JDBC URL: jdbc:h2:mem:blog_database

👉 Username: SA

👉 Password: masterkey

---

## 📐 Especificações Técnicas

- Arquitetura organizada em **camadas**:  
  - `domainmodel` → entidades e repositórios  
  - `service` → regras de negócio  
  - `presentation.controllers` → endpoints REST  
  - `infrastructure` → configuração do Swagger e handlers globais  

- Uso de **DTOs** para transporte de dados (`UserDTO`)  
- Tratamento centralizado de exceções com `GlobalExceptionHandler`
- Teste de **Service** utilizando JUnit e Mockito `UserServiceImplTest`

---

## 👥 Contribuidores

- [**@devpedrosena1**](https://github.com/devpedrosena1) — Desenvolvimento Backend

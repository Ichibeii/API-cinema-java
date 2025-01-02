# Projeto de Gerenciamento de Cinema

Este projeto é uma aplicação desenvolvida em **Java** com **Spring Boot** para gerenciar a reserva de cadeiras em um cinema. A aplicação permite criar salas, cadastrar cadeiras, registrar pessoas e realizar reservas de cadeiras de forma simples e eficiente.

## Funcionalidades

- **Gerenciamento de Salas**:
  - Criar, listar e deletar salas de cinema.
- **Gerenciamento de Cadeiras**:
  - Criar, listar e verificar a disponibilidade de cadeiras associadas a uma sala.
- **Gerenciamento de Pessoas**:
  - Cadastrar e listar pessoas com nome e CPF.
- **Reserva de Cadeiras**:
  - Permite reservar cadeiras disponíveis para pessoas registradas.

## Tecnologias Utilizadas

- **Java** 17
- **Spring Boot**
  - Spring Data JPA
  - Spring Web
- **Banco de Dados**: PostgreSQL
- **JPA/Hibernate**: Para mapeamento objeto-relacional
- **Postman**: Para testes das APIs

## Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- PostgreSQL instalado e configurado

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio
   ```

2. Configure o banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Compile o projeto:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

## Endpoints Disponíveis

### Salas
- **GET /cinema/salas**: Lista todas as salas.
- **POST /cinema/salas**: Cria uma nova sala.
- **DELETE /cinema/salas/{id}**: Remove uma sala pelo ID.

### Cadeiras
- **GET /cinema/cadeiras**: Lista todas as cadeiras.
- **POST /cinema/cadeiras**: Cria uma nova cadeira.

### Pessoas
- **GET /cinema/pessoas**: Lista todas as pessoas.
- **POST /cinema/pessoas**: Cadastra uma nova pessoa.

### Reserva de Cadeiras
- **POST /cinema/cadeiras/{cadeiraId}/pessoas/{pessoaId}**: Reserva uma cadeira para uma pessoa.

## Exemplos de Uso

### Criar uma Sala
**Requisição:**
```json
POST /cinema/salas
{
  "nome": "Sala 1"
}
```

### Cadastrar uma Pessoa
**Requisição:**
```json
POST /cinema/pessoas
{
  "nome": "João Silva",
  "cpf": "12345678901"
}
```

### Reservar uma Cadeira
**Requisição:**
```json
POST /cinema/cadeiras/1/pessoas/2
```

### Listar Cadeiras
**Requisição:**
```json
GET /cinema/cadeiras
```

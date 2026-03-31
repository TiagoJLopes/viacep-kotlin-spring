# 📮 ViaCEP API — Kotlin + Spring Boot

API REST desenvolvida em Kotlin com Spring Boot para consulta e persistência de endereços brasileiros a partir do CEP, utilizando a API pública do ViaCEP.

---

## 🚀 Tecnologias

- **Kotlin** — Linguagem de programação
- **Spring Boot 3.5** — Framework principal
- **Spring Data JPA** — Persistência de dados
- **PostgreSQL** — Banco de dados relacional
- **Hibernate** — ORM para mapeamento objeto-relacional
- **Swagger (SpringDoc)** — Documentação automática da API
- **RestTemplate** — Integração com a API externa ViaCEP
- **Postman** — Testes de requisições HTTP

---

## 📋 Funcionalidades

- 🔍 Consulta de endereço por CEP via API do ViaCEP
- 💾 Persistência automática do endereço no PostgreSQL
- ⚡ Cache simples — CEPs já consultados são retornados do banco sem nova chamada externa
- 📄 Listagem de todos os endereços salvos
- 📚 Documentação interativa via Swagger UI

---

## 🏗️ Arquitetura

```
controller/
└── EnderecoController.kt   # Rotas da API (GET /enderecos, GET /enderecos/{cep})

service/
└── EnderecoService.kt      # Regras de negócio e integração com ViaCEP

repository/
└── EnderecoRepository.kt   # Interface de acesso ao banco de dados

model/
└── Endereco.kt             # Entidade que representa a tabela no banco
```

---

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/enderecos` | Lista todos os endereços salvos |
| `GET` | `/enderecos/{cep}` | Busca endereço pelo CEP (consulta ViaCEP e salva no banco) |

---

## 📦 Como executar

### Pré-requisitos

- Java 21+
- PostgreSQL 16+
- IntelliJ IDEA

### Configuração do banco de dados

```sql
CREATE DATABASE cepapi;
CREATE USER seu_usuario WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE cepapi TO seu_usuario;
```

### Configuração do application.yaml

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/cepapi
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update

server:
  port: 8080
```

### Executando o projeto

Abra o projeto no IntelliJ IDEA e execute a classe `CepApiApplication.kt`.

A aplicação estará disponível em `http://localhost:8080`.

---

## 📚 Documentação

Acesse a documentação interativa via Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 💡 Exemplo de uso

### Buscar endereço por CEP

**Request:**
```
GET http://localhost:8080/enderecos/01310100
```

**Response:**
```json
{
  "id": 1,
  "cep": "01310100",
  "logradouro": "Avenida Paulista",
  "bairro": "Bela Vista",
  "cidade": "São Paulo",
  "estado": "SP"
}
```

---

## 👨‍💻 Autor

Desenvolvido por **Tiago Lopes** como projeto de aprendizado em desenvolvimento backend com Kotlin e Spring Boot.

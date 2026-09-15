# API-Eventos

API REST para gerenciamento de eventos com controle de vagas.

## Tecnologias

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- MySQL
- Lombok
- SpringDoc OpenAPI (Swagger)

## Estrutura do projeto

```
src/main/java/com/api_eventos/
├── controller/
│   ├── EventoController.java
│   ├── InscricaoController.java
│   └── ParticipanteController.java
├── dto/
│   ├── EventoDto.java
│   ├── EventoResponse.java
│   ├── InscricaoDto.java
│   ├── InscricaoResponse.java
│   ├── ParticipanteDto.java
│   └── ParticipanteResponse.java
├── exception/
│   ├── EmailDuplicadoException.java
│   ├── GlobalExcepionHandler.java
│   ├── InscricaoDuplicadaException.java
│   └── VagasLimiteException.java
├── model/
│   ├── Evento.java
│   ├── Inscricao.java
│   └── Participante.java
├── repository/
│   ├── EventoRepository.java
│   ├── InscricaoRepository.java
│   └── ParticipanteRepository.java
├── service/
│   ├── EventoService.java
│   ├── InscricaoService.java
│   └── ParticipanteService.java
└── ApiEventosApplication.java
```

## Como executar

**Pré-requisitos:** Java 21+ e Maven instalados, MySQL rodando.

### 1. Configure o `application.yml`

```yaml
spring:
  application:
    name: API-Eventos

  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/api_eventos?createDatabaseIfNotExist=true
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    database-platform: org.hibernate.dialect.MySQLDialect
    hibernate:
      ddl-auto: update
```

### 3. Execute o projeto

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

Documentação Swagger: `http://localhost:8080/swagger-ui.html`

---

## Endpoints

### Eventos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/eventos` | Cadastrar evento |
| `GET` | `/eventos` | Listar todos os eventos |
| `GET` | `/eventos/{id}` | Consultar evento (com vagas restantes) |

### Participantes

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/participantes` | Cadastrar participante |

### Inscrições

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/eventos/{eventoId}/inscricoes/{participanteId}` | Inscrever participante |
| `GET` | `/eventos/{eventoId}/inscricoes` | Listar inscritos no evento |
| `DELETE` | `/eventos/{eventoId}/inscricoes/{participanteId}` | Cancelar inscrição |

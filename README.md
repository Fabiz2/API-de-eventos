# Eventos API

API REST para gerenciamento de eventos com controle de vagas.

## Tecnologias

- Java 17
- Spring Boot 3.2
- H2 (banco em memória)

## Como executar

**Pré-requisitos:** Java 17+ e Maven instalados.

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/eventos-api.git
cd eventos-api

# Execute
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

> O banco H2 é em memória — os dados são resetados ao reiniciar a aplicação.  
> Console H2: `http://localhost:8080/h2-console` (usuário: `sa`, senha: em branco)

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

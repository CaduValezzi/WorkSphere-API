# WorkSphere API

A WorkSphere API é uma plataforma desenvolvida para melhorar a vida das pessoas no ambiente de trabalho usando tecnologia, inclusão e bem-estar como pilares.
O sistema permite gerenciar usuários, autenticá-los com segurança, controlar permissões por perfil e fornecer uma base sólida para construir funcionalidades voltadas a programas de apoio, sustentabilidade, saúde mental, capacitação e clima organizacional.

Foi criada para atender os requisitos da GS de SOA & WebServices, seguindo boas práticas de arquitetura, modularização e segurança.

## Tecnologias
- Java 17
- Spring Boot 3
- Spring Web
- Spring Security
- Spring Data JPA
- MySQL
- JWT (jjwt)
- Bean Validation (Jakarta Validation)

## Endpoints principais

| Método | Endpoint         | Descrição                      |
| ------ | ---------------- | ------------------------------ |
| POST   | `/usuarios`      | Cria um novo usuário           |
| GET    | `/usuarios`      | Lista todos os usuários        |
| GET    | `/usuarios/{id}` | Retorna detalhes de um usuário |
| DELETE | `/usuarios/{id}` | Exclui um usuário              |

## Como rodar

1. Crie um banco de dados MySQL chamado `worksphere`.

```sql
CREATE DATABASE worksphere;
```

2. Ajuste `spring.datasource.username` e `spring.datasource.password` em `application.properties`.

3. Rode:

```bash
mvn spring-boot:run
```

## 👥 Integrantes
- RM551059 | Cassio Valezzi
- RM98215  | Gabriel Antony Cadima Ciziks
- RM98169  | Lucca Sabatini Tambellini
# WorkSphere API

A WorkSphere API é uma plataforma projetada para promover melhorias significativas no ambiente de trabalho por meio do uso de tecnologia voltada ao bem-estar, inclusão e desenvolvimento profissional.
O sistema oferece uma infraestrutura segura e escalável para gestão de usuários, autenticação robusta e controle de acesso baseado em perfis, garantindo a conformidade com boas práticas de arquitetura e segurança da informação.

Além disso, a API estabelece a base necessária para o desenvolvimento de funcionalidades relacionadas a programas corporativos de saúde mental, sustentabilidade, capacitação contínua e monitoramento do clima organizacional, permitindo que organizações construam ambientes mais saudáveis, eficientes e alinhados às demandas contemporâneas do mercado.

### 👥 Integrantes
- RM551059 | Cassio Valezzi
- RM98215  | Gabriel Antony Cadima Ciziks
- RM98169  | Lucca Sabatini Tambellini

## Funcionamento Geral da Aplicação
1. Autenticação
    - Usuário envia suas credenciais para o endpoint de login (/auth/login).
    - As credenciais são validadas pelo AuthService usando o AuthenticationManager do Spring Security.
    - Se estiver tudo certo, é gerado um token JWT pela classe JwtService.
    - O token retornado é usado pelo cliente (frontend ou outro consumidor) no header Authorization: Bearer <token>.

2. Autorização & Acesso

    - As requisições autenticadas passam pelo JwtAuthenticationFilter, que:

        - Lê o token;

        - Valida assinatura e expiração;

        - Extrai o usuário e seus papéis;

        - Registra o contexto de segurança para a requisição.

    - O acesso aos recursos da API é controlado por:

        - Configuração de segurança (SecurityConfig);

        - Perfis de usuário (PerfilUsuario: ADMIN, GESTOR, COLABORADOR).

3. Gestão de Usuários

    - Operações de CRUD de usuário são centralizadas em:

        - UsuarioController

        - UsuarioService

        - UsuarioRepository

    - Os dados sensíveis (como senha) são tratados com:

        - Hash de senha via PasswordEncoder (BCrypt).

    - O e-mail do usuário é encapsulado em um Value Object (Email), garantindo validação e consistência de formato.

4. Respostas e Erros

    - As respostas da API são padronizadas pela classe ApiResponse<T>, que encapsula:

        - Mensagem

        - Dados

        - Status lógico da operação

    - Tratamento de erros centralizado no GlobalExceptionHandler, convertendo exceções em respostas HTTP consistentes.

## Tecnologias
- Linguagem: Java 17
- Framework: Spring Boot 3.x
- Módulos Spring:
    - Spring Web
    - Spring Security
    - Spring Data JPA
    - Spring Validation
- Banco de Dados: MySQL
- ORM: Hibernate / JPA
- Autenticação: JWT (io.jsonwebtoken)
- Build: Mave- 

## Configuração e Execução
1. Pré-requisitos

Java 17 instalado

Maven instalado

MySQL rodando localmente

2. Configuração do Banco de Dados

No arquivo src/main/resources/application.properties:
```cmd
spring.datasource.url=jdbc:mysql://localhost:3306/worksphere?useSSL=false&createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

jwt.secret=troque-esta-chave-super-secreta-por-uma-bem-grande-mesmo-para-producao
jwt.expiration=3600000

```
Ajuste conforme seu ambiente:

- Usuário e senha do banco

- URL do MySQL

- jwt.secret: em produção deve ser:

    - Longa

    - Randômica

    - Mantida em variável de ambiente / vault, não em arquivo de configuração.- 

3. Rodando o Projeto

Clone o repositório:

```cmd
git clone https://github.com/CaduValezzi/WorkSphere-API.git
cd WorkSphere-API
```

Execute com Maven:

```cmd
mvn spring-boot:run
```

A API ficará disponível, por padrão, em:

http://localhost:8080

## Endpoints principais

| Método | Endpoint         | Descrição                      |
| ------ | ---------------- | ------------------------------ |
| POST   | `/usuarios`      | Cria um novo usuário           |
| GET    | `/usuarios`      | Lista todos os usuários        |
| GET    | `/usuarios/{id}` | Retorna detalhes de um usuário |
| DELETE | `/usuarios/{id}` | Exclui um usuário              |

## Arquitetura

```bash
│   .gitattributes
│   .gitignore
│   mvnw
│   mvnw.cmd
│   pom.xml
│   README.md
│   
├───.idea
│       .gitignore
│       compiler.xml
│       jarRepositories.xml
│       misc.xml
│       vcs.xml
│       workspace.xml
│
├───.mvn
│   └───wrapper
│           maven-wrapper.properties
│
├───src
│   └───main
│       ├───java
│       │   └───br
│       │       └───com
│       │           └───worksphere
│       │               │   WorksphereApplication.java
│       │               │
│       │               ├───auth
│       │               │   ├───controller
│       │               │   │       AuthController.java
│       │               │   │
│       │               │   ├───dto
│       │               │   │       LoginRequestDTO.java
│       │               │   │       TokenResponseDTO.java
│       │               │   │
│       │               │   └───service
│       │               │           AuthService.java
│       │               │
│       │               ├───config
│       │               │       SecurityConfig.java
│       │               │
│       │               ├───core
│       │               │   ├───dto
│       │               │   │       ApiResponse.java
│       │               │   │
│       │               │   ├───exception
│       │               │   │       BusinessException.java
│       │               │   │       GlobalExceptionHandler.java
│       │               │   │
│       │               │   └───security
│       │               │           JwtAuthenticationFilter.java
│       │               │           JwtService.java
│       │               │           UsuarioDetailsService.java
│       │               │           UsuarioPrincipal.java
│       │               │
│       │               └───usuario
│       │                   ├───controller
│       │                   │       UsuarioController.java
│       │                   │
│       │                   ├───dto
│       │                   │       AlterarSenhaDTO.java
│       │                   │       UsuarioRequestDTO.java
│       │                   │       UsuarioResponseDTO.java
│       │                   │
│       │                   ├───entity
│       │                   │       Usuario.java
│       │                   │
│       │                   ├───enums
│       │                   │       PerfilUsuario.java
│       │                   │
│       │                   ├───repository
│       │                   │       UsuarioRepository.java
│       │                   │
│       │                   ├───service
│       │                   │       UsuarioService.java
│       │                   │
│       │                   └───vo
│       │                           Email.java
│       │
│       └───resources
│               application.properties
│
└───target
    ├───classes
    │       application.properties
    │
    ├───generated-sources
    │   └───annotations
    └───maven-status
        └───maven-compiler-plugin
            └───compile
                └───default-compile
                        createdFiles.lst
                        inputFiles.lst
```



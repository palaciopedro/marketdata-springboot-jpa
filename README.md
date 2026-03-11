# MarketData: Sistema de Gerenciamento de Vendas com Spring Boot e JPA

## Descrição do Projeto

O `MarketData` é um projeto robusto desenvolvido com Spring Boot, projetado para gerenciar dados de vendas de forma eficiente. Ele utiliza Spring Data JPA para persistência de dados, oferecendo uma solução completa para operações CRUD (Create, Read, Update, Delete) em entidades relacionadas a vendas. Este sistema é ideal para aplicações que necessitam de um backend sólido para manipulação de informações de mercado e vendas.

## Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias e ferramentas:

*   **Framework:** Spring Boot `3.2.3`
*   **Linguagem de Programação:** Java `21`
*   **Persistência:** Spring Data JPA
*   **Banco de Dados (Desenvolvimento/Testes):** H2 Database (em memória)
*   **Banco de Dados (Produção):** PostgreSQL
*   **Ferramenta de Build:** Apache Maven
*   **Servidor Web Embarcado:** Apache Tomcat (padrão do Spring Boot)

## Estrutura do Projeto

A estrutura de pacotes do projeto segue as melhores práticas do Spring Boot, organizando o código de forma modular e clara:

```
src/main/java/com/springproject/salesdb
├── config             // Classes de configuração da aplicação
├── entities           // Classes de entidade que representam o modelo de dados
├── repositories       // Interfaces de repositório para acesso a dados (Spring Data JPA)
├── resources          // Controladores REST para expor os endpoints da API
└── services           // Camada de serviço contendo a lógica de negócio
```

## Como Rodar o Projeto

Para configurar e executar o projeto localmente, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

*   **Java Development Kit (JDK):** Versão 21 ou superior
*   **Apache Maven:** Versão 3.x ou superior
*   **Git:** Para clonar o repositório

### Passos para Execução

1.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/palaciopedro/marketdata-springboot-jpa.git
    ```

2.  **Navegar até o diretório do projeto `salesdb`:**
    ```bash
    cd marketdata-springboot-jpa/salesdb
    ```

3.  **Configurar o banco de dados H2 (para desenvolvimento/testes):**
    O projeto está configurado para usar o H2 Database em memória por padrão, ativado pelo perfil `test`. As configurações específicas podem ser encontradas em `src/main/resources/application-test.properties`.

4.  **Compilar e executar a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A aplicação será iniciada e estará acessível em `http://localhost:8080` (ou na porta configurada).

## Configuração do Banco de Dados

### H2 Database (Desenvolvimento/Testes)

Para ambientes de desenvolvimento e teste, o projeto utiliza o H2 Database em memória. As configurações padrão são:

*   **URL de Conexão:** `jdbc:h2:mem:testdb`
*   **Usuário:** `sa`
*   **Senha:** (vazia)

O console do H2 pode ser acessado através do navegador em `http://localhost:8080/h2-console` (ou na porta configurada) quando a aplicação estiver em execução. Certifique-se de usar as credenciais acima para fazer login.

### PostgreSQL (Produção)

Para implantações em produção, recomenda-se o uso do PostgreSQL. Para configurar o projeto para usar PostgreSQL, você precisará adicionar as propriedades de conexão no arquivo `src/main/resources/application.properties` ou criar um perfil de produção específico (ex: `application-prod.properties`). Exemplo de configuração:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/salesdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Endpoints da API

O projeto expõe endpoints RESTful para gerenciar as entidades de vendas. Embora os endpoints exatos dependam das entidades definidas, a estrutura comum inclui:

*   `GET /api/entidade`: Retorna uma lista de todas as entidades.
*   `GET /api/entidade/{id}`: Retorna uma entidade específica pelo ID.
*   `POST /api/entidade`: Cria uma nova entidade.
*   `PUT /api/entidade/{id}`: Atualiza uma entidade existente.
*   `DELETE /api/entidade/{id}`: Exclui uma entidade.

**Exemplo (inferido):** Se houver uma entidade `Product`, você pode esperar endpoints como `/api/products`.

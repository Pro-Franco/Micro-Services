# Micro-Services (Spring Boot)

Este repositório contém um conjunto de microserviços em Spring Boot para demonstração.

Serviços incluídos
- eureka-server — Registry/Discovery (porta 8761)
- estatisticas-service — Serviço de estatísticas (porta 8089)
- jogadores-service — Serviço de jogadores (porta 8085)
- times-service — Serviço de times (porta 8087)

Principais características
- Implementados com Spring Boot 3.x
- Uso do Netflix Eureka para descoberta de serviços
- Persistência via PostgreSQL (para serviços que usam DB)
- `eureka-server` usa H2 em tempo de execução

Pré-requisitos
- Java 23 (configurado nos `pom.xml`)
- Maven (ou use o wrapper `mvnw`/`mvnw.cmd` incluído)
- PostgreSQL rodando localmente (opcional para testes que usam DB)

Configurações importantes
- Cada serviço tem `src/main/resources/application.properties` com porta e URL do Eureka.
- Configuração de banco (para `estatisticas-service`, `jogadores-service` e `times-service`):
  - URL: `jdbc:postgresql://localhost:5432/obras`
  - Usuário: `postgres`
  - Senha: `admin`
  - Ajuste conforme seu ambiente se necessário.

Ordem de inicialização
1. Iniciar o `eureka-server` (registry) na porta 8761.
2. Iniciar as aplicações que dependem do Eureka (`estatisticas-service`, `jogadores-service`, `times-service`).

Como executar (Windows)
1. Abrir terminal na raiz do repositório.

2. Rodar o Eureka Server:

```bash
cd eureka-server/eureka-server
mvnw.cmd spring-boot:run
```

3. Em terminais separados, rodar os serviços (exemplo para `jogadores-service`):

```bash
cd jogadores-service/jogadores-service
mvnw.cmd spring-boot:run
```

Substitua `mvnw.cmd` por `./mvnw` em ambientes Unix.

Build com Maven (packaging jar)

```bash
cd jogadores-service/jogadores-service
mvnw.cmd clean package
java -jar target/jogadores-service-0.0.1-SNAPSHOT.jar
```

Observações
- As portas padrão estão definidas em `application.properties` de cada serviço:
  - `eureka-server`: 8761
  - `jogadores-service`: 8085
  - `times-service`: 8087
  - `estatisticas-service`: 8089
- Se você usar Docker para PostgreSQL, exponha a porta 5432 e crie o database `obras`.
- Se preferir não usar Postgres, adapte `application.properties` para um banco em memória para desenvolvimento.


Gerado a partir dos `pom.xml` e `application.properties` dos serviços.

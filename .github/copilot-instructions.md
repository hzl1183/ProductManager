# Copilot Instructions

## Project and commands

- Spring Boot 4.2.0 Java application; the POM declares Java 27. Uses Maven, Spring Web MVC, Spring Data JPA, PostgreSQL, Validation, Lombok, and JUnit 5.
- Run from the repository root with the Maven wrapper: `mvnw.cmd` on Windows or `./mvnw` on Unix-like systems. Configure a compatible JDK and `JAVA_HOME`.
- Build/package: `mvnw.cmd clean package`
- Run: `mvnw.cmd spring-boot:run`
- Test suite: `mvnw.cmd test`
- One test class: `mvnw.cmd -Dtest=ProductManagementApplicationTests test`
- One test method: `mvnw.cmd "-Dtest=ProductManagementApplicationTests#contextLoads" test`
- No dedicated lint or formatting plugin is configured in the POM.

The default PostgreSQL URL is `jdbc:postgresql://localhost:5432/sms`. Supply credentials through `DB_USERNAME` and `DB_PASSWORD`; `DB_URL` can override the URL. `spring.jpa.hibernate.ddl-auto=update` is enabled.

## Architecture

`ProductManagementApplication` boots the application. HTTP endpoints live in `ProductController` under `/api/products` and delegate to the `ProductService` interface. `ProductServiceImpl` implements operations using `productRepository` (`JpaRepository<Product, Long>`). The service maps between the `Product` JPA entity and API-facing `ProductDto` using `ProductMapper`. `ResourcesNotFoundException` maps missing product lookups to HTTP 404.

The API currently supports `POST /api/products`, `GET /api/products`, and `GET /api/products/{id}`. Keep entities behind the service layer; controller inputs and outputs use DTOs.

## Code conventions

- Keep classes in the existing `com.example.ProductManagement` package structure (`controller`, `service`, `repository`, `entity`, `dto`, `mapper`, `exception`).
- For new operations, add the contract to `ProductService`, implement it in `ProductServiceImpl`, and expose it through `ProductController` as appropriate.
- Use `ProductMapper` for entity/DTO conversions. Put persistence mappings on `Product`, not `ProductDto`.
- Lombok is used for accessors and constructor generation; service implementation dependencies use constructor injection.
- The repository interface currently uses the lowercase name `productRepository`; retain it consistently unless intentionally renaming all references.
- Tests use JUnit 5 and Spring Boot `@SpringBootTest`. The application context needs an available PostgreSQL datasource unless a test-specific datasource is configured.

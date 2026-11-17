# API REST con Spring Boot, Spring Security, JWT y MySQL

Proyecto académico correspondiente al **Taller Spring Boot + JWT - III Seguimiento**[cite: 1], que implementa autenticación y autorización sin estado (*stateless*) mediante JSON Web Tokens (JWT) y persistencia de usuarios en MySQL.

* **Autor:** Orlando Beltrán[cite: 1]
* **Asignaturas:** Desarrollo de Software 2 / Gestión de Redes de Computadores[cite: 1]

---

## Tecnologías y Características

* **Java & Spring Boot** (gestión de dependencias con Maven)
* **Spring Security (`SessionCreationPolicy.STATELESS`):** Cada petición es independiente y valida su identidad mediante cabecera `Authorization: Bearer <token>`, sin sesiones HTTP en servidor[cite: 4, 5].
* **JSON Web Tokens (JWT):** Tokens firmados con algoritmo **HS256** compuestos por `Header.Payload.Signature`.
* **Cifrado de contraseñas:** Uso de `BCryptPasswordEncoder` con *salt* aleatorio antes de almacenar credenciales en base de datos.
* **Control de acceso por roles:** Asignación automática del rol `ROLE_USER` al registrar nuevos usuarios bajo el principio de mínimo privilegio[cite: 3, 4].
* **MySQL 8:** Persistencia mediante Spring Data JPA[cite: 3, 6].

---

## Estructura del Proyecto

```text
src/main/java/com/ejemplo/jwtmysql/
├── model/
│   └── AppUser.java            # Entidad JPA mapeada a la tabla app_users[cite: 3, 6]
├── repository/
│   └── UserRepository.java     # Repositorio Spring Data JPA
├── security/
│   └── SecurityConfig.java     # Configuración de filtros, BCrypt y rutas protegidas[cite: 4, 6]
├── service/
│   └── TokenService.java       # Generación y validación de tokens JWT[cite: 6]
├── web/
│   ├── AuthController.java     # Endpoints públicos de registro y login (/api/auth/*)[cite: 2, 4, 6]
│   └── SecuredController.java  # Endpoints protegidos por autenticación (/api/secured)[cite: 3, 4, 6]
└── JwtmysqlApplication.java    # Clase principal de arranque[cite: 6]
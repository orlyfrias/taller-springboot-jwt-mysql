# API REST con Spring Boot, Spring Security, JWT y MySQL

Proyecto académico correspondiente al **Taller Spring Boot + JWT - III Seguimiento**, que implementa autenticación y autorización sin estado (*stateless*) mediante JSON Web Tokens (JWT) y persistencia de usuarios en MySQL.

 Autor: Orlando Beltrán
Asignaturas:Desarrollo de Software 2 / Gestión de Redes de Computadores

---

## Tecnologías y Características

* Java & Spring Boot** (gestión de dependencias con Maven)
* Spring Security (`SessionCreationPolicy.STATELESS`):** Cada petición es independiente y valida su identidad mediante la cabecera `Authorization: Bearer <token>`, sin sesiones HTTP en servidor.
* JSON Web Tokens (JWT):** Tokens firmados con algoritmo **HS256** compuestos por `Header.Payload.Signature`.
* Cifrado de contraseñas:** Uso de `BCryptPasswordEncoder` con *salt* aleatorio antes de almacenar credenciales en base de datos.
* Control de acceso por roles:** Asignación automática del rol `ROLE_USER` al registrar nuevos usuarios bajo el principio de mínimo privilegio.
* MySQL 8:** Persistencia mediante Spring Data JPA.

---

## Estructura del Proyecto

```text
src/main/java/com/ejemplo/jwtmysql/
├── model/
│   └── AppUser.java            # Entidad JPA mapeada a la tabla app_users
├── repository/
│   └── UserRepository.java     # Repositorio Spring Data JPA
├── security/
│   └── SecurityConfig.java     # Configuración de filtros, BCrypt y rutas protegidas
├── service/
│   └── TokenService.java       # Generación y validación de tokens JWT
├── web/
│   ├── AuthController.java     # Endpoints públicos de registro y login (/api/auth/*)
│   └── SecuredController.java  # Endpoints protegidos por autenticación (/api/secured)
└── JwtmysqlApplication.java    # Clase principal de arranque

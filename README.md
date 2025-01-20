# ForoHub

ForoHub es una API REST desarrollada con Spring Boot para gestionar tópicos en un foro. Proporciona funcionalidades CRUD completas, integración con una base de datos MySQL y utiliza autenticación basada en JWT para garantizar la seguridad.

---

## **Características principales**

- CRUD completo para gestionar tópicos.
- Autenticación y autorización mediante JWT.
- Validaciones para entradas de datos con Spring Validation.
- Integración de base de datos MySQL con migraciones manejadas por Flyway.
- Desarrollo basado en las mejores prácticas de diseño REST.

---

## **Requisitos previos**

1. Java 17 o superior.
2. Maven 3.6 o superior.
3. MySQL 8.0 o superior.
4. Un cliente API como Postman para probar los endpoints.

---

## **Configuración del proyecto**

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/ForoHub.git
   cd ForoHub
   ```

2. Configura la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=validate
   ```

3. Ejecuta las migraciones de Flyway al iniciar la aplicación para configurar la base de datos.

4. Construye y ejecuta la aplicación:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## **Endpoints principales**

### **Autenticación**
- **POST** `/login`
  - **Descripción:** Genera un token JWT para acceder a los demás endpoints.
  - **Entradas:**
    ```json
    {
      "username": "usuario",
      "password": "contraseña"
    }
    ```
  - **Salidas:**
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIs..."
    }
    ```

### **Tópicos**
- **GET** `/topicos`
  - Devuelve una lista de tópicos disponibles. Requiere autenticación.

- **POST** `/topicos`
  - Crea un nuevo tópico. Requiere autenticación.
  - **Validaciones:**
    - `idDeUsuario` valor numerico.
    - `mensaje` no puede estar vacío.
    - `nombreDelCurso` debe tener entre 5 y 100 caracteres.
    - `titulo` no puede estar vacío.

- **PUT** `/topicos/{id}`
  - Actualiza un tópico existente. Requiere autenticación.
    -  `id` valor numerico.
    - `mensaje` no puede estar vacío.
    - `nombreDelCurso` debe tener entre 5 y 100 caracteres.
    - `titulo` no puede estar vacío.

- **DELETE** `/topicos/{id}`
  - Elimina un tópico existente. Requiere autenticación.
    -  `id` valor numerico.

---

## **Validaciones de seguridad**

1. **Autenticación JWT:**
   - Todos los endpoints (excepto `/login`) están protegidos mediante un filtro de seguridad que verifica la validez del token JWT.
   - Los tokens se generan al iniciar sesión y tienen un tiempo de expiración configurable.

2. **Encriptación de contraseñas:**
   - Las contraseñas de los usuarios se almacenan de forma segura en la base de datos utilizando BCrypt.

3. **Restricciones de acceso:**
   - Solo los usuarios autenticados pueden acceder a los endpoints protegidos.
   - El servidor devuelve un código de estado `401 Unauthorized` si no se proporciona un token válido o este ha expirado.

4. **Validaciones de entrada:**
   - Los datos enviados en las solicitudes son validados mediante anotaciones como `@NotNull`, `@Size`, y `@Email` en los DTOs.
   - Si los datos no cumplen las reglas de validación, se devuelve un código de estado `400 Bad Request` con detalles del error.

---

## **Uso de la API**

1. **Obtener un token JWT:**
   - Envía una solicitud `POST` al endpoint `/login` con credenciales válidas.
   - Guarda el token recibido para usarlo en las siguientes solicitudes.

2. **Acceder a endpoints protegidos:**
   - Añade el token JWT en el encabezado de cada solicitud:
     ```
     Authorization: Bearer <tu_token>
     ```

3. **Crear un tópico:**
   - Envía una solicitud `POST` al endpoint `/topicos` con el siguiente cuerpo:
     ```json
     {
       "titulo": "Título del tópico",
       "mensaje": "Contenido del mensaje"
     }
     ```

4. **Actualizar un tópico:**
   - Envía una solicitud `PUT` al endpoint `/topicos/{id}` con el nuevo contenido del tópico.

5. **Eliminar un tópico:**
   - Envía una solicitud `DELETE` al endpoint `/topicos/{id}`.

---

## **Tecnologías utilizadas**

- **Backend:** Spring Boot, Spring Security, Spring Data JPA.
- **Base de datos:** MySQL, Flyway.
- **Dependencias adicionales:** Lombok, Java JWT.


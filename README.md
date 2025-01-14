# Proyecto realizado con ONE - Oracle Next Education
# # ForoHub - Desafío con Spring Framework
-Programador BackEnd: **Franco Robles**

-Estudiante en **AluraLatam+Oracle**

## Descripción
En este desafío, construiremos una API RESTful utilizando Spring que permita a los usuarios realizar las siguientes operaciones sobre los Topicos:

-   Crear uno nuevo
-   Obtener todos
-   Obtener uno por ID
-   Actualizar
-   Eliminar

## Requisitos
- **Java 23**
- **Spring Boot 3.3.5**
- **PostgreSQL**
- **Postman**

### Dependencias utilizadas 
- **spring-boot-starter-data-jpa**
- **spring-boot-starter-security**
- **spring-boot-starter-validation**
- **spring-boot-starter-web**
- **flyway-core**
- **flyway-database-postgresql**
- **spring-boot-devtools**
- **postgresql**
- **Lombok**
- **spring-boot-starter-test**
- **java-jwt**

## Instalación
1. Clonar el repositorio.
   ```sh
    git clone https://github.com/franco-robles/challengeForoHub.git
    ```
2. Configurar la base de datos PostgreSQL.
3. Ejecutar el proyecto con Spring Boot.


## Funcionalidades del Controlador de Tópicos

El `TopicoController` en el proyecto ForoHub proporciona varias funcionalidades clave para manejar los tópicos en la plataforma. Aquí se describen las principales:

### 1. Añadir Nuevo Tópico

**Endpoint:** `/topico/addTopico`  
**Método HTTP:** `POST`  
**Descripción:** Añade un nuevo tópico a la plataforma.  
**Datos de Entrada:** `TopicoNew` - Objeto que contiene la información del nuevo tópico.  
**Respuesta:** `ResponseEntity<Topico>` - Retorna el tópico añadido con éxito.

### 2. Ver Todos los Tópicos

**Endpoint:** `/topico/viewAll`  
**Método HTTP:** `GET`  
**Descripción:** Obtiene la lista de todos los tópicos disponibles en la plataforma.  
**Respuesta:** `ResponseEntity<List<TopicoDto>>` - Lista de todos los tópicos.

### 3. Ver Detalles de un Tópico

**Endpoint:** `/topico/{id}`  
**Método HTTP:** `GET`  
**Descripción:** Obtiene los detalles de un tópico específico por su ID.  
**Datos de Entrada:** `id` - ID del tópico.  
**Respuesta:** `ResponseEntity<TopicoDto>` - Detalles del tópico solicitado.

### 4. Actualizar un Tópico

**Endpoint:** `/topico/update`  
**Método HTTP:** `PUT`  
**Descripción:** Actualiza un tópico existente en la plataforma.  
**Datos de Entrada:** `Topico` - Objeto que contiene la información actualizada del tópico.  
**Respuesta:** `ResponseEntity<TopicoDto>` - Retorna el tópico actualizado.

### 5. Eliminar un Tópico

**Endpoint:** `/topico/{id}`  
**Método HTTP:** `DELETE`  
**Descripción:** Elimina un tópico de la plataforma por su ID.  
**Datos de Entrada:** `id` - ID del tópico.  
**Respuesta:** `ResponseEntity` - Respuesta vacía con estado no contenido si la eliminación fue exitosa.

## Funcionalidades del Controlador de Usuarios

El `UsuarioController` en el proyecto ForoHub proporciona varias funcionalidades clave para manejar los usuarios en la plataforma. Aquí se describen las principales:

### 1. Registrar Nuevo Usuario

**Endpoint:** `/usuario/newUser`  
**Método HTTP:** `POST`  
**Descripción:** Registra un nuevo usuario en la plataforma.  
**Datos de Entrada:** `UsuarioDto` - Objeto que contiene la información del nuevo usuario.  
**Respuesta:** `ResponseEntity<Usuario>` - Retorna el usuario registrado con éxito.

### 2. Ver Detalles del Usuario con sus Tópicos

**Endpoint:** `/usuario/{id}`  
**Método HTTP:** `GET`  
**Descripción:** Obtiene los detalles de un usuario específico junto con sus tópicos creados por su ID.  
**Datos de Entrada:** `id` - ID del usuario.  
**Respuesta:** `ResponseEntity<UsuarioAllOwnTopicos>` - Detalles del usuario solicitado y sus tópicos asociados.

## Funcionalidades del Controlador de Autenticación

El `AutenticacionController` en el proyecto ForoHub proporciona la funcionalidad clave para autenticar a los usuarios en la plataforma. Aquí se describen las principales:

### 1. Autenticar Usuario

**Endpoint:** `/login`  
**Método HTTP:** `POST`  
**Descripción:** Autentica a un usuario en la plataforma.  
**Datos de Entrada:** `DatosAutenticacionUsuario` - Objeto que contiene la información de autenticación del usuario (login y clave).  
**Respuesta:** `ResponseEntity<DatosJWTToken>` - Retorna un token JWT para el usuario autenticado.

## Uso
1. Ejecutar la aplicación.
2. crear un usuario en el endPoint http://localhost:8080/login 
3. Iniciar sesion con la contraseña y el correo para obtener el Token
4. Usar el token para poder probrar cada EndPoint 

## Contribuciones
Los comentario y criticas son bienvenidas.

# Gracias a ![oracle + alura](screenshot/OracleAlura.png) por la oportunidad.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

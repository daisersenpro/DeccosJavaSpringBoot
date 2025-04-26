# Tienda Web Deccos – Taller Patrones de Diseño

Proyecto de tienda web desarrollado en **Java** con **Spring Boot**, como parte del **Taller de Patrones de Diseño (Unidad 2)**.

El objetivo es aplicar patrones de diseño para construir una aplicación **robusta, flexible y mantenible**, integrando menús dinámicos, productos, usuarios y seguridad.

---

## Explicación del proyecto

Este proyecto implementa una tienda web con las siguientes características principales:

- **Menú de navegación dinámico** utilizando el patrón **Composite**, permitiendo submenús y categorías cargadas desde la base de datos.
- **Gestión de productos y avisos** aplicando el patrón **Adapter/Assembler**, para transformar datos de distintas fuentes en objetos uniformes para la vista.
- **Manejo de usuario anónimo** con el patrón **Null Object**, evitando errores cuando no hay usuario autenticado y mostrando siempre un nombre de usuario.
- **Autenticación de usuarios** con **Spring Security**, permitiendo inicio y cierre de sesión y mostrando información personalizada.
- **Base de datos H2** en memoria, que se carga automáticamente con datos de ejemplo al iniciar la aplicación.
- **Vistas dinámicas** con **Thymeleaf**, mostrando menús, productos y usuarios de forma personalizada.

Este enfoque permitió cumplir con los requisitos del taller, aplicar buenas prácticas de diseño y lograr una aplicación web funcional y fácil de mantener.

---

## Características principales

- Menú de navegación dinámico (**Composite**)
- Gestión de productos y avisos (**Adapter/Assembler**)
- Manejo de usuario anónimo (**Null Object**)
- Autenticación de usuarios con **Spring Security**
- Base de datos **H2** en memoria para pruebas y desarrollo rápido
- Vistas dinámicas con **Thymeleaf** y **Bootstrap**

---

## Patrones de diseño aplicados

- **Composite:** Estructura jerárquica del menú de navegación.
- **Adapter/Assembler:** Transformación y presentación de productos/avisos.
- **Null Object:** Representación segura de usuarios no autenticados.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- H2 Database (en memoria)
- Thymeleaf
- Bootstrap

---

## Cómo ejecutar el proyecto

```bash
git clone <URL-del-repositorio>
cd nombre-del-proyecto
./mvnw spring-boot:run

# Acceder a la aplicación en el navegador:
http://localhost:8080/

# Usuarios de prueba:
# Usuario: jperez@123.cl  Contraseña: 1234
# Usuario: asoto@123.cl   Contraseña: 4321

# Notas:
# - La base de datos H2 se carga automáticamente con datos de ejemplo al iniciar la aplicación.
# - Puedes acceder a la consola de H2 aquí:
http://localhost:8080/h2-console

# Datos de conexión H2:
# JDBC URL: jdbc:h2:mem:tiendadb
# Usuario: sa
# Contraseña: (vacía)

# Autor:
# Anyelo Bustos G.
# Ingeniería Informática

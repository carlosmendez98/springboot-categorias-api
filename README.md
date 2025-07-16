# Spring Boot Categorías API

Este proyecto es una API REST construida con Spring Boot que permite gestionar entidades de tipo `Categoría`. Permite realizar operaciones CRUD (crear, leer, actualizar y eliminar), buscar por nombre de categoría y manejar errores de forma robusta mediante excepciones personalizadas y validaciones con anotaciones `@Valid`.

## ✨ Características principales

- 📦 Arquitectura en capas con DTOs y mapeo entre entidades y objetos de transferencia.
- ✅ Validación de entradas con `@Valid` y `MethodArgumentNotValidException`.
- ❗ Manejo de excepciones personalizado con mensajes detallados.
- 💾 Conexión a base de datos PostgreSQL usando Spring Data JPA.
- 🔍 Búsqueda de categorías por nombre.
- 📄 Documentación básica con README.
- 🧪 Proyecto ideal para pruebas y aprendizaje de buenas prácticas con Spring Boot.

## 🧱 Estructura del modelo `Categoria`

```java
private Long id;
private String nombre;
private String descripcion;

⚙️ Tecnologías usadas
Java 17+

Spring Boot

Spring Data JPA

PostgreSQL

Maven

MapStruct

Bean Validation (@Valid)

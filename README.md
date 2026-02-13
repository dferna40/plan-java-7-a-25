# Plan Java 7/8 → Java 25 (híbrido: Katas + Mini-API)

Este repositorio documenta y contiene mi plan práctico de actualización desde Java 7/8 hasta Java 25, dedicando sesiones cortas (≈ 1h/día) con un enfoque 100% orientado a construir y practicar:

- **Katas (Java puro + tests)** para dominar Java moderno (Streams, Optional, java.time, colecciones, etc.).
- **Mini-API (Spring Boot)** para aplicar lo aprendido en un proyecto real (REST, validación, errores, tests, etc.).

La idea es que el repositorio sea **ejecutable**, **revisable** y útil como **portfolio** y como preparación para entrevistas.

---

## Estructura del repositorio

- `katas/`  
  Ejercicios de Java puro organizados por **semana/día**. Cada día es un módulo Maven independiente (por ejemplo `plan_s01_d01`), con:
  - `src/main/java` (soluciones)
  - `src/test/java` (tests JUnit)
  - `README.md` del día con objetivos y ejecución

- `api/`  
  Proyecto(s) Spring Boot (mini-API) donde se irán incorporando funcionalidades gradualmente para consolidar lo aprendido.

---

## Requisitos

- **JDK**: Java 8+ (en estas primeras katas el nivel de compilación está en **1.8**)
- **Maven**: 3.x
- IDE recomendado: **Eclipse / Spring Tools Suite (STS)**

> Nota: aunque el objetivo final es llegar a Java 25, la progresión será gradual por hitos (8 → 11 → 17 → 21 → 25).

---

## Cómo ejecutar

### Katas (multi-módulo Maven)
Desde la carpeta `katas/` puedes ejecutar un día concreto:

```bash
mvn -pl plan_s01_d01 test

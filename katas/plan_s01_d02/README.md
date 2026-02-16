# Semana 1 — Día 2 (Streams: sort/distinct/min-max) — Java 8

## Objetivo
Practicar Streams en Java 8 para:
- Ordenar listas con `sorted()` usando `Comparator` (orden múltiple).
- Eliminar duplicados con `distinct()` manteniendo el orden.
- Obtener mínimo y máximo sin bucles con `IntSummaryStatistics`.

## Ejercicios
Implementados en `StreamsKata` con tests en `StreamsKataTest`:

1. **sortByLastNameThenFirstName(List<String>)**
   - Ordena por apellido y luego por nombre.

2. **distinctPreserveOrder(List<String>)**
   - Quita duplicados manteniendo el orden de primera aparición.

3. **minMaxStats(List<Integer>)**
   - Devuelve estadísticas (min/max, y más) con `IntSummaryStatistics` dentro de `Optional`.
   - Si la lista es `null` o está vacía, devuelve `Optional.empty()`.

## Notas Java 8 (importante)
- `List.of(...)` **NO existe** en Java 8 → usa `Arrays.asList(...)`.
- `Optional.isEmpty()` **NO existe** en Java 8 → usa `isPresent()` / `!isPresent()`.

## Estructura
- `src/main/java/com/david/plan/s01/d02/StreamsKata.java`
- `src/test/java/com/david/plan/s01/d02/StreamsKataTest.java`

## Cómo ejecutar
### Desde terminal (Maven)
En la carpeta `katas` (padre):
```bash
mvn -pl plan_s01_d02 test

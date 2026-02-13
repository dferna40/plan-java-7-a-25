# Semana 1 — Día 1 (Streams básicos)

## Objetivo
Practicar operaciones básicas de Streams en Java:
- `filter` (filtrar elementos)
- `map` (transformar elementos)
- `sorted` (ordenar)
- `collect(toList())` (materializar el resultado en una lista)

## Ejercicios
Implementados en la clase `StreamsKata` con tests en `StreamsKataTest`:

1. **onlyEvens(List<Integer>)**
   - Devuelve una lista con solo los números pares.

2. **upperTrim(List<String>)**
   - Hace `trim()` a cada string y lo convierte a mayúsculas.

3. **normalizeAndSort(List<String>, int minLen)**
   - Filtra por longitud mínima (`minLen`)
   - Convierte a minúsculas
   - Ordena alfabéticamente
   - Devuelve la lista resultante

## Estructura
- `src/main/java/com/david/plan/s01/d01/StreamsKata.java`
- `src/test/java/com/david/plan/s01/d01/SmokeTest.java`
- `src/test/java/com/david/plan/s01/d01/StreamsKataTest.java`

## Cómo ejecutar
### Desde terminal (Maven)
En la carpeta `katas` (padre):
```bash
mvn -pl plan_s01_d01 test

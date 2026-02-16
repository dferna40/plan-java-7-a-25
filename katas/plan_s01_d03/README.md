# Semana 1 — Día 3 (Collectors: groupingBy) — Java 8

## Objetivo
Practicar `Collectors` para agrupar y resumir datos:
- `groupingBy` para agrupar por una clave
- `counting` para contar elementos por grupo
- `mapping` como downstream collector para transformar elementos dentro del grupo

## Ejercicios
Implementados en la clase `CollectorsGroupingByKata` con tests en `CollectorsGroupingByKataTest`:

1. **countByName(List<String> names)**
   - Devuelve un mapa con el número de veces que aparece cada nombre.

2. **countEmailsByDomain(List<String> emails)**
   - Devuelve un mapa con el número de emails por dominio (normalizado a minúsculas).
   - Ignora emails inválidos (nulos, vacíos o sin '@' válido).

3. **groupUppercaseNamesByLength(List<String> names)**
   - Agrupa por longitud y guarda los nombres en MAYÚSCULAS.
   - Debe usar `groupingBy(..., mapping(..., toList()))`.

## Estructura
- `src/main/java/com/david/plan/s01/d03/CollectorsGroupingByKata.java`
- `src/test/java/com/david/plan/s01/d03/CollectorsGroupingByKataTest.java`

## Cómo ejecutar
### Desde terminal (Maven)
En la carpeta `katas` (padre):
```bash
mvn -pl plan_s01_d03 test

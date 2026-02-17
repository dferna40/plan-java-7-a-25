package com.david.plan.s01.d03;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Semana 1 Día 3 (Java 8)
 *
 * En esta kata practicas Collectors avanzados:
 * - groupingBy: agrupar elementos en un Map por una clave.
 * - counting: contar cuántos elementos hay en cada grupo.
 * - mapping (downstream): transformar cada elemento antes de guardarlo en el grupo.
 */
public class CollectorsGroupingByKata {

    /**
     * Devuelve un mapa con el conteo de apariciones por nombre.
     * Ej: ["Ana","Luis","Ana"] -> {"Ana":2,"Luis":1}
     */
    public Map<String, Long> countByName(List<String> names) {

        // names.stream()
        // 1) Convertimos la lista a Stream para procesar sus elementos con operaciones funcionales.
        //
        // collect(...)
        // 2) Construimos el resultado final (un Map) a partir del stream.
        //
        // Collectors.groupingBy(n -> n, Collectors.counting())
        // 3) groupingBy:
        //    - clave (key): n -> n   (la clave es el propio nombre)
        //    - downstream: counting() (cuenta cuántos elementos hay por cada clave)
        //
        // Resultado:
        // - "Ana"  -> 2
        // - "Luis" -> 1
        Map<String, Long> prueba =
                names.stream()
                     .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // Esto es opcional: sirve para depurar/imprimir el resultado.
        // prueba.forEach((nombre, cantidad) ->
        //     System.out.println(nombre + " aparece " + cantidad + " veces"));

        // 4) Devolvemos el mapa ya construido.
        return prueba;
    }

    /**
     * Devuelve el conteo de emails por dominio (parte después de '@').
     *
     * Reglas:
     * - Ignorar emails null o vacíos/solo espacios
     * - Ignorar si no contiene '@' válido o está al final (ej: "ana@")
     * - Dominio en minúsculas
     */
    public Map<String, Long> countEmailsByDomain(List<String> emails) {

        // Aquí se hace un pipeline de Stream: filtrar -> transformar -> agrupar y contar.
        Map<String, Long> prueba =
                emails.stream()

                      // 1) Ignora null para evitar NullPointerException en pasos posteriores.
                      .filter(e -> e != null)

                      // 2) Quita espacios al inicio/fin: "  maria@YAHOO.es  " -> "maria@YAHOO.es"
                      .map(String::trim)

                      // 3) Elimina emails vacíos (incluye "   " tras el trim).
                      .filter(e -> !e.isEmpty())

                      // 4) Asegura que haya un '@' en el texto.
                      .filter(e -> e.contains("@"))

                      // 5) Evita el caso "ana@" (no hay dominio).
                      .filter(e -> !e.endsWith("@"))

                      // 6) Evita el caso "@dominio.com" (no hay usuario).
                      .filter(e -> !e.startsWith("@"))

                      // 7) Extrae el dominio: parte después del '@'
                      //    "ana@gmail.com" -> "gmail.com"
                      .map(e -> e.substring(e.indexOf("@") + 1))

                      // 8) Normaliza el dominio a minúsculas:
                      //    "GMAIL.com" y "gmail.com" cuentan como el mismo dominio.
                      .map(String::toLowerCase)

                      // 9) Agrupa por dominio (key = el propio dominio) y cuenta.
                      .collect(Collectors.groupingBy(d -> d, Collectors.counting()));

        // Depuración: imprime el resultado por consola.
        // Ejemplo: "gmail.com aparece 2 veces"
        prueba.forEach((dominio, cantidad) ->
                System.out.println(dominio + " aparece " + cantidad + " veces"));

        // Devolvemos el mapa final.
        return prueba;
    }

    /**
     * Agrupa nombres por longitud y guarda los nombres en MAYÚSCULAS dentro de cada grupo.
     *
     * Debe usar downstream collector:
     * groupingBy(key, mapping(..., toList()))
     *
     * Ej: ["Ana","Luis","Pepe"] -> {3:["ANA"],4:["LUIS","PEPE"]}
     */
    public Map<Integer, List<String>> groupUppercaseNamesByLength(List<String> names) {

        // names.stream()
        // 1) Convertimos la lista a Stream para procesarla.
        //
        // collect(groupingBy(...))
        // 2) Construimos un Map<Integer, List<String>>:
        //    - key   = longitud del nombre
        //    - value = lista de nombres (en mayúsculas) que tengan esa longitud
        //
        // groupingBy(String::length, mapping(String::toUpperCase, toList()))
        // 3) key (clave):
        //    String::length -> para cada nombre calcula su longitud (Integer)
        //
        // 4) downstream (lo que pasa "dentro del grupo"):
        //    mapping(String::toUpperCase, toList())
        //    - transforma cada nombre a MAYÚSCULAS
        //    - y los mete en una lista dentro de su grupo
        //
        // Ejemplo:
        // "Ana"  -> length 3 -> se guarda como "ANA" en el grupo 3
        // "Luis" -> length 4 -> se guarda como "LUIS" en el grupo 4
        Map<Integer, List<String>> prueba =
                names.stream()
                     .collect(Collectors.groupingBy(
                             String::length,
                             Collectors.mapping(String::toUpperCase, Collectors.toList())
                     ));

        // Depuración: imprime cada grupo.
        // OJO: aquí los nombres de variables podrían confundir:
        // - "cantidad" realmente es la longitud (key)
        // - "nombre" realmente es la lista de nombres (value)
        prueba.forEach((cantidad, nombre) ->
                System.out.println("Grupo de nombres: " + nombre + " con " + cantidad + " caracteres."));

        // Devolvemos el mapa final.
        return prueba;
    }
}

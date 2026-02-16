package com.david.plan.s01.d03;

import java.util.List;
import java.util.Map;

/**
 * Semana 1 Día 3 (Java 8)
 * Práctica de Collectors: groupingBy + counting + mapping (downstream collectors).
 */
public class CollectorsGroupingByKata {

    /**
     * Devuelve un mapa con el conteo de apariciones por nombre.
     * Ej: ["Ana","Luis","Ana"] -> {"Ana":2,"Luis":1}
     */
    public Map<String, Long> countByName(List<String> names) {
        // TODO: Implementar con Streams + Collectors.groupingBy + Collectors.counting
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Devuelve el conteo de emails por dominio (parte después de '@').
     * Reglas:
     * - Ignorar emails null o vacíos/solo espacios
     * - Ignorar si no contiene '@' válido o está al final (ej: "ana@")
     * - Dominio en minúsculas
     */
    public Map<String, Long> countEmailsByDomain(List<String> emails) {
        // TODO: Implementar con Streams + limpieza/filtrado + groupingBy + counting
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Agrupa nombres por longitud y guarda los nombres en MAYÚSCULAS dentro de cada grupo.
     * Debe usar downstream collector: groupingBy(key, mapping(..., toList())).
     * Ej: ["Ana","Luis","Pepe"] -> {3:["ANA"],4:["LUIS","PEPE"]}
     */
    public Map<Integer, List<String>> groupUppercaseNamesByLength(List<String> names) {
        // TODO: Implementar con Collectors.groupingBy + Collectors.mapping + Collectors.toList
        throw new UnsupportedOperationException("TODO");
    }
}

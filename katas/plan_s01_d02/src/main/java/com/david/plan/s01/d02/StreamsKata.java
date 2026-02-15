package com.david.plan.s01.d02;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

/**
 * Semana 1 Día 2 (Java 8)
 * Practica Streams: sorted/distinct y min/max (summaryStatistics).
 */
public class StreamsKata {

    /**
     * Ordena una lista de nombres completos ("Nombre Apellido") por:
     * 1) Apellido (asc)
     * 2) Nombre (asc) si hay empate
     *
     * Ejemplo: ["Luis Pérez", "Ana Ruiz", "Ana Pérez"] -> ["Ana Pérez", "Luis Pérez", "Ana Ruiz"]
     */
    public List<String> sortByLastNameThenFirstName(List<String> fullNames) {
        // TODO: implementar con stream().sorted(Comparator...).collect(toList())
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Devuelve la lista sin duplicados, manteniendo el orden de primera aparición.
     *
     * Ejemplo: ["Ana", "Luis", "Ana"] -> ["Ana", "Luis"]
     */
    public List<String> distinctPreserveOrder(List<String> input) {
        // TODO: implementar con stream().distinct().collect(toList())
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Devuelve estadísticas (min/max entre otras) usando IntSummaryStatistics.
     * - Optional.empty() si numbers es null o está vacía
     * - Optional.of(stats) si hay elementos
     */
    public Optional<IntSummaryStatistics> minMaxStats(List<Integer> numbers) {
        // TODO: si null/vacía -> Optional.empty()
        // TODO: si hay datos -> numbers.stream().mapToInt(...).summaryStatistics()
        throw new UnsupportedOperationException("TODO");
    }
}

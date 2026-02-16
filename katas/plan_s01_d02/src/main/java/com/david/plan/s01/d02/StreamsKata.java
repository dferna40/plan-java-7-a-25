package com.david.plan.s01.d02;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Semana 1 Día 2 (Java 8)
 * Practica Streams:
 * - sorted() (ordenación)
 * - distinct() (eliminar duplicados)
 * - summaryStatistics() (min/max y más)
 */
public class StreamsKata {

    /**
     * Ordena una lista de nombres completos ("Nombre Apellido") por:
     * 1) Apellido (asc)
     * 2) Nombre (asc) si hay empate
     *
     * Ejemplo:
     * ["Luis Pérez", "Ana Ruiz", "Ana Pérez"]
     * -> ["Ana Pérez", "Luis Pérez", "Ana Ruiz"]
     */
    public List<String> sortByLastNameThenFirstName(List<String> fullNames) {

        // 1) Convertimos la lista en un Stream (cadena de operaciones)
        return fullNames.stream()

                // 2) Ordenamos el stream usando un Comparator personalizado
                .sorted(
                    // Comparator.comparing(...) define el criterio principal de orden
                    // Aquí el criterio principal es el APELLIDO:
                    // - s.split(" ")[1] significa: parte 1 tras separar "Nombre Apellido"
                    //   Ej: "Ana Pérez" -> ["Ana", "Pérez"] -> apellido = "Pérez"
                    Comparator.comparing((String s) -> s.split(" ")[1])

                        // thenComparing(...) define el criterio secundario si hay empate
                        // Si dos personas tienen el mismo apellido, ordenamos por NOMBRE:
                        // - s.split(" ")[0] = nombre
                        .thenComparing(s -> s.split(" ")[0])
                )

                // 3) Volvemos a convertir el Stream en List
                .collect(Collectors.toList());
    }

    /**
     * Devuelve la lista sin duplicados, manteniendo el orden de primera aparición.
     *
     * Ejemplo:
     * ["Ana", "Luis", "Ana"] -> ["Ana", "Luis"]
     */
    public List<String> distinctPreserveOrder(List<String> input) {

        // 1) Convertimos la lista en Stream
        return input.stream()

                // 2) distinct() elimina duplicados basándose en equals() y hashCode()
                // Para String esto funciona perfecto.
                // Mantiene el orden en el que apareció la primera vez cada elemento.
                .distinct()

                // 3) Convertimos de nuevo el Stream a List
                .collect(Collectors.toList());
    }

    /**
     * Devuelve estadísticas (min/max entre otras) usando IntSummaryStatistics.
     *
     * Reglas:
     * - Optional.empty() si numbers es null o está vacía
     * - Optional.of(stats) si hay elementos
     */
    public Optional<IntSummaryStatistics> minMaxStats(List<Integer> numbers) {

        // 1) Caso “no hay datos”: la lista es null o está vacía
        // No podemos calcular min/max, así que devolvemos Optional vacío
        if (numbers == null || numbers.isEmpty()) {
            return Optional.empty();
        }

        // 2) Caso “sí hay datos”: calculamos estadísticas
        IntSummaryStatistics stats = numbers.stream()          // Stream<Integer>
                .mapToInt(Integer::intValue)                   // IntStream (Integer -> int)
                .summaryStatistics();                          // calcula min/max/sum/count/avg

        // 3) Devolvemos Optional “con datos”
        return Optional.of(stats);
    }
}

package com.david.plan.s01.d02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Semana 1 Día 2 (Java 8)
 * Tests para sorted/distinct y min/max (summaryStatistics).
 */
class StreamsKataTest {

    private final StreamsKata kata = new StreamsKata();

    @Test
    @DisplayName("sortByLastNameThenFirstName: ordena por apellido y luego por nombre")
    void sortByLastNameThenFirstName_ordersByLastNameThenFirstName() {
        // Java 8: NO List.of(...)
        List<String> input = Arrays.asList(
                "Ana Ruiz",
                "Luis Pérez",
                "Ana Pérez",
                "Pedro Alba",
                "Luis Alba"
        );

        List<String> result = kata.sortByLastNameThenFirstName(input);

        List<String> expected = Arrays.asList(
                "Luis Alba",
                "Pedro Alba",
                "Ana Pérez",
                "Luis Pérez",
                "Ana Ruiz"
        );

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("distinctPreserveOrder: elimina duplicados respetando orden de primera aparición")
    void distinctPreserveOrder_removesDuplicatesKeepingFirstOccurrenceOrder() {
        List<String> input = Arrays.asList("Ana", "Luis", "Ana", "Pedro", "Luis");

        List<String> result = kata.distinctPreserveOrder(input);

        assertEquals(Arrays.asList("Ana", "Luis", "Pedro"), result);
    }

    @Test
    @DisplayName("minMaxStats: devuelve Optional.empty si lista null o vacía; si no, min y max correctos")
    void minMaxStats_handlesNullEmptyAndReturnsCorrectMinMax() {
        Optional<IntSummaryStatistics> nullResult = kata.minMaxStats(null);
        assertFalse(nullResult.isPresent(), "Si es null debe devolver Optional.empty()");

        Optional<IntSummaryStatistics> emptyResult = kata.minMaxStats(Arrays.asList());
        assertFalse(emptyResult.isPresent(), "Si está vacía debe devolver Optional.empty()");

        List<Integer> numbers = Arrays.asList(10, -3, 7, 7, 25, 0);

        Optional<IntSummaryStatistics> result = kata.minMaxStats(numbers);

        assertTrue(result.isPresent(), "Con datos debe devolver Optional con estadísticas");

        IntSummaryStatistics stats = result.get();
        assertEquals(-3, stats.getMin());
        assertEquals(25, stats.getMax());
    }
}

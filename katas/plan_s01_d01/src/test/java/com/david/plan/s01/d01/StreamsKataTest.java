package com.david.plan.s01.d01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class StreamsKataTest {

	@Test
    void filtraSoloPares() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(2, 4, 6);

        assertEquals(expected, StreamsKata.onlyEvens(input));
    }

    @Test
    void transformaAUppercaseYTrim() {
        List<String> input = Arrays.asList("  hola", "mundo  ", " Java ");
        List<String> expected = Arrays.asList("HOLA", "MUNDO", "JAVA");

        assertEquals(expected, StreamsKata.upperTrim(input));
    }

    @Test
    void filtraLongitudMinima_bajaAMinusculas_yOrdena() {
        List<String> input = Arrays.asList("Ana", "Pepe", "Juan", "Lola", "Bea", "David");
        List<String> expected = Arrays.asList("david", "juan", "lola", "pepe");

        assertEquals(expected, StreamsKata.normalizeAndSort(input, 4));
    }

}

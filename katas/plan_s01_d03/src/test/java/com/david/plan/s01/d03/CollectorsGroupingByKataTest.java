package com.david.plan.s01.d03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Semana 1 Día 3 (Java 8)
 * Tests para Collectors: groupingBy + counting + mapping (downstream).
 */
class CollectorsGroupingByKataTest {

    private final CollectorsGroupingByKata kata = new CollectorsGroupingByKata();

    @Test
    @DisplayName("countByName: cuenta apariciones por nombre")
    void countByName_countsOccurrences() {
        List<String> input = Arrays.asList("Ana", "Luis", "Ana", "Pedro", "Luis");

        Map<String, Long> result = kata.countByName(input);

        assertEquals(3, result.size());
        assertEquals(2L, result.get("Ana"));
        assertEquals(2L, result.get("Luis"));
        assertEquals(1L, result.get("Pedro"));
    }

    @Test
    @DisplayName("countByName: lista vacía -> mapa vacío")
    void countByName_emptyList_returnsEmptyMap() {
        List<String> input = Arrays.asList();

        Map<String, Long> result = kata.countByName(input);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("countEmailsByDomain: agrupa por dominio y normaliza a minúsculas")
    void countEmailsByDomain_groupsAndLowercasesDomain() {
        List<String> emails = Arrays.asList(
                "ana@gmail.com",
                "pepe@GMAIL.com",
                "luis@yahoo.es",
                "  maria@YAHOO.es  "
        );

        Map<String, Long> result = kata.countEmailsByDomain(emails);

        assertEquals(2, result.size());
        assertEquals(2L, result.get("gmail.com"));
        assertEquals(2L, result.get("yahoo.es"));
    }

    @Test
    @DisplayName("countEmailsByDomain: ignora nulos, vacíos y formatos inválidos")
    void countEmailsByDomain_ignoresInvalidEmails() {
        List<String> emails = Arrays.asList(
                null,
                "",
                "   ",
                "sinArroba.com",
                "ana@",
                "@dominio.com",
                "ok@dominio.com",
                "otro@dominio.com"
        );

        Map<String, Long> result = kata.countEmailsByDomain(emails);

        assertEquals(1, result.size());
        assertEquals(2L, result.get("dominio.com"));
    }

    @Test
    @DisplayName("groupUppercaseNamesByLength: agrupa por longitud y convierte a MAYÚSCULAS")
    void groupUppercaseNamesByLength_groupsAndUppercases() {
        List<String> names = Arrays.asList("Ana", "Luis", "Pepe", "Sol");

        Map<Integer, List<String>> result = kata.groupUppercaseNamesByLength(names);

        assertEquals(2, result.size());

        assertTrue(result.containsKey(3));
        assertTrue(result.containsKey(4));

        assertEquals(Arrays.asList("ANA", "SOL"), result.get(3));
        assertEquals(Arrays.asList("LUIS", "PEPE"), result.get(4));
    }

    @Test
    @DisplayName("groupUppercaseNamesByLength: lista vacía -> mapa vacío")
    void groupUppercaseNamesByLength_emptyList_returnsEmptyMap() {
        Map<Integer, List<String>> result = kata.groupUppercaseNamesByLength(Arrays.asList());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}

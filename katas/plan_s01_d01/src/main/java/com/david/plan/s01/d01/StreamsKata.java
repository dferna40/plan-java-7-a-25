package com.david.plan.s01.d01;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsKata {

	private StreamsKata() {
	}

	public static List<Integer> onlyEvens(List<Integer> input) {
		return input.stream() // 1) Creo un "stream" para procesar la lista como pipeline de operaciones.
				.filter(n -> n % 2 == 0) // 2) Me quedo solo con los elementos que cumplan la condición: ser par.
				.collect(Collectors.toList()); // 3) Vuelvo a construir una List con el resultado.
	}

	public static List<String> upperTrim(List<String> input) {
		return input.stream() // 1) Fuente: convierto la lista en un stream para aplicar un pipeline.
				.map(s -> s.trim()) // 2) Transformación 1: quito espacios al inicio/fin de cada String.
				.map(s -> s.toUpperCase()) // 3) Transformación 2: paso cada String a mayúsculas.
				.collect(java.util.stream.Collectors.toList()); // 4) Terminal: materializo el resultado en una List.
	}

	public static List<String> normalizeAndSort(List<String> input, int minLen) {
		return input.stream()
				.filter(s -> s.length() >= minLen)
				.map(s -> s.trim())
				.map(s -> s.toLowerCase())
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
	}
}

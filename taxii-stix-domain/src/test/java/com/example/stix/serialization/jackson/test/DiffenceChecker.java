package com.example.stix.serialization.jackson.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class DiffenceChecker {

    private DiffenceChecker() {
        throw new AssertionError("No instances for you!");
    }

    private static Map<String, Object> flatten(Map<String, Object> map) {
        return map.entrySet().stream()
                .flatMap(DiffenceChecker::flatten)
                .collect(LinkedHashMap::new, (m, e) -> m.put("/" + e.getKey(), e.getValue()), LinkedHashMap::putAll);
    }

    private static Stream<Map.Entry<String, Object>> flatten(Map.Entry<String, Object> entry) {

        if (entry == null) {
            return Stream.empty();
        }

        if (entry.getValue() instanceof Map<?, ?>) {
            return ((Map<?, ?>) entry.getValue()).entrySet().stream()
                    .flatMap(e -> flatten(new AbstractMap.SimpleEntry<>(entry.getKey() + "/" + e.getKey(), e.getValue())));
        }

        if (entry.getValue() instanceof List<?>) {
            List<?> list = (List<?>) entry.getValue();
            return IntStream.range(0, list.size())
                    .mapToObj(i -> new AbstractMap.SimpleEntry<String, Object>(entry.getKey() + "/" + i, list.get(i)))
                    .flatMap(DiffenceChecker::flatten);
        }

        return Stream.of(entry);
    }

    public static boolean areEqual(ObjectMapper mapper, String input, String serialized) throws IOException {
        TypeReference<Map<String, Object>> type =
                new TypeReference<Map<String, Object>>() {};

        Map<String, Object> expected = mapper.readValue(input, type);
        Map<String, Object> result = mapper.readValue(serialized, type);

        Map<String, Object> expcetedMap = DiffenceChecker.flatten(expected);
        Map<String, Object> resultMap = DiffenceChecker.flatten(result);

        MapDifference<String, Object> difference = Maps.difference(expcetedMap, resultMap);

        if (!difference.areEqual()) {
            System.out.println("Entries only on the expected\n--------------------------");
            difference.entriesOnlyOnLeft()
                    .forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("\n\nEntries only on the result\n--------------------------");
            difference.entriesOnlyOnRight()
                    .forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("\n\nEntries differing\n--------------------------");
            difference.entriesDiffering()
                    .forEach((key, value) -> System.out.println(key + ": " + value));

            return false;
        }
        return true;
    }
}
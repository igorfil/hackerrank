package HashTables;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/count-triplets-1/problem

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> numbers = new HashMap<>();
        Map<Long, Long> multiplied = new HashMap<>();

        long sum = 0;
        for(int i=arr.size() - 1; i >=0; --i) {
            long nextValue = arr.get(i);
            sum += multiplied.getOrDefault(nextValue * r, 0L);

            Long count = numbers.getOrDefault(nextValue * r, 0L);
            multiplied.computeIfPresent(nextValue, (k,v) -> v + count);
            multiplied.putIfAbsent(nextValue, count);

            numbers.computeIfPresent(nextValue, (k,v) -> v + 1);
            numbers.putIfAbsent(nextValue, 1L);
        }

        return sum;
    }

    @Test
    void test() {
        assertEquals(0, countTriplets(list(1L, 2L, 3L), 2));
        assertEquals(1, countTriplets(list(1L, 2L, 4L), 2));
        assertEquals(2, countTriplets(list(1L, 2L, 2L, 4L), 2));
        assertEquals(6, countTriplets(list(1L, 3L, 9L, 9L, 27L, 81L), 3));
        assertEquals(4, countTriplets(list(1L, 5L, 5L, 25L, 125L), 5));
        assertEquals(161700, countTriplets(Collections.nCopies(100, 1L), 1));
        assertEquals(166661666700000L, countTriplets(Collections.nCopies(100000, 1237L), 1));
    }

    private List<Long> list(Long... items) {
        return Arrays.asList(items);
    }
}

package Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/crush/problem



public class ArrayManipulation {
    long arrayManipulation(int n, int[][] queries) {
        long[] items = new long[n + 1];

        for(int[] query : queries) {
            int first = query[0];
            int last = query[1];
            long delta = query[2];

            items[first] += delta;
            if(last + 1 < items.length) items[last + 1] -=delta;
        }

        long max = 0;
        long current = 0;
        for(int i=0; i<items.length; ++i) {
            current += items[i];
            if(current > max) max = current;
        }

        return max;
    }

    @Test
    void test() {
        assertEquals(100, arrayManipulation(2, queries(createOp(1, 2, 100))));
        assertEquals(200, arrayManipulation(3, queries(createOp(1, 2, 100), createOp(2, 3, 100))));
        assertEquals(200, arrayManipulation(5, queries(
                createOp(1, 2, 100),
                createOp(2, 5, 100),
                createOp(3, 4, 100))));
        assertEquals(10, arrayManipulation(10, queries(
                createOp(1, 5, 3),
                createOp(4, 8, 7),
                createOp(6, 9, 1))));
    }

    private int[][] queries(int[]... ops) {
        return ops;
    }

    private int[] createOp(int a, int b, int k) {
        return new int[] {a, b, k};
    }
}

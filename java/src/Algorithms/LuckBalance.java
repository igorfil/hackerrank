package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/luck-balance/problem

public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {
        int totalLuck = Arrays.stream(contests)
                .mapToInt(contest -> contest[0])
                .sum();

        long importantCount = Arrays.stream(contests)
                .filter(contest -> contest[1] == 1)
                .count();

        int extraLuck = Arrays.stream(contests)
                .filter(contest -> contest[1] == 1)
                .mapToInt(contest -> contest[0])
                .sorted()
                .limit(Math.max(importantCount - k, 0))
                .sum();

        return totalLuck - 2 * extraLuck;
    }

    @Test
    void test() {
        assertEquals(3, luckBalance(1, new int[][]{new int[]{1, 1}, new int[]{2, 0}}));
        assertEquals(7, luckBalance(2, new int[][]{new int[]{1, 1}, new int[]{2, 0}, new int[]{2, 1}, new int[]{4, 1}}));
        assertEquals(29, luckBalance(3, new int[][]{new int[]{5, 1}, new int[]{2, 1}, new int[]{1, 1}, new int[]{8, 1}, new int[]{10, 0}, new int[]{5, 0}}));
        assertEquals(42, luckBalance(5, new int[][]{new int[]{13, 1}, new int[]{10, 1}, new int[]{9, 1}, new int[]{8, 1}, new int[]{13, 1}, new int[]{12, 1}, new int[]{18, 1}, new int[]{13, 1}}));
    }
}

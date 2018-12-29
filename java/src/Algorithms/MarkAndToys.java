package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/mark-and-toys/problem

public class MarkAndToys {
    int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);

        int left = k;
        int toys = 0;
        for (int price : prices) {
            if (price < left) {
                left -= price;
                ++toys;
            }
        }

        return toys;
    }

    @Test
    void test() {
        assertEquals(0, maximumToys(new int[]{1, 2, 3}, 0));
        assertEquals(3, maximumToys(new int[]{1, 2, 3}, 100));
        assertEquals(3, maximumToys(new int[]{1, 2, 3, 5, 10}, 7));
    }
}

package Algorithms;

// https://www.hackerrank.com/challenges/sock-merchant/problem

// Function  must return an integer representing the number
// of matching pairs of socks that are available.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        boolean[] matches = new boolean[101];

        int pairs = 0;
        for(int sock : ar) {
            if(matches[sock]) ++pairs;
            matches[sock] = !matches[sock];
        }

        return pairs;
    }

    @Test
    public void test_HackerrankTests() {
        assertEquals(3, sockMerchant(9, new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}));
        assertEquals(30, sockMerchant(100, new int[] {44, 55, 11, 15, 4, 72, 26, 91, 80, 14, 43, 78, 70, 75,
                36, 83, 78, 91, 17, 17, 54, 65, 60, 21, 58, 98, 87, 45, 75, 97, 81, 18, 51, 43, 84, 54, 66, 10, 44, 45,
                23, 38, 22, 44, 65, 9, 78, 42, 100, 94, 58, 5, 11, 69, 26, 20, 19, 64, 64, 93, 60, 96, 10, 10, 39, 94,
                15, 4, 3, 10, 1, 77, 48, 74, 20, 12, 83, 97, 5, 82, 43, 15, 86, 5, 35, 63, 24, 53, 27, 87, 45, 38, 34, 7,
                48, 24, 100, 14, 80, 54}));
    }
}


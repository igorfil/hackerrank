package Arrays;

// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];

        for(int i=0; i<a.length; ++i) {
            result[i] = a[(i + d) % a.length];
        }

        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] {5, 1, 2, 3, 4}, rotLeft(new int[] {1, 2, 3, 4, 5}, 4));
    }
}

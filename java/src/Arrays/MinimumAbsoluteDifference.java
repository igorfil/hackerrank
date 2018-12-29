package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem

public class MinimumAbsoluteDifference {
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; ++i) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            if (diff == 0) {
                return diff;
            }

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    @Test
    void test() {
        assertEquals(0, minimumAbsoluteDifference(new int[]{1, 1}));
        assertEquals(1, minimumAbsoluteDifference(new int[]{1, 2, 10}));
        assertEquals(0, minimumAbsoluteDifference(new int[]{1, 20, 100, 100, 500}));
    }
}

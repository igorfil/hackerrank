package Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem

// Function must return an integer representing the minimum number of swaps to sort the array.

public class MinimumSwaps {

    public int minimumSwaps(int... arr) {
        int swaps = 0;

        for(int current=0; current<arr.length; ) {
            if(!inPlace(arr, current)) {
                ++swaps;
                swapInPlace(arr, current);
            } else {
                ++current;
            }
        }

        return swaps;
    }

    private void swapInPlace(int[] arr, int index) {
        int newIndex = arr[index] - 1;
        int tmp = arr[newIndex];
        arr[newIndex] = arr[index];
        arr[index] = tmp;
    }

    private boolean inPlace(int[] arr, int index) {
        return arr[index] == index + 1;
    }

    @Test
    public void test(){
        assertEquals(0, minimumSwaps(1));
        assertEquals(0, minimumSwaps(1, 2));
        assertEquals(1, minimumSwaps(2, 1));
        assertEquals(1, minimumSwaps(2, 1, 3));
        assertEquals(1, minimumSwaps(3, 2, 1));
        assertEquals(0, minimumSwaps(1, 2, 3));
        assertEquals(3, minimumSwaps(4, 3, 1, 2));
        assertEquals(3, minimumSwaps(2, 3, 4, 1, 5));
    }

}

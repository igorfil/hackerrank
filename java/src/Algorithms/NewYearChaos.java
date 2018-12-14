package Algorithms;

// https://www.hackerrank.com/challenges/new-year-chaos/problem

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/new-year-chaos/problem

// Fuction must print an integer representing the minimum number of bribes necessary,
// or Too chaotic if the line configuration is not possible.
public class NewYearChaos {

    static String minimumBribes(int[] q) {
        int bribes = 0;
        for(int i=q.length - 1; i>=0; --i) {
            int positionDiff = q[i] - i - 1;

            if(positionDiff > 2) {
                return "Too chaotic";
            }
            for(int j = Integer.max(0, q[i] - 2); j<i; ++j){
                if(q[j] > q[i]) ++bribes;
            }
        }

        return String.valueOf(bribes);
    }

    @Test
    public void test() {
        assertEquals("3", minimumBribes(new int[] {2, 1, 5, 3, 4}));
        assertEquals("Too chaotic", minimumBribes(new int[] {2, 5, 1, 3, 4}));
        assertEquals("Too chaotic", minimumBribes(new int[] {5, 1, 2, 3, 7, 8, 6, 4}));
        assertEquals("7", minimumBribes(new int[] {1, 2, 5, 3, 7, 8, 6, 4}));
    }
}

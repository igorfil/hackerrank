package Algorithms;

// https://www.hackerrank.com/challenges/counting-valleys/problem

// Function must return an integer that denotes the number of valleys Gary traversed.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingValleys {
    // walk the array
    // count current level at each step (-1 for down +1 for up)
    // if got to 0 by going up, means left valley
    static int getStepDelta(final char step) {
        switch (step){
            case 'U': return 1;
            case 'D': return -1;
            default: throw new RuntimeException("Unknown step ");
        }
    }

    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;

        for(int i=0; i< s.length(); ++i) {
            int delta = getStepDelta(s.charAt(i));
            level += delta;

            if (delta > 0 && level == 0) ++valleys;
        }

        return valleys;
    }

    @Test
    public void test_HackerrankTests() {
        assertEquals(1, countingValleys(8, "UDDDUDUU"));
        assertEquals(2, countingValleys(12, "DDUUDDUDUUUD"));
    }
}

package Algorithms;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

// Function should return the minimum number of jumps required, as an integer. 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpingOnClouds {
    //if current is 1 -> extra jump
    //if current is 0 and next is 0 too -> extra jump too
    static int jumpingOnClouds(int[] clouds) {
        int count = 0;
        int current = 0;
        while(current != clouds.length - 1) {
            ++current;
            ++count;
            if(clouds[current] == 1 || ((current < clouds.length - 1) && (clouds[current + 1] == 0))) ++current;
        }
        return count;
    }

    @Test
    public void test_HackerrankTests(){
        assertEquals(4, jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 0}));
        assertEquals(3, jumpingOnClouds(new int[] {0, 0, 0, 1, 0, 0}));
    }
}

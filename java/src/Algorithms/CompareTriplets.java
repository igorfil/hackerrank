package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/compare-the-triplets/problem

// Function must return an array of two integers, the first being Alice's score and the second being Bob's.
public class CompareTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aScore = 0;
        int bScore = 0;

        for(int i=0; i<a.size(); i++) {
            if(a.get(i) > b.get(i)) ++aScore;
            else if(b.get(i) > a.get(i)) ++bScore;
        }

        return Arrays.asList(aScore, bScore);
    }

    @Test
    public void test(){
        assertEquals(Arrays.asList(1, 1), compareTriplets(Arrays.asList(5, 6, 7), Arrays.asList(3, 6, 10)));
    }
}

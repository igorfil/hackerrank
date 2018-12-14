package Strings;

// https://www.hackerrank.com/challenges/alternating-characters/problem

// Function must return an integer representing the minimum number of deletions to make the alternating string.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int deletions = 0;
        for(int i=0; i<s.length() - 1; ++i) {
            if(s.charAt(i) == s.charAt(i+1)) ++deletions;
        }

        return deletions;
    }

    @Test
    public void test() {
        assertEquals(3, alternatingCharacters("AAAA"));
        assertEquals(4, alternatingCharacters("BBBBB"));
        assertEquals(0, alternatingCharacters("ABABABAB"));
        assertEquals(0, alternatingCharacters("BABABA"));
        assertEquals(4, alternatingCharacters("AAABBB"));
    }
}

package Strings;

// https://www.hackerrank.com/challenges/two-strings/problem

// Function should return a string, either YES or NO based on whether
// the strings share a common substring.

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoStrings {

    static boolean twoStrings(String first, String second) {
        Set<Integer> s1Chars = first.chars().boxed()
                .collect(Collectors.toSet());

        return second.chars().boxed().anyMatch(s1Chars::contains);
    }

    @Test
    public void test() {
        assertTrue(twoStrings("hello", "world"));
        assertFalse(twoStrings("hi", "world"));
    }

}

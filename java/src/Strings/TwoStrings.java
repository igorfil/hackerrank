package Strings;

// https://www.hackerrank.com/challenges/two-strings/problem

// Function should return a string, either YES or NO based on whether
// the strings share a common substring.

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoStrings {
    static String twoStrings(String first, String second) {
        Set<Integer> s1Chars = first.chars().boxed()
                .collect(Collectors.toSet());

        List<Integer> matching = second.chars().boxed()
                .filter(s1Chars::contains).collect(Collectors.toList());

        return matching.isEmpty() ? "NO" : "YES";
    }

    @Test
    public void test() {
        assertEquals("YES", twoStrings("hello", "world"));
        assertEquals("NO", twoStrings("hi", "world"));
    }
}

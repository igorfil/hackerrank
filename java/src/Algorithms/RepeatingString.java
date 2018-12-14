package Algorithms;

// https://www.hackerrank.com/challenges/repeated-string/problem
// Function should return an integer representing the number of occurrences of a in the prefix of length
// in the infinitely repeating string.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatingString {
    static long aCount(final String s) {
        int a = 'a';

        return s.chars().filter((c) -> c==a).count();
    }

    static long repeatedString(String s, long n) {
        long inOriginal = aCount(s);

        return inOriginal * (n/s.length()) + aCount(s.substring(0, (int)(n%s.length())));
    }

    @Test
    public void test_HackerrankTests() {
        assertEquals(7, repeatedString("aba", 10));
        assertEquals(1000000000000L, repeatedString("a", 1000000000000L));
        assertEquals(51574523448L, repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }
}

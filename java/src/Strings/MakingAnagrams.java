package Strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

// Function  must return an integer representing the minimum total characters
// that must be deleted to make the strings anagrams.

public class MakingAnagrams {
    static int makeAnagram(final String a, final String b) {
        int[] count = new int[26];

        a.chars().forEach(c -> ++count[c-'a']);
        b.chars().forEach(c -> --count[c-'a']);

        return Arrays.stream(count).reduce(0, (v, c) -> v + Math.abs(c));
    }

    @Test
    public void test_HackerrankTests() {
        assertEquals(4, makeAnagram("cde", "abc"));
        assertEquals(30, makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}

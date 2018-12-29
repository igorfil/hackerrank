package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        List<String> subs = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                subs.add(sorted(s.substring(i, j + 1)));
            }
        }

        int count = 0;
        for (int i = 0; i < subs.size(); ++i) {
            for (int j = i + 1; j < subs.size(); ++j) {
                if (subs.get(i).equals(subs.get(j))) {
                    ++count;
                }
            }
        }

        return count;
    }

    private static String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Test
    void test() {
        assertEquals(0, sherlockAndAnagrams("abc"));
        assertEquals(0, sherlockAndAnagrams("ab"));
        assertEquals(4, sherlockAndAnagrams("abba"));
        assertEquals(0, sherlockAndAnagrams("abcd"));
        assertEquals(3, sherlockAndAnagrams("ifailuhkqq"));
        assertEquals(10, sherlockAndAnagrams("kkkk"));
    }
}

package HashTables;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem

// Function must print if the note can be formed using the magazine, or .

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RansomNote {

    static boolean check(String[] magazine, String[] note) {
        Map<String, Long> magazineWords = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String word : note) {
            if(magazineWords.containsKey(word) && magazineWords.get(word) > 0) magazineWords.put(word, magazineWords.get(word) - 1);
            else return false;
        }

        return true;
    }

    @Test
    public void test() {
        assertTrue(check(new String[] {"give", "me", "one", "grand", "today", "night"}, new String[] {"give", "one", "grand", "today"}));
    }
}

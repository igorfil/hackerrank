package Strings;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockAndValidString {
    static String isValid(String s) {
        if(s.length() <= 3) return "YES";

        Map<Integer, Long> freq = s.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> values = new ArrayList<>(freq.values());
        Collections.sort(values);

        return  allEqual(values) || oneCountExtra(values) || oneCharExtra(values)  ? "YES" : "NO";
    }

    private static boolean allEqual(final List<Long> list) {
        return list.get(0).equals(list.get(list.size() - 1));
    }

    private static boolean oneCountExtra(final List<Long> list) {
        return list.get(0).equals (list.get(list.size() - 2))
                && list.get(0).equals (list.get(list.size() - 1) - 1);
    }

    private static boolean oneCharExtra(final List<Long> list) {
        return list.get(0) == 1
                && list.get(1).equals(list.get(list.size() - 1));
    }

    @Test
    void test() throws IOException {
        assertEquals("YES", isValid("a"));
        assertEquals("YES", isValid("abc"));
        assertEquals("YES", isValid("abcc"));
        assertEquals("YES", isValid("aabbc"));
        assertEquals("NO", isValid("abccc"));
        assertEquals("NO", isValid("aabbccddeefghi"));
        assertEquals("YES", isValid("abcdefghhgfedecba"));
        assertEquals("YES", isValid(Files.readAllLines(Paths.get("src/Strings/SherlockAndValidString_longInput.txt"), Charset.defaultCharset()).get(0)));
    }
}

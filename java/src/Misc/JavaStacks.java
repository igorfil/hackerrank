package Misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://www.hackerrank.com/challenges/java-stack/problem

public class JavaStacks {
    private static final Map<String, String> pairs;

    static {
        pairs = new HashMap<>();
        pairs.put(")", "(");
        pairs.put("]", "[");
        pairs.put("}", "{");
    }

    public static boolean isBalanced(final String input) {
        if (input.equals("") || input.length() % 2 != 0) {
            return false;
        }

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); ++i) {
            String nextChar = "" + input.charAt(i);
            if (!pairs.keySet().contains(nextChar)) {
                stack.push(nextChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!pairs.get(nextChar).equals(stack.pop())) {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }

    @Test
    public void test1() {
        assertTrue(JavaStacks.isBalanced("{}()"));
        assertTrue(JavaStacks.isBalanced("({()})"));
        assertFalse(JavaStacks.isBalanced("(({()})))"));
        assertFalse(JavaStacks.isBalanced("{{{"));
        assertFalse(JavaStacks.isBalanced("}{"));
        assertTrue(JavaStacks.isBalanced("({(){}()})()({(){}()})(){()}"));
    }
}

package Misc;

// https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingComparator {

    class Player {

        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    class Checker implements Comparator<Player> {

        private int getScore(Player player) {
            return player.score;
        }

        private String getName(Player player) {
            return player.name;
        }

        @Override
        public int compare(Player a, Player b) {
            return Comparator
                    .comparing(this::getScore)
                    .thenComparing(this::getName)
                    .compare(a, b);
        }
    }

    @Test
    void test() {
        Checker c = new Checker();

        assertEquals(0, c.compare(new Player("A", 1), new Player("A", 1)));
        assertEquals(1, c.compare(new Player("A", 10), new Player("B", 1)));
        assertEquals(-1, c.compare(new Player("A", 1), new Player("B", 10)));
        ;
    }
}

package Algorithms;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

public class FraudActivityNotifications {
    private static String huuugeStr = "";

    static {
        try {
            huuugeStr = new String(Files.readAllBytes(Paths.get("src/Algorithms/fraud_test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int activityNotifications(int[] expenditure, int d) {
        SlidingMedianCalculator smc = new SlidingMedianCalculator(d, 200 + 1);

        for (int i = 0; i < d; ++i) {
            smc.add(expenditure[i]);
        }

        int notifications = 0;
        for (int i = d; i < expenditure.length; ++i) {

            Optional<Double> median = smc.median();
            if (median.isPresent()) {
                if (expenditure[i] >= 2 * median.get()) {
                    ++notifications;
                }
            }

            smc.add(expenditure[i]);
        }

        return notifications;
    }

    @Test
    void testMedianOnOddSampleCount() {
        //omit dummy test cases
        SlidingMedianCalculator smc = new SlidingMedianCalculator(3, 10);

        feed(smc, 1, 2, 3);

        assertEquals(2, (double) smc.median().get());
        smc.add(4);
        assertEquals(3, (double) smc.median().get());
        smc.add(5);
        assertEquals(4, (double) smc.median().get());
        smc.add(1);
        assertEquals(4, (double) smc.median().get());
    }

    @Test
    void testMedianOnEvenSampleCount() {
        SlidingMedianCalculator smc = new SlidingMedianCalculator(4, 10);

        feed(smc, 1, 2, 3, 4);

        assertEquals(2.5, (double) smc.median().get());
        smc.add(1);
        assertEquals(2.5, (double) smc.median().get());
    }

    @Test
    void test_real() {
        SlidingMedianCalculator smc = new SlidingMedianCalculator(3, 51);

        feed(smc, 10, 20, 30);

        assertEquals(20, (double) smc.median().get());
        smc.add(40);
        assertEquals(30, (double) smc.median().get());
        smc.add(50);
        assertEquals(40, (double) smc.median().get());
    }

    @Test
    void test_notifications() {
        assertEquals(2, activityNotifications(fromStr("2 3 4 2 3 6 8 4 5"), 5));
        assertEquals(0, activityNotifications(fromStr("1 2 3 4 4"), 4));
    }

    @Test
    void test_huuge() {
        assertEquals(770, activityNotifications(fromStr(huuugeStr), 9999));
    }

    private int[] fromStr(String str) {
        return Arrays.stream(str.split(" "))
                .mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList())
                .stream()
                .mapToInt(i -> i).toArray();
    }

    private void feed(SlidingMedianCalculator smc, int... values) {
        for (int value : values) {
            smc.add(value);
        }
    }

    private static class SlidingMedianCalculator {
        int count;
        int[] freq;
        Queue<Integer> elements = new LinkedList<>();

        public SlidingMedianCalculator(int count, int maxValue) {
            this.count = count;
            this.freq = new int[maxValue];
        }

        public void add(int value) {
            ++freq[value];
            elements.add(value);

            if (elements.size() > count) {
                int popped = elements.poll();
                --freq[popped];
            }
        }

        public Optional<Double> median() {
            if (elements.size() < count) {
                return Optional.empty();
            }

            int medianPos1 = count / 2;
            int medianPos2 = medianPos1 + 1;

            int runningCount = 0;
            int median1 = -1;
            int median2 = -1;

            int i = 0;
            for (; i < freq.length; ++i) {
                runningCount += freq[i];

                if (median1 < 0 && runningCount >= medianPos1) {
                    median1 = i;
                }
                if (runningCount >= medianPos2) {
                    median2 = i;
                    break;
                }
            }

            if (count % 2 == 0) {
                return Optional.of((double) (median1 + median2) / 2.0);
            } else {
                return Optional.of((double) median2);
            }
        }
    }
}

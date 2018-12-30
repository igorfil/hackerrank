package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Not HackerRank, just implementation of QSort

public class QSort {

    public void qsort(Integer[] arr, int leftBoundary, int rightBoundary) {
        if (arr.length == 1) {
            return;
        }

        int left = leftBoundary;
        int right = rightBoundary;

        Integer pivotValue = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivotValue) {
                ++left;
            }
            while (arr[right] > pivotValue) {
                --right;
            }

            if (left < right) {
                Integer tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            ++left;
            --right;
        }

        if (leftBoundary < right) {
            qsort(arr, leftBoundary, right);
        }
        if (rightBoundary > left) {
            qsort(arr, left, rightBoundary);
        }
    }

    @Test
    void test() {
        assertEquals("[0]", sort("0"));
        assertEquals("[0, 1]", sort("0, 1"));
        assertEquals("[0, 1, 2]", sort("2, 0, 1"));
        assertEquals("[0, 1, 2, 3]", sort("2, 0, 1, 3"));
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8]", sort("8, 5, 1, 3, 4, 6, 2, 7, 0"));
    }

    private String sort(String s) {
        List<Integer> data = Arrays.stream(s.split(", "))
                .mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList());

        Integer[] toSort = data.toArray(new Integer[]{});
        qsort(toSort, 0, data.size() - 1);

        return Arrays.toString(toSort);
    }
}

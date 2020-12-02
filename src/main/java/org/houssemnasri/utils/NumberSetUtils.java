package org.houssemnasri.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberSetUtils {
    public static List<Integer> generateNumbers(int from, int to, int bitIndex) {
        List<Integer> result = new ArrayList<>();
        long mask = createMask(bitIndex);

        for (int i = from; i <= to; i++) {
            if ((i & mask) > 0) {
                result.add(i);
            }
        }
        return result;
    }

    private static Long createMask(int bit) {
        return (long) Math.pow(2, bit);
    }
}

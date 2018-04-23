package algs.implementation;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Sergiy Levchynskyi
 */

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        return (int) Arrays.stream(ar).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().mapToLong(entry -> entry.getValue() / 2).sum();
    }


}

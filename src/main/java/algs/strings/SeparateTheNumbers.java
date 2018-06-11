package algs.strings;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Sergiy Levchynskyi
 */

public class SeparateTheNumbers {

    static void separateNumbers(String s) {
        int [] numbers = IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .mapToInt(Integer::valueOf)
                .toArray();


    }
}

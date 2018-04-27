package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class StrangeCounter {

    static long strangeCounter(long t) {
        long partTimeStart = 1;
        long partValueStart = 3;
        while (partTimeStart + partValueStart <= t) {
            partTimeStart += partValueStart;
            partValueStart *= 2;
        }
        return partValueStart - (t - partTimeStart);
    }

    public static void main(String[] args) {
        System.out.println(strangeCounter(4));
    }
}

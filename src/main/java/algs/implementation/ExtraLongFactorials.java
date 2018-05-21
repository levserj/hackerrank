package algs.implementation;

import java.math.BigInteger;

/**
 * @author Sergiy Levchynskyi
 */

public class ExtraLongFactorials {

    static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.valueOf(n);
        for (int i = 1; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(n - i));
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        extraLongFactorials(25);
    }
}

package algs.implementation;

import java.util.Scanner;

/**
 * @author Sergiy Levchynskyi
 */

public class BonAppetit {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int length = sc.nextInt();
        int allergic = sc.nextInt();
        int[] bill = new int[length];
        int shared = 0;
        for (int i = 0; i < length; i++) {
            bill[i] = sc.nextInt();
            shared += bill[i];
        }
        int payment = sc.nextInt();
        int rightPayment = (shared - bill[allergic]) / 2;
        if (rightPayment == payment) {
            System.out.println("Boon Appetit");
        } else {
            System.out.println(payment - rightPayment);
        }

    }
}

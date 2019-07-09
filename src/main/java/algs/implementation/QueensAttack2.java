package algs.implementation;

import javafx.util.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack2 {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Set<Pair<Integer, Integer>> obstaclesSet = convertArrToSet(obstacles);
        obstaclesSet = getObstaclesLyingOnPossibleMove(obstaclesSet, r_q, c_q);
        int overallmoves = getTotalPossibleMoves(n, r_q, c_q);
        int blockedMoves = obstaclesSet.stream().mapToInt(p -> getBlockedMovesCount(p, r_q, c_q, n)).sum();
        return overallmoves - blockedMoves;
    }

    private static Set<Pair<Integer, Integer>> convertArrToSet(int[][] arr) {
        Set<Pair<Integer, Integer>> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(new Pair<>(arr[i][0], arr[i][1]));
        }
        return result;
    }

    private static Set<Pair<Integer, Integer>> getObstaclesLyingOnPossibleMove(Set<Pair<Integer, Integer>> obstacles, int r, int c) {
        Set<Pair<Integer, Integer>> result = new HashSet<>();
        for (Pair<Integer, Integer> obstacle : obstacles) {
            if (obstacle.getKey().equals(r) || obstacle.getValue().equals(c) || liesOnDiagonalPossibleMove(obstacle, r, c)) {
                result.add(obstacle);
            }
        }
        return result;
    }

    private static boolean liesOnDiagonalPossibleMove(Pair<Integer, Integer> obstacle, int r, int c) {
        return Math.abs(obstacle.getKey() - r) == Math.abs(obstacle.getValue() - c);
    }

    private static int getBlockedMovesCount(Pair<Integer, Integer> obstacle, int r, int c, int n) {
        int o_r = obstacle.getKey();
        int o_c = obstacle.getValue();
        int count;
        if (o_r > r) {
            if (o_c == c) {
                count = n - o_r + 1;
            } else {
                int closestToBorder;
                if (o_c > c) {
                    closestToBorder = Math.max(o_c, o_r);
                } else {
                    closestToBorder = Math.max(n - o_c, o_r);
                }
                count = n - closestToBorder + 1;
            }
        } else if (o_r - r == 0) {
            if (o_c < c) {
                count = o_c;
            } else {
                count = n - o_c + 1;
            }
        } else {
            int closestToBorder;
            if (o_c == c) {
                count = o_r;
            } else {
                if (o_c < c) {
                    closestToBorder = Math.min(o_c, o_r);
                } else {
                    closestToBorder = Math.min(n - o_c, o_r);
                }
                count = n - closestToBorder + 1;
            }
        }
        return count;
    }


    static int getTotalPossibleMoves(int n, int row, int col) {
        int a = getPositiveOrZero(Math.min(row - 1, col - 1));
        int b = getPositiveOrZero(Math.min(n - row, col - 1));
        int c = getPositiveOrZero(Math.min(n - row, n - col));
        int d = getPositiveOrZero(Math.min(row - 1, n - col));
        return (2 * n - 2) + a + b + c + d;
    }

    private static int getPositiveOrZero(int x) {
        return x > 0 ? x : 0;
    }

/*    public static void main(String[] args) {
        System.out.println(queensAttack(5, 3, 4, 3, new int[][]{{4, 2}, {5, 5}, {2, 3}}));
    }*/

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(new File("/home/sl/IdeaProjects/hackerrank/src/main/resources/QueensAttack2.testCase6.txt"));
            System.out.println(new File("/home/sl/IdeaProjects/hackerrank/src/main/resources/QueensAttack2.testCase6.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}

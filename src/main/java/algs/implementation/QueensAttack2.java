package algs.implementation;

import javafx.util.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack2 {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Set<Pair<Integer, Integer>> obstaclesSet = convertArrToSet(obstacles);
        obstaclesSet = getObstaclesLyingOnPossibleMove(obstaclesSet, r_q, c_q);
        int overallMoves = getTotalPossibleMoves(n, r_q, c_q);
        int blockedMoves = obstaclesSet.stream().mapToInt(p -> getBlockedMovesCount(p, r_q, c_q, n)).sum();
        return overallMoves - blockedMoves;
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
        for (Pair<Integer, Integer> found : obstacles) {
            if (found.getKey().equals(r)) {
                for (Pair<Integer, Integer> existing : result) {
                    if (existing.getKey().equals(found.getKey())) {
                        pickClosestHorizontalObstacle(existing, found, result, c);
                    }
                }
                result.add(found);

            } else if (found.getValue().equals(c)) {
                for (Pair<Integer, Integer> existing : result) {
                    if (existing.getValue().equals(found.getValue())) {
                        pickClosestVerticalObstacle(existing, found, result, r);
                    }
                }
                result.add(found);

            } else if (liesOnDiagonalPossibleMove(found, r, c)) {
                for (Pair<Integer, Integer> existing : result) {
                    if (liesOnDiagonalPossibleMove(existing, r, c)) {
                        pickClosestDiagonalObstacle(existing, found, result, r, c);
                    }
                }
                result.add(found);

            }
        }
        return result;
    }

    private static boolean liesOnDiagonalPossibleMove(Pair<Integer, Integer> obstacle, int r, int c) {
        return Math.abs(obstacle.getKey() - r) == Math.abs(obstacle.getValue() - c);
    }

    private static void pickClosestHorizontalObstacle(Pair<Integer, Integer> existing, Pair<Integer, Integer> found, Set<Pair<Integer, Integer>> obstacles, int c) {
        if ((existing.getValue() > c && found.getValue() > c && existing.getValue() > found.getValue()) ||
                (existing.getValue() < c && found.getValue() < c && existing.getValue() < found.getValue())
        ) {
            obstacles.remove(existing);
        }
    }

    private static void pickClosestVerticalObstacle(Pair<Integer, Integer> existing, Pair<Integer, Integer> found, Set<Pair<Integer, Integer>> obstacles, int r) {
        if ((existing.getKey() > r && found.getKey() > r && existing.getKey() > found.getKey()) ||
                (existing.getKey() < r && found.getKey() < r && existing.getKey() < found.getKey())) {
            obstacles.remove(existing);
        }
    }

    private static void pickClosestDiagonalObstacle(Pair<Integer, Integer> existing, Pair<Integer, Integer> found, Set<Pair<Integer, Integer>> obstacles, int r, int c) {
        if ((existing.getKey() > r && found.getKey() > r && existing.getValue() > c && found.getValue() > c && existing.getKey() > found.getKey()) || // upper right
                (existing.getKey() < r && found.getKey() < r && existing.getValue() < c && found.getValue() < c && existing.getKey() < found.getKey()) || // lower left
                (existing.getKey() < r && found.getKey() < r && existing.getValue() > c && found.getValue() > c && existing.getValue() > found.getValue()) || // lower right
                (existing.getKey() > r && found.getKey() > r && existing.getValue() < c && found.getValue() < c && existing.getValue() < found.getValue()) // upper left
        ) {
            obstacles.remove(existing);
        }
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

    public static void main(String[] args) throws IOException {

        System.out.println(queensAttack(5, 3, 4,3, new int[][]{{3,2}, {4, 2}, {5, 5}, {2, 3}}));


    }

}

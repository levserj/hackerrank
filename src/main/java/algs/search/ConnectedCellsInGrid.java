package algs.search;

/**
 * @author Sergiy Levchynskyi
 */

public class ConnectedCellsInGrid {
    static int connectedCell(int[][] matrix) {
        int maxConnectedCells = 0;
        int mRows = matrix.length;
        int mColumns = matrix[0].length;
        int[][] checked = new int [mRows][mColumns];
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                if (checked[i][j] != 1) {
                    int temp = getConncetedCells(i, j, matrix, mRows, mColumns, checked, 0);
                    if (temp > maxConnectedCells) {
                        maxConnectedCells = temp;
                    }
                }
            }
        }
        return maxConnectedCells;
    }

    private static int getConncetedCells(int row, int column, int[][] matrix, int mRows, int mColumns, int[][] checked, int connectedCells) {
        //int connectedCells = 0;
        int rowStart = row - 1;
        int rowEnd = row + 1;
        int columnStart = column - 1;
        int columnEnd = column + 1;
        if (row == 0) {
            rowStart = row;
        }
        if (row == mRows - 1) {
            rowEnd = row;
        }
        if (column == 0) {
            columnStart = column;
        }
        if (column == mColumns - 1) {
            columnEnd = column;
        }
        for (int r = rowStart; r <= rowEnd; r++) {
            for (int c = columnStart; c <= columnEnd; c++) {
                if (checked[r][c] == 1) {
                    continue;
                }
                checked[r][c] = 1;
                if (matrix[r][c] == 1) {
                    connectedCells++;
                    connectedCells = getConncetedCells(r, c, matrix, mRows, mColumns, checked, connectedCells);
                }
            }
        }
        return connectedCells;
    }

    public static void main(String[] args) {
        System.out.println(connectedCell(new int[][] {
                new int[] {1, 1, 0, 0, 0},
                new int[] {0, 1, 1, 0, 0},
                new int[] {0, 0, 1, 0, 1},
                new int[] {1, 0, 0, 0, 1},
                new int[] {0, 1, 0, 1, 1}
        }));
    }

}

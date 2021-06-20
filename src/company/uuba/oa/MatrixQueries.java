package company.uuba.oa;

import java.util.Arrays;

/**
 * matrixQueries。一个matrix, matrix[x][y] = (x+1) * (y+1)。现在有两个操作，抹除行或者列，返回matrix最小值。
 * 求设计这两个API。比如 removeCol(0), removeRow(3), getMin() -> 2
 * 1 2 3   4
 * 2 4 6   8
 * 3 6 9   12
 * 4 8 12 16
 * 之前做了sample questions发现第四题一定要用优化的数据结构和算法，不然过不了全部的case。这个题卖个关子，看大家怎么想。
 */
public class MatrixQueries {
    int[][] matrix;
    boolean[] rowToDelete;
    boolean[] colToDelete;
    int n, m;

    public MatrixQueries(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new int[n][m];
        rowToDelete = new boolean[n];
        colToDelete = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = (i + 1) * (j + 1);
                matrix[i][j] = val;
            }
        }
    }

    public int[][] removeRow(int r) {
        rowToDelete[r] = true;
        return buildMatrix();
    }

    public int[][] removeCol(int c) {
        colToDelete[c] = true;
        return buildMatrix();
    }

    public int getMin() {
        int i = 0, j = 0;
        while (rowToDelete[i]) {
            i++;
        }
        while (colToDelete[j]) {
            j++;
        }
        return matrix[i][j];
    }

    private int[][] buildMatrix() {
        int rowNum = 0, colNum = 0;
        for (boolean b : rowToDelete) {
            if (!b) rowNum++;
        }
        for (boolean b : colToDelete) {
            if (!b) colNum++;
        }
        int[][] res = new int[rowNum][colNum];
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (rowToDelete[i]) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (colToDelete[j]) {
                    continue;
                }
                res[r][c++] = matrix[i][j];
            }
            r++;
            c = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        MatrixQueries matrixQueries = new MatrixQueries(4, 4);
        for (int[] a : matrixQueries.removeRow(1)) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(matrixQueries.getMin());
        for (int[] a : matrixQueries.removeCol(2)) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(matrixQueries.getMin());
        for (int[] a : matrixQueries.removeRow(0)) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(matrixQueries.getMin());
    }

}

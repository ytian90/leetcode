package dynamicProgramming;

/**
 * 308. Range Sum Query 2D - Mutable
 */
public class RangeSumQuery2DMutable {

    private int[][] colSums;
    private int[][] matrix;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int n = matrix.length, m = matrix[0].length;
        this.colSums = new int[n + 1][m];
        this.matrix = matrix;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        for (int i = row + 1; i < colSums.length; i++) {
            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int j = col1; j <= col2; j++) {
            res += colSums[row2 + 1][j] - colSums[row1][j];
        }
        return res;
    }

    public static void main(String[] args) {
        RangeSumQuery2DMutable obj = new RangeSumQuery2DMutable(new int[][]{
                {3, 0, 1},
                {5, 6, 3},
                {1, 2, 0}
        });
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        obj.update(1, 1, 5);
        System.out.println(obj.sumRegion(1, 1, 2, 2));
    }
}

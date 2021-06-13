package company.lnkin;

/**
 * Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.
 *
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.
 *
 * Example 1:
 *
 * Input: grid = [["0","E","0","0"],
 *                ["E","0","W","E"],
 *                ["0","E","0","0"]]
 * Output: 3
 * Example 2:
 *
 *
 * Input: grid = [["W","W","W"],
 *                ["0","0","0"],
 *                ["E","E","E"]]
 * Output: 1
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    int count = calculate(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private int calculate(char[][] b, int i, int j) {
        int res = 0;
        int a = i;
        while (a >= 0) {
            if (b[a][j] == 'E') {
                res++;
            } else if (b[a][j] == 'W') {
                break;
            }
            a--;
        }
        a = i;
        while (a < b.length) {
            if (b[a][j] == 'E') {
                res++;
            } else if (b[a][j] == 'W') {
                break;
            }
            a++;
        }
        a = j;
        while (a >= 0) {
            if (b[i][a] == 'E') {
                res++;
            } else if (b[i][a] == 'W') {
                break;
            }
            a--;
        }
        a = j;
        while (a < b[0].length) {
            if (b[i][a] == 'E') {
                res++;
            } else if (b[i][a] == 'W') {
                break;
            }
            a++;
        }
        return res;
    }

    public static int maxKilledEnemies2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length, res = 0, rowHits = 0;
        int[] colHits = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for (int k = j; k < m && grid[i][k] != 'W'; k++) {
                        rowHits += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < n && grid[k][j] != 'W'; k++) {
                        colHits[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowHits + colHits[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxKilledEnemies2(new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', '0'},
                {'0', 'E', '0', '0'}
        }));
    }
}

package array;

/**
 * 840. Magic Squares In Grid
 */
public class MagicSquaresInGrid {

    public static int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 5) {
                    if(isMagic(i, j, grid))
                        res++;
                }
            }
        }
        return res;
    }

    private static boolean isMagic(int i, int j, int[][] grid) {
        String s = "" + grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1]
                + grid[i + 1][j] + grid[i + 1][j - 1] + grid[i][j - 1];
        return "4381672943816729".contains(s) || "9276183492761834".contains(s);
    }

    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]{
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        }));
    }
}

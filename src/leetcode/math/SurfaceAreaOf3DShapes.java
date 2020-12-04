package leetcode.math;

/**
 * 892. Surface Area of 3D Shapes
 */
public class SurfaceAreaOf3DShapes {
    public static int surfaceArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) res += 4 * grid[i][j] + 2;
                if (i > 0) res -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                if (j > 0) res -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{
                {2}
        }));
        System.out.println(surfaceArea(new int[][]{
                {1, 2},
                {3, 4}
        }));
        System.out.println(surfaceArea(new int[][]{
                {1, 0},
                {0, 2}
        }));
        System.out.println(surfaceArea(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        }));
        System.out.println(surfaceArea(new int[][]{
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        }));
    }
}

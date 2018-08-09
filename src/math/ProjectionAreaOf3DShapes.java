package math;

/**
 * 887. Projection Area of 3D Shapes
 */
public class ProjectionAreaOf3DShapes {

    public static int projectionArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            int v = 0;
            for (int j = 0; j < n; j++) {
                v = Math.max(v, grid[i][j]);
            }
            res += v;
        }
        for (int j = 0; j < n; j++) {
            int v = 0;
            for (int i = 0; i < n; i++) {
                v = Math.max(v, grid[i][j]);
            }
            res += v;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][]{
                {2}
        }));
        System.out.println(projectionArea(new int[][]{
                {1, 2},
                {3, 4}
        }));
        System.out.println(projectionArea(new int[][]{
                {1, 0},
                {0, 2}
        }));
        System.out.println(projectionArea(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        }));
        System.out.println(projectionArea(new int[][]{
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        }));
    }
}

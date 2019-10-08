package mj.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 有一个岛 （2D array），每一个cell 都有高度。 找到一个valid path， from left up coner to right bottom coner.
 *     只有一个限制条件，只能爬上爬下一次，或者完全不爬。
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=556762&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D7%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class ClimbPath {
    public static List<List<int[]>> findPath(int[][] matrix) {
        List<List<int[]>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        dfs(0, 0, matrix[0][0], matrix, visited, list, res);
        return res;
    }

    private static void dfs(int i, int j, int prev, int[][] matrix, boolean[][] visited, List<int[]> list, List<List<int[]>> res) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length
                || Math.abs(matrix[i][j] - prev) > 1 || visited[i][j]) {
            return;
        }
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            list.add(new int[]{i, j});
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        visited[i][j] = true;
        list.add(new int[]{i, j});
        dfs(i + 1, j, matrix[i][j], matrix, visited, list, res);
        dfs(i, j + 1, matrix[i][j], matrix, visited, list, res);
        visited[i][j] = false;
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        for (List<int[]> l : findPath(new int[][]{
                {2, 3, 2},
                {1, 5, 1},
                {2, 3, 2}
        })) {
            for (int[] a : l) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
        }

    }
}

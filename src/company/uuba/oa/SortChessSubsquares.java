package company.uuba.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * sortChessSubsquares
 * 这题input是个二维数组，这个二维数组在图上面展示出来类似于黑白棋，最左上角的点是黑色的，与其相邻的点是白色，以此类推黑色和白色相互交错
 * 然后又给了数组类似于[[0,1,2],[0,2,3]]， 意思是其中[0,1,2] 表示最左上角以（0，1）为起点的2*2的矩阵，矩阵中的黑白棋子按照各自的颜色分组进行排序，
 * 进行了两次排序后输出得到的数组
 */
public class SortChessSubsquares {
    public static void sortChessSubsquares(int[][] matrix, int[] sub) {
        int n = matrix.length, m = matrix[0].length;
        int x1 = sub[0], y1 = sub[1], k = sub[2];
        int x2 = Math.min(x1 + k - 1, n - 1);
        int y2 = Math.min(y1 + k - 1, m - 1);
        List<Integer> black = new ArrayList<>();
        List<Integer> white = new ArrayList<>();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    black.add(matrix[i][j]);
                } else {
                    white.add(matrix[i][j]);
                }
            }
        }
        Collections.sort(black);
        Collections.sort(white);
        int b = 0, w = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    matrix[i][j] = black.get(b++);
                } else {
                    matrix[i][j] = white.get(w++);
                }
            }
        }
    }

}

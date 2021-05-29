package leetcode.uber;

import java.util.Arrays;

/**
 * 3.这个题个人觉得有点难，是一个叫tetris的游戏（我是从来没听过）给你5个图形和一个nxm的方块板，要把一个arr里面给的各个编号的图形放进板子里
 * 其中图形1是一个方块口，图形2是三个方块口口口，图形三是四个方块
 * 口口
 * 口口
 * 这样
 *
 * 比如：给的板是4x4, 然后arr里面是[2,1,3]，放好了就是
 * [1,1,1,2]
 * [3,3,0,0]
 * [3,3,0,0]
 * [0,0,0,0]
 * 板子里面1代表了是arr[1]图形（编号为2的），2代表的arr[2]图形（编号为1的）以此类推
 * constraint是要从最小row开始放，如果row一样就选最小的col的那个cell
 *
 * 给定一个n*m的矩阵和五个俄罗斯方块的形状，不互相重复的往里放俄罗斯方块，每个放好的方块填满index+1，比如第一个方块就fill 1，第二个fill 2，放了最多五个方块后，返回矩阵
 */
public class AlmostTetris {
    static int[][][] figureDimension = {{{0, 0}},
                                 {{0, 0}, {0, 1}, {0, 2}},
                                 {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
                                 {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
                                 {{0, 1}, {1, 0}, {1, 1}, {1, 2}}};

    public static int[][] almostTetris(int n, int m, int[] figures) {
        int[][] matrix = new int[n][m];
        int depth = 1;
        for (int figure : figures) {
            boolean isPlaced = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0 && valid(matrix, figureDimension[figure], i, j)) {
                        for (int[] c : figureDimension[figure]) {
                            int x = i + c[0], y = j + c[1];
                            matrix[x][y] = depth;
                            isPlaced = true;
                        }
                        break;
                    }
                }
                if (isPlaced) {
                    break;
                }
            }
            depth++;
        }
        return matrix;
    }

    private static boolean valid(int[][] matrix, int[][] shapes, int i, int j) {
        for (int[] c : shapes) {
            int x = i + c[0], y = j + c[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int[] a : almostTetris(4, 4, new int[]{1, 0, 2})) {
            System.out.println(Arrays.toString(a));
        }
    }

}

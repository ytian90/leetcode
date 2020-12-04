package leetcode.mj.google;

import java.util.Arrays;

/**
 * lc723
 */
public class CandyCrush {
    public static int[][] candyCrush(int[][] board) {
        int n = board.length, m = board[0].length;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;
                    if (j < m - 2 && Math.abs(board[i][j + 2]) == val && Math.abs(board[i][j + 1]) == val) {
                        found = true;
                        int index = j;
                        while (index < m && Math.abs(board[i][index]) == val) {
                            board[i][index] = -val;
                            index++;
                        }
                    }
                    if (i < n - 2 && Math.abs(board[i + 2][j]) == val && Math.abs(board[i + 1][j]) == val) {
                        found = true;
                        int index = i;
                        while (index < n && Math.abs(board[index][j]) == val) {
                            board[index][j] = -val;
                            index++;
                        }
                    }
                }
            }
            if (found) {
                for (int j = 0; j < m; j++) {
                    int index = n - 1;
                    for (int i = n - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[index][j] = board[i][j];
                            index--;
                        }
                    }
                    for (int k = index; k >= 0; k--) {
                        board[k][j] = 0;
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        int[][] t = {
                {110,5,112,113,114},
                {210,211,5,213,214},
                {310,311,3,313,314},
                {410,411,412,5,414},
                {5,1,512,3,3},
                {610,4,1,613,614},
                {710,1,2,713,714},
                {810,1,2,1,1},
                {1,1,2,2,2},
                {4,1,4,4,1014}
        };
        for (int[] a : candyCrush(t)) {
            System.out.println(Arrays.toString(a));
        }
    }
}

package leetcode.array;

import java.util.Arrays;

/**
 * 723. Candy Crush
 */
public class CandyCrush {
    public static int[][] candyCrush(int[][] board) {
        int n = board.length, m = board[0].length;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0;j < m; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;
                    if (j < m - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        found = true;
                        int p = j;
                        while (p < m && Math.abs(board[i][p]) == val) board[i][p++] = -val;
                    }
                    if (i < n - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        found = true;
                        int p = i;
                        while (p < n && Math.abs(board[p][j]) == val)
                            board[p++][j] = -val;

                    }
                }
            }
            if (found) {
                for (int j = 0; j < m; j++) {
                    int pos = n - 1;
                    for (int i = n - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[pos--][j] = board[i][j];
                        }
                    }
                    for (int i = pos; i >= 0; i--) {
                        board[i][j] = 0;
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

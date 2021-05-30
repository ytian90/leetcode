package company.uber.oa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * QUESTION 2: NEAREST EXIT
 * There is an m x n rectangular 2d array called board which has rows and columns containing '0' or '+' only.
 * Rows and columns start at index 0
 * The '0' value means it is a passable path whereas the '+' value is a wall that cannot be crossed.
 * You are a snake that can move in four directions- up, down, left, right. Entering and exiting the board must only happen at a '0' value. You can enter the board from any four sides/borders
 * After entering the board, there can be multiple exits. Find the nearest exit
 *
 * EXAMPLE
 *
 * + 0 0 + + +
 * + 0 0 0 + +
 * + + + 0 + +
 * + + + 0 + +
 * 0 + 0 0 0 0
 * 0 0 0 + + +
 * board = [
 * ['+','0','0','+', '+', '+'],
 * ['+','0','0','0', '+', '+'],
 * ['+','+','+','0', '+', '+'],
 * ['+','+','+','0', '+', '+'],
 * ['0','+','0','0', '0', '0'],
 * ['0','0','0','+', '+', '+']
 * ]
 * find_exit(board, (4, 5))
 *
 * OUTPUT
 * (5,2)
 *
 * EXPLANATION
 * You are given the board array and a set of coordinates. 4 is the rowId, 5 is the columnId for entry
 * There are multiple exits. The goal is the find the nearest exit
 * Exit is at row 5 column 2
 * Answer is (5,2)
 */
public class NearestExit {
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int[] findExit(char[][] board, int[] start) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] != start[0] && curr[1] != start[1] &&
                    (curr[0] == 0 || curr[0] == n - 1 || curr[1] == 0 || curr[1] == n - 1)) {
                    return curr;
                }
                for (int[] d : dirs) {
                    int x = curr[0] + d[0], y = curr[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || board[x][y] == '+') {
                        continue;
                    }
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findExit(new char[][]{
                {'+','0','0','+', '+', '+'},
                {'+','0','0','0', '+', '+'},
                {'+','+','+','0', '+', '+'},
                {'+','+','+','0', '+', '+'},
                {'0','+','0','0', '0', '0'},
                {'0','0','0','+', '+', '+'}
        }, new int[]{4, 5})));
    }

}

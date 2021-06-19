package company.uber;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 529. Minesweeper
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given an m x n char matrix board representing the game board where:
 *
 * 'M' represents an unrevealed mine,
 * 'E' represents an unrevealed empty square,
 * 'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
 * digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
 * 'X' represents a revealed mine.
 * You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').
 *
 * Return the board after revealing this position according to the following rules:
 *
 * If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
 * If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 * Example 1:
 * Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
 * Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 *
 * Example 2:
 * Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
 * Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 */
public class Minesweeper {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        int n = board.length, m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            if (board[x][y] == 'M' || board[x][y] == 'X') {
                board[x][y] = 'X';
            } else {
                int closeMX = 0;
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
                        closeMX++;
                    }
                }
                if (closeMX > 0) {
                    board[x][y] = (char) ('0' + closeMX);
                } else {
                    board[x][y] = 'B';
                    for (int[] d : dirs) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] != 'E') {
                            continue;
                        }
                        q.add(new int[]{nx, ny});
                        board[nx][ny] = 'B';
                    }
                }
            }
        }
        return board;
    }
}

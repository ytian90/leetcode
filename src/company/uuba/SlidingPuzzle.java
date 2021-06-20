package company.uuba;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LC 773. Sliding Puzzle
 *
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 */
public class SlidingPuzzle {
    private int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    private final String TARGET = "123450";

    public int slidingPuzzle(int[][] board) {
        int res = 0;
        int n = board.length, m = board[0].length;
        Queue<String> q = new LinkedList<>();
        String start = getStr(board);
        q.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (TARGET.equals(curr)) {
                    return res;
                }
                int zeroIndex = curr.indexOf('0');
                for (int d : dirs[zeroIndex]) {
                    String next = swap(curr, zeroIndex, d);
                    if (visited.contains(next)) {
                        continue;
                    }
                    q.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        StringBuilder res = new StringBuilder(s);
        res.setCharAt(i, s.charAt(j));
        res.setCharAt(j, s.charAt(i));
        return res.toString();
    }

    private String getStr(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

}

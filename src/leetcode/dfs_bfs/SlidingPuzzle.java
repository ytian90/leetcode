package leetcode.dfs_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 773. Sliding Puzzle
 */
public class SlidingPuzzle {
    /*
    [0, 1, 2]
    [3, 4, 5]
     */
    private static final int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public static int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return res;
                }
                int zeroPos = curr.indexOf('0');
                for (int dir : dirs[zeroPos]) {
                    String next = swap(curr, zeroPos, dir);
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

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{
                {1, 2, 3},
                {4, 0, 5}
        }));
        System.out.println(slidingPuzzle(new int[][]{
                {1, 2, 3},
                {5, 4, 0}
        }));
        System.out.println(slidingPuzzle(new int[][]{
                {4, 1, 2},
                {5, 0, 3}
        }));
        System.out.println(slidingPuzzle(new int[][]{
                {3, 2, 4},
                {1, 5, 0}
        }));
    }
}

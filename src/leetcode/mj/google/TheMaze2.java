package leetcode.mj.google;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * lc505
 */
public class TheMaze2 {
    class Point {
        int x, y, l;
        public Point(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int n = maze.length, m = maze[0].length;
        int[][] len = new int[n][m];
        for (int[] i : len) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (a.l - b.l));
        pq.offer(new Point(start[0], start[1], 0));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (len[p.x][p.y] < p.l) {
                continue;
            }
            len[p.x][p.y] = p.l;
            for (int[] d : dirs) {
                int x = p.x, y = p.y, l = p.l;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                    l++;
                }
                x -= d[0];
                y -= d[1];
                l--;
                pq.offer(new Point(x, y, l));
            }
        }
        return len[dest[0]][dest[1]] == Integer.MAX_VALUE
                ? -1 : len[dest[0]][dest[1]];
    }
}

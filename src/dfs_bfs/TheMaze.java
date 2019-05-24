package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 490. The Maze
 */
public class TheMaze {

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        int n = maze.length, m = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        q.offer(new Point(start[0], start[1]));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int[] d : dirs) {
                int x = p.x;
                int y = p.y;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += d[0];
                    y += d[1];
                }
                x -= d[0];
                y -= d[1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                if (x == destination[0] && y == destination[1]) return true;
                q.add(new Point(x, y));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPath(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0}
        }, new int[]{4, 3}, new int[]{0, 1}));
    }
}

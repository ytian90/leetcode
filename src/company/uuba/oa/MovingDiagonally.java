package company.uuba.oa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * moving diagonally。一个 n*m的矩阵，start from（x1，y1）一开始以step（dx=1，dy=1）移动，如果x方向移动出了矩阵，
 * step变成（dx=-dx，dy=dy）并且回到移动出矩阵前的位置以新的step方向继续移动。如果y方向移动出了矩阵，step变成（dx=dx，dy=-dy）
 * 并且回到移动出矩阵前的位置以新的step方向继续移动。如果x，y方向同时移动出了矩阵，step变成（dx=-dx，dy=-dy）
 * 并且回到移动出矩阵前的位置以新的step方向继续移动。要求输出以这种移动方式需要多少step可以移动到（x2，y2），
 * 如果无法到达（x2，y2），输出-1 （感觉是其实最短路径的变种，是不是这样？）用一个4维数组记录是否已经visit 某个位置以及移动
 */
public class MovingDiagonally {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        int n = grid.length, m = grid[0].length, res = 0;
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(source);
        visited[source.x][source.y] = true;
        int[] dx = {1, 1, -1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int level = 0; level < size; level ++) {
                Point current = q.poll();
                for (int i = 0; i < 8; i ++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (isValid(nx, ny, grid) && !visited[nx][ny]) {
                        if (nx == destination.x && ny == destination.y) return res;
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && !grid[x][y];
    }



}
class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

package mj.google;

import java.util.Arrays;

/**
 * 19. Generate Random Maze
 */
public class GenerateRandomMaze {
    public int[][] maze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX2 = dir.moveX(x, 2);
            int nextY2 = dir.moveY(y, 2);
            int nextX = dir.moveX(x, 1);
            int nextY = dir.moveY(y, 1);
            if (isValidWall(maze, nextX2, nextY2)) {
                maze[nextX][nextY] = 0;
                maze[nextX2][nextY2] = 0;
                generate(maze, nextX2, nextY2);
            } else if (isOnBoundary(maze, nextX, nextY)) {
                maze[nextX][nextY] = 0;
                generate(maze, nextX, nextY);
            }
        }
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int) (Math.random() * (dirs.length - i));
            Dir t = dirs[i];
            dirs[i] = dirs[i + index];
            dirs[i + index] = t;
        }
    }

    private boolean isValidWall(int[][] maze, int x, int y) {
        return isInMaze(maze, x, y) && maze[x][y] == 1;
    }

    private boolean isInMaze(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }

    private boolean isOnBoundary(int[][] maze, int x, int y) {
        return (x == 0 || x == maze.length) && (y == 0 || y == maze[0].length);
    }

    enum Dir {
        NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);
        int deltaX;
        int deltaY;
        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int moveX(int x, int times) {
            return x + deltaX * times;
        }

        public int moveY(int y, int times) {
            return y + deltaY * times;
        }
    }

    public static void main(String[] args) {
        GenerateRandomMaze obj = new GenerateRandomMaze();
        for (int[] a : obj.maze(10)) {
            System.out.println(Arrays.toString(a));
        }
    }
}

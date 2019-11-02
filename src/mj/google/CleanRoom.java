package mj.google;

import java.util.HashSet;
import java.util.Set;

/**
 * lc489
 */
public class CleanRoom {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        helper(robot, 0, 0, 0, visited);
    }

    private void helper(Robot robot, int x, int y, int currDir, Set<String> visited) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (currDir + i) % 4;
            int nextX = x + dirs[nextDir][0];
            int nextY = y + dirs[nextDir][1];
            if (!visited.contains(nextX + "-" + nextY) && robot.move()) {
                visited.add(nextX + "-" + nextY);
                helper(robot, nextX, nextY, nextDir, visited);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    interface Robot {
        boolean move();
        void turnLeft();
        void turnRight();
        void clean();
    }
}

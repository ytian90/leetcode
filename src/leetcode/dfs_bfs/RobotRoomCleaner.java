package leetcode.dfs_bfs;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        visited.add("0-0");
        helper(robot, 0, 0, 0, visited);
    }

    private void helper(Robot robot, int x, int y, int currDir, Set<String> visited) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (currDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                visited.add(newX + "-" + newY);
                helper(robot, newX, newY, nextDir, visited);
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

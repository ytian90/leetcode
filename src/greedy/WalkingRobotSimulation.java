package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. Walking Robot Simulation
 */
public class WalkingRobotSimulation {
    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, res = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4) {
                    d = 0;
                }
            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println(robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }
}

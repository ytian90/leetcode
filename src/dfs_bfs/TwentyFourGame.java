package dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 679. 24 Game
 */
public class TwentyFourGame {
    private static final double DIFF = 0.001;

    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    private static boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < DIFF;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1;j < list.size(); j++) {
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> next = new ArrayList<>();
                    next.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == i || k == j) continue;
                        next.add(list.get(k));
                    }
                    if (dfs(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static List<Double> compute(double a, double b) {
        return Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
    }

    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
    }
}

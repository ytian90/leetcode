package leetcode.mj.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 939 & 963
 */
public class MinimumAreaRectangle {
    public static int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "-" + p[1]);
        }
        double result = Double.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    continue;
                }
                for (int[] p3 : points) {
                    if (dist(p1, p3) + dist(p2, p3) != dist(p1, p2)) {
                        continue;
                    }
                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    if (!set.contains(x + "-" + y)) {
                        continue;
                    }
                    double area = Math.sqrt(dist(p1, p3)) * Math.sqrt(dist(p2, p3));
                    if (Double.compare(area, 0) == 0) {
                        continue;
                    }
                    result = Math.min(result, area);
                }
            }
        }
        return Double.compare(Double.MAX_VALUE, result) == 0 ? 0 : result;
    }

    private static double dist(int[] p1, int[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }

    public static void main(String[] args) {
        System.out.println(minAreaRect(new int[][]{
                {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
        }));
    }
}

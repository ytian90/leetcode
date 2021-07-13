package company.lnkin;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 149. Max Points on a Line
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }
        int res = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0, max = 0;
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + "," + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + duplicate + 1); // 1 is the source point of the line pivoted at i
        }
        return res;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) return a;
        return generateGCD(b, a % b);
    }

    public int maxPoints2(int[][] points) {
        int res = 1, n = points.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int count = 0;
                long x1 = points[i][0], y1 = points[i][1];
                long x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) continue;
                for (int k = 0; k < n; k++) {
                    long x3 = points[k][0], y3 = points[k][1];
                    if ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) == 0) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}

package company.lnkin;

/**
 * LC 149. Max Points on a Line
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
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

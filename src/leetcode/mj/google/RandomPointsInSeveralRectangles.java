package leetcode.mj.google;

/**
 * 9. RandomPointsInSeveralRectangles
 */
public class RandomPointsInSeveralRectangles {
    // LC850
    static long M = (long) 1e9+7;

    public static int rectangleArea(int[][] rectangles) {
        long res = 0;
        for (int[] r : rectangles) {
            res += areaOf(r[0], r[1], r[2], r[3]);
        }
        for (int i = 0; i < rectangles.length; i++) {
            long overlap = overlap(rectangles, rectangles[i], i + 1);
            res = (res - overlap + M) % M;
        }
        return (int) res;
    }

    private static long overlap(int[][] recs, int[] a, int index) {
        if (index == recs.length) {
            return 0;
        }
        int[] b = recs[index];
        index++;
        int left = Math.max(a[0], b[0]), right = Math.min(a[2], b[2]), down = Math.max(a[1], b[1]), up = Math.min(a[3], b[3]);
        if (left >= right || up <= down) {
            return overlap(recs, a, index);
        }
        long res = areaOf(left, down, right, up);
        if (a[0] < b[0]) res = (res + overlap(recs, new int[]{a[0], a[1], b[0], a[3]}, index)) % M;
        if (b[2] < a[2]) res = (res + overlap(recs, new int[]{b[2], a[1], a[2], a[3]}, index)) % M;
        if (a[1] < b[1]) res = (res + overlap(recs, new int[]{left, a[1], right, b[1]}, index)) % M;
        if (b[3] < a[3]) res = (res + overlap(recs, new int[]{left, b[3], right, a[3]}, index)) % M;
        return res;
    }

    private static long areaOf(int x1, int y1, int x2, int y2) {
        return (long) (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        System.out.println(rectangleArea(new int[][]{{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}}));
    }
}

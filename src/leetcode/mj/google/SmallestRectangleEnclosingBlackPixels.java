package leetcode.mj.google;

/**
 * 302. Smallest Rectangle Enclosing Black Pixels
 */
public class SmallestRectangleEnclosingBlackPixels {
    private char[][] image;

    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int n = image.length, m = image[0].length;
        int left = searchColumns(0, y, 0, n, true);
        int right = searchColumns(y + 1, m, 0, n, false);
        int top = searchRows(0, x, left, right, true);
        int bottom = searchRows(x + 1, n, left, right, false);
        return (right - left) * (bottom - top);
    }

    private int searchColumns(int i, int j, int top, int bottom, boolean opt) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') {
                k++;
            }
            if (k < bottom == opt) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    private int searchRows(int i, int j, int left, int right, boolean opt) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') {
                k++;
            }
            if (k < right == opt) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}

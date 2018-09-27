package math;

/**
 * 885. Spiral Matrix 3
 */
public class SpiralMatrix3 {

    // time O(max(M,N) ^ 2)
    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        res[0] = new int[]{r0, c0};
        int x = 0, y = 1, n = 0, i = 0, tmp, j = 1;
        while (j < R * C) {
            r0 += x; c0 += y; i++;
            if (0 <= r0 && r0 < R && 0 <= c0 && c0 < C) {
                res[j++] = new int[]{r0, c0};
            }
            if (i == n / 2 + 1) {
                i = 0; n++;
                tmp = x; x = y; y = -tmp; // turn right
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralMatrixIII(1, 4, 0, 0));
        System.out.println(spiralMatrixIII(5, 6, 1, 4));
    }
}

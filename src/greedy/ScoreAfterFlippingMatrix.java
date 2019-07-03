package greedy;

/**
 * 861. Score After Flipping Matrix
 */
public class ScoreAfterFlippingMatrix {

    public static int matrixScore(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int n = A.length, m = A[0].length;
        for (int i = 0; i < n; i++) {
            if (A[i][0] == 0) {
                flip(A, i);
            }
        }
        for (int j = 0; j < m; j++) {
            int c0 = 0, c1 = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][j] == 0) c0++;
                if (A[i][j] == 1) c1++;
            }
            if (c0 > c1) {
                for (int i = 0; i < n; i++) {
                    if (A[i][j] == 0) A[i][j] = 1;
                    else if (A[i][j] == 1) A[i][j] = 0;
                }
            }
        }
        int res = 0;
        for (int[] a : A) {
            res += val(a);
        }
        return res;
    }

    public static void flip(int[][] A, int r) {
        for (int i = 0; i < A[r].length; i++) {
            if (A[r][i] == 0) {
                A[r][i] = 1;
            } else if (A[r][i] == 1) {
                A[r][i] = 0;
            }
        }
    }

    public static int val(int[] a) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res = (res << 1) + a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        }));
    }

    public static int matrixScore2(int[][] A) {
        int n = A.length, m = A[0].length, res = (1 << (m - 1)) * n;
        for (int j = 1; j < m; j++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if (A[i][0] == A[i][j]) curr++;
            }
            res += Math.max(curr, n - curr) * (1 << (m - 1 - j));
        }
        return res;
    }



    /*
        Assume A is M * N.

        A[i][0] is worth 1 << (N - 1) points, more than the sum of (A[i][1] + .. + A[i][N-1]).
        We need to toggle all A[i][0] to 1, here I toggle all lines for A[i][0] = 0.
        A[i][j] is worth 1 << (N - 1 - j)
        For every col, I sort the current number of 1s.
        After step 1, A[i][j] becomes 1 if A[i][j] == A[i][0].
        if M - cur > cur, we can toggle this column to maxPerformance more 1s.
        max(M, M - cur) will be the maximum number of 1s that we can maxPerformance.
     */
}

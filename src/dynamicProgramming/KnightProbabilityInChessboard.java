package dynamicProgramming;

/**
 * 688. Knight Probability in Chessboard
 */
public class KnightProbabilityInChessboard {

    private static int[][] dirs = new int[][]{
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, 2}, {2, 1}, {2, -1}, {1, -2}
    };

    public static double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;
        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp[step][i][j] += dp[step - 1][x][y] * 0.125;
                    }
                }
            }
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K][i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }
}

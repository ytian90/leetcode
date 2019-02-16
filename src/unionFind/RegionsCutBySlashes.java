package unionFind;

/**
 * 959. Regions Cut By Slashes
 */
public class RegionsCutBySlashes {

    // dfs
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int count = 0;
        int[][] dp = new int[n * 3][m * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '/') {
                    dp[i * 3][j * 3 + 2] = 1;
                    dp[i * 3 + 1][j * 3 + 1] = 1;
                    dp[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    dp[i * 3][j * 3] = 1;
                    dp[i * 3 + 1][j * 3 + 1] = 1;
                    dp[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == 0) {
                    dfs(dp, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] dp, int i, int j) {
        int n = dp.length, m = dp[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || dp[i][j] == 1)
            return;
        dp[i][j] = 1;
        int[] d = {0, -1, 0, 1, 0};
        for (int k = 0; k < 4; k++) {
            dfs(dp, i + d[k], j + d[k + 1]);
        }
    }

    // union find
    int count, n;
    int[] f;
    public int regionsBySlashes2(String[] grid) {
        n = grid.length;
        count = n * n * 4;
        f = new int[n * n * 4];
        for (int i = 0; i < count; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) union(g(i, j - 1, 1), g(i, j, 3));
                if (grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 2), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    union(g(i, j, 0), g(i, j, 3));
                    union(g(i, j, 2), g(i, j, 1));
                }
            }
        }
        return count;
    }

    public int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f[x] = y;
            count--;
        }
    }

    public int g(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }

    public static void main(String[] args) {
        System.out.println(regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(regionsBySlashes(new String[]{"/\\\\", "\\\\/"}));
        System.out.println(regionsBySlashes(new String[]{"//", "/ "}));
    }
}

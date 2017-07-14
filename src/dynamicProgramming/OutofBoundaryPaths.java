package dynamicProgramming;
/**
 * 576. Out of Boundary Paths
 * @author ytian
 *
 */
public class OutofBoundaryPaths {
	
	/*
	 * DP[i][j][k] stands for how many possible ways to walk into 
	 * cell j,k in step i, DP[i][j][k] only depends on 
	 * DP[i - 1][j][k], so we can compress 3 dimensional 
	 * dp array to 2 dimensional.
	 */
	public static int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < N; step++) {
        	int[][] t = new int[m][n];
        	for (int r = 0; r < m; r++) {
        		for (int c = 0; c < n; c++) {
        			for (int[] d : dirs) {
        				int nr = r + d[0];
        				int nc = c + d[1];
        				if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
        					res = (res + count[r][c]) % MOD;
        				} else {
        					t[nr][nc] = (t[nr][nc] + count[r][c]) % MOD;
        				}
        			}
        		}
        	}
        	count = t;
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(findPaths(2, 2, 2, 0, 0));
		System.out.println(findPaths(1, 3, 3, 0, 1));
	}

}

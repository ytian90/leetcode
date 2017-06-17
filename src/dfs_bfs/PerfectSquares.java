package dfs_bfs;
/**
 * Perfect Squares
 * @author yutian
 * @since Sep 14, 2015
 */
public class PerfectSquares {
	public int numSquare(int n) {
		while (n % 4 == 0) n /= 4;
		if (n % 8 == 7) return 4;
		for (int a = 0; a * a <= n; ++a) {
			int b = (int) Math.sqrt(n - a * a);
			if (a * a + b * b == n)
				return a == 0 ? 1 : 2;
		}
		return 3;
	}
}

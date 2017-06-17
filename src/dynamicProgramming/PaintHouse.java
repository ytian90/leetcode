package dynamicProgramming;
/**
 * 256. Paint House
 * @author yutian
 * @since Dec 28, 2015
 */
public class PaintHouse {
	// time O(N) space O(3N)
	public static int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
	
	// time O(N) space O(1)
	public static int minCost2(int[][] costs) {
		if (costs == null || costs.length == 0) {
            return 0;
        }
		int n = costs.length, r = 0, b = 0, g = 0;
		for (int i = 0; i < n; i++) {
			int rr = r, bb = b, gg = g;
			r = costs[i][0] + Math.min(bb, gg);
			b = costs[i][1] + Math.min(rr, gg);
			g = costs[i][2] + Math.min(rr, bb);
		}
		return Math.min(Math.min(r, b), g);
	}

	public static void main(String[] args) {
		int[][] t = new int[][]{{2, 3, 4}, {5, 1, 2}, {3, 4, 3}};
		System.out.println(minCost(t));
		
	}

}

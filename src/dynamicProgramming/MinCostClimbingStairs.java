package dynamicProgramming;
/**
 * 746. Min Cost Climbing Stairs
 * @author ytian
 *
 */
public class MinCostClimbingStairs {
	// time O(N), space O(N)
	public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
        		dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 2], dp[n - 1]);
    }
	
	// time O(N), space O(1)
	public static int minCostClimbingStairs1(int[] cost) {
        int c1 = cost[0], c2 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int c0 = cost[i] + Math.min(c1, c2);
            c1 = c2;
            c2 = c0;
        }
        return Math.min(c1, c2);
    }
	
	// time O(N), space O(1)
	public static int minCostClimbingStairs2(int[] cost) {
        int c1 = 0, c2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
        		int c0 = cost[i] + Math.min(c1, c2);
        		c1 = c2;
        		c2 = c0;
        }
        return Math.min(c1, c2);
    }

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}));
		System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}

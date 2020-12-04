package leetcode.dynamicProgramming;
/**
 * 70. Climbing Stairs
 * @author yutian
 * @since Jul 31, 2015
 * 
 * You are climbing a stair case. It takes n steps to 
 * reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
	
	public static void main(String[] args) {
		System.out.println(climbStairs2(4));
	}
	
	// Time ~O(N), Space ~O(N)
	public static int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) return n;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}
	
	// Time ~O(N), Space ~O(1)
	public static int climbStairs2(int n) {
		if (n == 1 || n == 2 || n == 3) return n;
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            int t = b;
            b += a;
            a = t;
        }
        return b;
	}
	
	// what if we can move 1, 2, 3 steps each time
	public static int climbStairs3(int n) {
		if (n == 0 || n == 1 || n == 2) return n;
		if (n == 3) return 4;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for (int i = 3; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n - 1];
	}
	
}

package dynamicProgramming;
/**
 * 343. Integer Break
 * @author yutian
 * @since May 7, 2016
 */
public class IntegerBreak {
	
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
			}
		}
		return dp[n];
	}
	
	public int integerBreak1(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; 2 * j <= i; j++) { // j <= i/2, because when j >=i/2 they are duplicated
				//  no cut on the left part, optimal cut on the right part;
	             //  optimal cut on the left part, no cut on the right part;
	             //  optimal cut on the left part, optimal cut on the right part;
	             //  no cut on the left part, no cut on the right part;
	             // max of(j * opt[i-j]),(opt[j] * (i-j)),(opt[j]*opt[i-j]),(j*(i-j))
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
			}
		}
		return dp[n];
	}
	
	public int integerBreak2(int n) {
		if (n == 2) return 1;
		if (n == 3) return 2;
		int product = 1;
		while (n > 4) {
			product *= 3;
			n -= 3;
		}
		product *= n;
		return product;
	}
	
	public int integerBreak3(int n) {
		if (n == 2) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        else if (n % 3 == 1) return (int) Math.pow(3, n / 3 - 1) * 4;
        else return (int) Math.pow(3, n / 3) * 2;
    }

	public static void main(String[] args) {
		IntegerBreak t = new IntegerBreak();
		System.out.println(t.integerBreak(2));
		System.out.println(t.integerBreak(3));
		System.out.println(t.integerBreak(4));
		System.out.println(t.integerBreak(5));
		System.out.println(t.integerBreak(8));
		
	}

}

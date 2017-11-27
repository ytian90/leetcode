package dynamicProgramming;
/**
 * 651. 4 Keys Keyboard
 * @author ytian
 *
 */
public class FourKeysKeyboard {
	
	public static int maxA(int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; j <= i - 3; j++) {
				dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
			}
		}
		return dp[n];
	}
	
	/*We use i steps to reach maxA(i) then use the remaining 
	 * n - i steps to reach n - i - 1 copies of maxA(i) 
	 * we need to have 3 steps reserved for Ctrl A, Ctrl C, Ctrl V 
	 * so i can be at most n - 3
	 * */
	
	public static int maxA2(int N) {
        int max = N;
        for (int i = 1; i <= N - 3; i++) {
        		max = Math.max(max, maxA2(i) * (N - i - 1));
        }
        return max;
    }
	

	public static void main(String[] args) {
		System.out.println(maxA(3));
		System.out.println(maxA(7));
		System.out.println(maxA(10));
	}

}

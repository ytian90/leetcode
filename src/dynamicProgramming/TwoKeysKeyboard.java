package dynamicProgramming;
/**
 * 650. 2 Keys Keyboard
 * @author ytian
 *
 */
public class TwoKeysKeyboard {
	
	public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
        		dp[i] = i;
        		for (int j = i - 1; j > 1; j--) {
        			if (i % j == 0) {
        				dp[i] = dp[j] + (i / j);
        				break;
        			}
        		}
        }
        return dp[n];
    }
	
	public static int minSteps2(int n) {
		int res = 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				res += i;
				n /= i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(minSteps(3));
		System.out.println(minSteps(4));
		System.out.println(minSteps(8));
		System.out.println(minSteps(64));
		System.out.println(minSteps(1024));
		System.out.println(minSteps(1025));
		System.out.println(minSteps(997));
	}

}

package dynamicProgramming;
/**
 * Decode Ways
 * @author yutian
 * @since Aug 20, 2015
 */
public class DecodeWays {
	/**
	 * Solution 1: 1-d DP
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
		// d(i) = {d(i - 1), if s[i - 1] != '0'} + {d(i-2), if 1X (X = 1..9) or 2X (X = 1...6)}
		// d(0) = 0, but set d(0) = 1 for computing d(i)
		// Time ~ O(N), Space ~ O(N) 
		int n = s.length();
		if (n == 0 || s.charAt(0) == '0') return 0;
		int[] d = new int [n + 1];
		d[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (s.charAt(i - 1) != '0') d[i] += d[i - 1];
			if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				d[i] += d[i - 2];
			}
		}
		return d[n];
	}
	
	/*
	 * "12"
	 *  _ _ _
	 *  1 1 2  
	 */
	
	public static void main(String[] args) {
		System.out.println(numDecodings("12")); // 2
		System.out.println(numDecodings("12312")); // 6
		System.out.println(numDecodings("243214")); // 6
		System.out.println(numDecodings("2706")); // 0
		System.out.println(numDecodings("2701224")); // 0
	}
	
	// 
	public int numDecodings2(String s) {
		// d(i) = {d(i -1), if s[i - 1] != '0'} + {d(i-2), if 1X (X = 1..9) or 2X (X = 1...6)}
		// d(0) = 0, d(1) = 1;
		// 1-d DP: Time ~ O(N), Space ~ O(1)
		int n = s.length();
		if (n == 0 || s.charAt(0) == '0') return 0;
		int prev = 0, curr = 1;
		for (int i = 1; i <= n; i++) {
			if (s.charAt(i - 1) == '0') curr = 0;
			if (i < 2 || !(s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				prev = 0;
			}
			int temp = prev + curr;
			prev = curr;
			curr = temp;
		}
		return curr;
	}
}

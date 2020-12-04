package leetcode.dynamicProgramming;
/**
 * 639. Decode Ways II
 * @author ytian
 *
 */
public class DecodeWays2 {
	
	public static int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = helper(s.charAt(0));
        if (s.length() < 2)
        	return (int) res[0];
        
        res[1] = res[0] * helper(s.charAt(1)) + helper(s.charAt(0), s.charAt(1));
        for (int j = 2; j < s.length(); j++) {
        	long t = res[1];
        	res[1] = (res[1] * helper(s.charAt(j)) + res[0] * helper(s.charAt(j - 1), s.charAt(j))) % 1000000007;
        	res[0] = t;
        }
        return (int) res[1];
    }

	private static long helper(char ch) {
		if (ch == '*') return 9;
		if (ch == '0') return 0;
		return 1;
	}
	
	private static int helper(char x, char y) {
		String str = "" + x + "" + y;
		if (x != '*' && y != '*') {
			if (Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26) {
				return 1;
			}
		} else if (x == '*' && y == '*') {
			return 15;
		} else if (x == '*') {
			if (Integer.parseInt("" + y) >= 0 && Integer.parseInt("" + y) <= 6) {
				return 2;
			} else return 1;
		} else {
			if (Integer.parseInt("" + x) == 1) {
				return 9;
			} else if (Integer.parseInt("" + x) == 2) {
				return 6;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("*"));
		System.out.println(numDecodings("1*"));
	}

}

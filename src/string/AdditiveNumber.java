package string;

import java.math.BigInteger;

/**
 * 306. Additive Number
 * @author yutian
 * @since Jan 26, 2016
 */
public class AdditiveNumber {
	// Recursion
	public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
        	if (num.charAt(0) == '0' && i > 1) return false;
        	BigInteger x1 = new BigInteger(num.substring(0, i));
        	for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
        		if (num.charAt(i) == '0' && j > 1) break;
        		BigInteger x2 = new BigInteger(num.substring(i, i + j));
        		if (isValid(x1, x2, j + i, num)) return true;
        	}
        }
        return false;
    }

	private static boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
		if (start == num.length()) return true;
		x2 = x2.add(x1);
		x1 = x2.subtract(x1);
		String sum = x2.toString();
		return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
	}
	// Iterative
	public static boolean isAdditiveNumber2(String num) {
		int n = num.length();
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 1; Math.max(j, i) <= n - i - j; j++) {
				if (valid(i, j, num)) return true;
			}
		}
		return false;
	}

	private static boolean valid(int i, int j, String num) {
		if (num.charAt(0) == '0' && i > 1) return false;
		if (num.charAt(i) == '0' && j > 1) return false;
		String sum;
		BigInteger x1 = new BigInteger(num.substring(0, i));
		BigInteger x2 = new BigInteger(num.substring(i, i + j));
		for (int start = i + j; start != num.length(); start += sum.length()) {
			x2 = x2.add(x1);
			x1 = x2.subtract(x1);
			sum = x2.toString();
			if (!num.startsWith(sum, start)) return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}

}

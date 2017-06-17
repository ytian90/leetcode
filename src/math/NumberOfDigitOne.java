package math;
/**
 * Number of Digit One
 * https://leetcode.com/discuss/46366/ac-short-java-solution
 * @author yutian
 * @since Aug 12, 2015
 */
public class NumberOfDigitOne {
	public int countDigitOne(int n) {
		int ones = 0, m = 1, r = 1;
		while (n > 0) {
			ones += (n + 8) / 10 * m + (n % 10 == 1 ? r : 0);
			r += n % 10 * m;
			m *= 10;
			n /= 10;
		}
		return ones;
	}
}

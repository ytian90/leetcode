package leetcode.bitManipulation;
/**
 * 231. Power of Two
 * @author yutian
 * @since Aug 2, 2015
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return ((n & n - 1) == 0 && n > 0);
	}

	public boolean isPowerOfTwoo(int n) {
		double x = (double) n;
		while (x > 2) {
			x /= 2;
		}
		return x == 1 || x == 2;
	}
	
	public static void main(String[] args) {
		PowerOfTwo t = new PowerOfTwo();
		System.out.println(t.isPowerOfTwo(0));
		System.out.println(t.isPowerOfTwo(4));
		System.out.println(t.isPowerOfTwo(-2147483648));
	}
}

package math;
/**
 * 7. Reverse Integer
 * @author yutian
 * @since Jul 26, 2015
 */
public class ReverseInteger {
	// Time ~O(N)
	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
			if (Math.abs(res) > Integer.MAX_VALUE) {
				return 0;
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(1534236469)); // reason to use long, will overflow
		System.out.println(reverse(120));
		System.out.println(reverse(12001));
		System.out.println(reverse(Integer.MAX_VALUE));
		System.out.println(reverse(Integer.MIN_VALUE));
	}

}

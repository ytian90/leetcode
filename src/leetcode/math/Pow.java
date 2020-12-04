package leetcode.math;

/**
 * 50. Pow(x, n)
 * 
 * @author yutian
 * @since Aug 12, 2015
 */
public class Pow {
	// Solution 1
	public static double myPow(double x, int n) {
		double result = 1.0;
		for (int i = n; i != 0; i /= 2, x *= x) {
			if ((i & 1) != 0)
				result *= x;
		}
		return n < 0 ? 1.0 / result : result;
	}

	// Solution 2
	public static double myPow2(double x, int n) {
		double temp = x;
		if (n == 0)
			return 1;
		temp = myPow2(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			if (n > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	// Solution 3
	public static double myPow3(double x, int n) {
		if (n < 0)
			return 1.0 / power(x, -n);
		else
			return power(x, n);
	}

	private static double power(double x, int n) {
		if (n == 0)
			return 1;
		double v = myPow3(x, n >> 1);
		if ((n & 1) == 0)
			return v * v;
		else
			return v * v * x;
	}

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 3));
		System.out.println(myPow(2.0, 4));
//		System.out.println(myPow(3.89707, 2)); // 15.18715
//		System.out.println(myPow(34.00515, -3)); // 0.00003
	}
}

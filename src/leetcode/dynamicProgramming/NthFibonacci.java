package leetcode.dynamicProgramming;
/**
 * Nth Fibonacci
 * @author yutian
 * @since Dec 18, 2015
 */
public class NthFibonacci {
	
	// recursion
	// time exponential, space O(n)
	public static int fib1(int n) {
		if (n <= 1) return n;
		return fib1(n - 1) + fib1(n - 2);
	}
	
	// dynamic programming
	// time O(n), space O(n)
	public static int fib2(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
	
	// optimization space use DP
	// time O(n), space O(1)
	public static int fib3(int n) {
		int t1 = 0;
		int t2 = 1;
		int t = 0;
		if (n == 0) return t1;
		for (int i = 2; i <= n; i++) {
			t = t1 + t2;
			t1 = t2;
			t2 = t;
		}
		return t2;
	}

	public static void main(String[] args) {

	}

}

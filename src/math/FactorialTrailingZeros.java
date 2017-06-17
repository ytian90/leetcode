package math;
/**
 * 172. Factorial Trailing Zeros
 * @author yutian
 * @since Aug 2, 2015
 */
public class FactorialTrailingZeros {
	
	public static void main(String[] args) {
		System.out.println(findTrailingZeros(5));
	}
	
	// Time ~ O(log5N), Space ~ O(1) 
	public static int findTrailingZeros(int n) {
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
		return count;
	}
	
	public static int findTrailingZeros2(int n) {
		return n == 0 ? 0 : n / 5 + findTrailingZeros2(n / 5);
	}
	
	// Time ~ O(log5N), Space ~ O(1) 
	public static int findTrailingZeros3(int n) {
		int count = 0;
		while (n > 0) {
			n = n / 5;
			count += n;
		}
		return count;
	}
}

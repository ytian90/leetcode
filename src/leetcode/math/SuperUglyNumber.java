package leetcode.math;
/**
 * 313. Super Ugly Number
 * @author yutian
 * @since Dec 30, 2015
 */
public class SuperUglyNumber {
	
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] result = new int[n];
		result[0] = 1;
		int[] indexes = new int[primes.length];
		for (int i = 1; i < n; i++) {
			result[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				result[i] = Math.min(result[i], primes[j] * result[indexes[j]]);
			}
			for (int j = 0; j < indexes.length; j++) {
				if (result[i] == primes[j] * result[indexes[j]]) {
					indexes[j]++;
				}
			}
		}
		return result[n - 1];
	}

	public static void main(String[] args) {
		int[] test = new int[]{2, 7, 13, 19};
		System.out.println(nthSuperUglyNumber(12, test));
	}

}

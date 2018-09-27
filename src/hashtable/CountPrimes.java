package hashtable;

import java.util.Arrays;

/**
 * Count Primes
 * @author yutian
 * @since Aug 4, 2015
 */
public class CountPrimes {
	// Time ~O(NlogNlogN) Space ~O(N)
	public static int countPrimes(int n) {
		if (n <= 2) return 0;
		// Init an array to track prime numbers
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		for (int i = 2; i * i < n; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j < n; j += i)
					primes[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countPrimes(7));
	}
}

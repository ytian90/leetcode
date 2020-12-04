package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 625. Minimum Factorization
 * @author ytian
 *
 */
public class MinimumFactorization {
	
	public static int smallestFactorization(int n) {
        // Case 1: number is less than 10
		if (n < 10) return n;
		
		// Case 2: Start with 9 and try every possible digit
		List<Integer> res = new ArrayList<>();
		for (int i = 9; i > 1; i--) {
			// If current digit divides n, then store all
			// occurrences of current digit in res
			while (n % i == 0) {
				n /= i;
				res.add(i);
			}
		}
		// If n could not be broken in forms of digits
		if (n != 1) return 0;
		
		// Get the result from the leetcode.array in reverse order
		long result = 0;
		for (int i = res.size() - 1; i >= 0; i--) {
			result = result * 10 + res.get(i);
			if (result > Integer.MAX_VALUE) return 0;
		}
		
		return (int) result;
    }

	public static void main(String[] args) {
		System.out.println(smallestFactorization(48));
		System.out.println(smallestFactorization(15));
		System.out.println(smallestFactorization(17));
	}

}

package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * For this question, we don't need to find out all permutations. We can use formula:
 * where k = i_0 * (n - 1)! + i_1 * (n - 2)! + ... + i_{n - 1} * 0!
 * We only need to determine the coefficients i.
 * @author yutian
 * @since Aug 12, 2015
 */
public class PermutationSequence {
	
	public static String getPermutation(int n, int k) {
		// Time: O(N^2) deleteCharAt() takes linear time, Space: O(N)
		int[] f = new int[n + 1];
		StringBuilder sb = new StringBuilder();
		StringBuilder nums = new StringBuilder();
		
		// create an array of factorial lookup
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			nums.append(i);
			f[i] = f[i - 1] * i;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}
		
		k--; // start from base 0!!
		// create a list of numbers to get indices
		for (int i = n; i >= 1; i--) {
			int index = k / f[i - 1];
			sb.append(nums.charAt(index));
			nums.deleteCharAt(index);
			k %= f[i - 1];
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getPermutation(4, 14));
	}
	
	
	public String getPermutation2(int n, int k) {
		// Time: O(N^2) deleteCharAt() takes linear time, Space: O(N)
		// k = i0 * (n-1)! + i1 * (n-2)! + ... + i{n-1} * 0! => "i0 i1 ... i{n-1}"
		StringBuilder num = new StringBuilder(); // "12..n"
		int[] factorial = new int[n + 1]; // stores 0!, 1!, ..., n!
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			num.append(i);
			factorial[i] = factorial[i - 1] * i;
		}
		k--; // start from base 0!!
		StringBuilder str = new StringBuilder();
		for (int i = n; i >= 1; i--) {
			int index = k / factorial[i - 1];
			str.append(num.charAt(index));
			num.deleteCharAt(index);
			k = k % factorial[i - 1];
		}
		return str.toString();
	}
}

package dynamicProgramming;
/**
 * 357. Count Numbers with Unique Digits
 * https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83041/JAVA-DP-O(1)-solution.
 * @author yutian
 * @since Jul 16, 2016
 */
public class CountNumbersWithUniqueDigits {
	// DP Time O(1)
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		int res = 10;
		int uniqueDigits = 9, availableNum = 9;
		while (n-- > 1 && availableNum > 0) {
			uniqueDigits = uniqueDigits * availableNum;
			res += uniqueDigits;
			availableNum--;
		}
		return res;
    }
	
	// Combination
	public static int countNumbersWithUniqueDigits1(int n) {
		if (n == 0) return 1;
		int total = 10;
		while (n > 1) {
			int r = 9;
			for (int i = 1; i < n; i++) {
				r *= 10 - i;
			}
			total += r;
			n--;
		}
		return total;
	}
	
	public static int countNumbersWithUniqueDigits2(int n) {
		int[] result = new int[]{1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, 8877691};
	    return n > result.length - 1 ? result[result.length - 1] : result[n];
    }
	
	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(10));
	}

}

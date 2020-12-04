package leetcode.dynamicProgramming;
/**
 * 600. Non-negative Integers without Consecutive Ones
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 * @author ytian
 *
 */
public class NonNegativeIntegerswithoutConsecutiveOnes {
	
	public static int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();
        int[] a = new int[n]; // the number of binary strings of length i which do not contain any two consecutive 1’s and which end in 0.
        int[] b = new int[n]; // b[i] be the number of such strings which end in 1
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
        	a[i] = a[i - 1] + b[i - 1];
        	b[i] = a[i - 1];
        }
        int result = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
        	if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
        	if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(findIntegers(5));
		System.out.println(findIntegers(9)); // 1001
		System.out.println(findIntegers(11)); // 1011
		System.out.println(findIntegers(12)); // 1100
	}

}

package leetcode.math;

import java.util.List;

/**
 * Pluse One
 * @author yutian
 * @since Jul 26, 2015
 */
public class PlusOne {
	
	/**
	 * Solution 1
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
				if (i == 0) {
					int[] result = new int[digits.length + 1];
					result[0] = 1;
					System.arraycopy(digits, 0, result, 1, digits.length);
					return result;
				}
			}
		}
		return digits;
	}
	
	/**
	 * Use List
	 * @param digits
	 */
	public static void plusOne(List<Integer> digits) {
		for (int i = digits.size() - 1; i >= 0; i--) {
			int digit = digits.get(i);
			if (digit < 9) {
				digits.set(i, digit + 1);
				return;
			} else {
				digits.set(i, 0);
			}
		}
		digits.add(0);
		digits.set(0, 1);
	}
	
	/**
	 * Use Array
	 * @param digits
	 * @return
	 */
	public static int[] plusOne2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				break;
			} else {
				digits[i] = 0;
			}
		}
		
		if (digits[0] == 0) {
		    int[] n = new int[digits.length + 1];
		    n[0] = 1;
		    for (int i = 1; i < n.length; i++) {
		        n[i] = digits[i - 1];
		    }
		    return n;
		} else {
		    return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{9, 9};
		int[] t2 = new int[]{2, 9};
		int[] t3 = new int[]{3};
		int[] r1 = plusOne(t1);
		for (int e: r1) System.out.print(e + " ");
		int[] r2 = plusOne(t2);
		for (int e: r2) System.out.print(e + " ");
		int[] r3 = plusOne(t3);
		for (int e: r3) System.out.print(e + " ");
	}

}

package leetcode.math;
/**
 * 633. Sum of Square Numbers
 * @author ytian
 *
 */
public class SumofSquareNumbers {
	
	public static boolean judgeSquareSum(int c) {
		if (c <= 1) return true;
		int l = 0, r = (int)Math.sqrt(c);
		while (l <= r) {
			int t = l * l + r * r;
			if (t == c) {
				return true;
			} else if (t < c) {
				l++;
			} else r--;
		}
		return false;
    }

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(0));
		System.out.println(judgeSquareSum(1));
		System.out.println(judgeSquareSum(3));
		System.out.println(judgeSquareSum(1000000));
	}

}

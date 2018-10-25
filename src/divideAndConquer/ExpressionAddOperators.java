package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. Expression Add Operators
 * @author yutian
 * @since Dec 6, 2015
 */
public class ExpressionAddOperators {
	
	/* Time Complexity O(4^n), Space O(n)*/
	public static List<String> addOperators(String num, int target) {
		List<String> list = new ArrayList<>();
		if (num.length() == 0) return list;
		add(num, (long) target, list, "", 0, 0L, 0L);
		return list;
	}

	private static void add(String num, long target, List<String> list, String expr, int pos, long prev, long multi) {
		if (num.length() == pos && target == prev) {
			list.add(expr);
		} else {
			for (int i = pos; i < num.length(); i++) {
				if (i != pos && num.charAt(pos) == '0') return;
				long curr = Long.parseLong(num.substring(pos, i + 1));
				if (pos == 0) {
					add(num, target, list, expr + curr, i + 1, curr, curr);
				} else {
					add(num, target, list, expr + "+" + curr, i + 1, curr + prev, curr);
					add(num, target, list, expr + "-" + curr, i + 1, prev - curr, -curr);
					add(num, target, list, expr + "*" + curr, i + 1, prev - multi + multi * curr, multi * curr);
				}
			}
		}
	}

	/*
	for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right?
	If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, so you want to take
	it out from the existing eval. You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4).
	 */

	public static void main(String[] args) {
		System.out.println(addOperators("123", 6));
		System.out.println(addOperators("232", 8));
		System.out.println(addOperators("105", 5));
		System.out.println(addOperators("00", 0));
		System.out.println(addOperators("3456237490", 9191));
	}

}

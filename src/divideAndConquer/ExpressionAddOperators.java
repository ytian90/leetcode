package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Expression Add Operators
 * @author yutian
 * @since Dec 6, 2015
 */
public class ExpressionAddOperators {
	
	/* Time Complexity O(4^n), Space O(n)*/
	public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }

	private static void helper(List<String> result, String path, String num,
			int target, int pos, long eval, long multi) {
		if (pos == num.length()) {
			if (target == eval) result.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') break;
			long curr = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(result, path + curr, num, target, i + 1, curr, curr);
			} else {
				helper(result, path + "+" + curr, num, target, i + 1, eval + curr, curr);
				helper(result, path + "-" + curr, num, target, i + 1, eval - curr, -curr);
				helper(result, path + "*" + curr, num, target, i + 1, eval + multi * (curr - 1), multi * curr);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(addOperators("123", 6));
//		System.out.println(addOperators("232", 8));
//		System.out.println(addOperators("105", 5));
//		System.out.println(addOperators("00", 0));
//		System.out.println(addOperators("3456237490", 9191));
	}

}

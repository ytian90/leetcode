package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * @author yutian
 * @since Aug 18, 2015
 */
public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		helper("", n, n, n, res);
		return res;
	}

	private static void helper(String s, int left, int right, int n, List<String> res) {
		if (s.length() == 2 * n) {
			res.add(s);
			return;
		}
		if (left > right) return;
		if (left > 0) {
			helper(s + "(", left - 1, right, n, res);
		}
		if (right > 0) {
			helper(s + ")", left, right - 1, n, res);
		}
	}

	// Solution 1
	public static List<String> generateParenthesis1(int n) {
		List<String> list = new ArrayList<>();
		helper("", list, n, n);
		return list;
	}

	private static void helper(String str, List<String> list, int left, int right) {
		if (left > right) return;
		if (left == 0 && right == 0) {
			list.add(str);
			return;
		}
		if (left > 0) helper(str + "(", list, left - 1, right);
		if (right > 0) helper(str + ")", list, left, right - 1);
	}
	
	// Solution 2
	public static List<String> generateParenthesis2(int n) {
		List<String> list = new ArrayList<>();
		addUp(n, 0, 0, new StringBuilder(), list);
		return list;
	}

	private static void addUp(int n, int left, int right, StringBuilder str,
			List<String> list) {
		if (left == n) {
			while (right < n) {
				str.append(')');
				right++;
			}
			list.add(str.toString());
		} else if (left == right) { // the parentheses is str are pairs, only add '('
			addUp(n, left + 1, right, str.append('('), list);
		} else {
			int len = str.length();
			addUp(n, left + 1, right, str.append('('), list);
			str.delete(len, str.length());
			addUp(n, left, right + 1, str.append(')'), list);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
	
}

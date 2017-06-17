package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * @author yutian
 * @since Aug 18, 2015
 */
public class GenerateParentheses {
	// Solution 1
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		helper("", list, n, n);
		return list;
	}

	private void helper(String sublist, List<String> list, int left, int right) {
		if (left > right) return;
		if (left == 0 && right == 0) {
			list.add(sublist);
			return;
		}
		if (left > 0) helper(sublist + "(", list, left - 1, right);
		if (right > 0) helper(sublist + ")", list, left, right - 1);
	}
	
	// Solution 2
	public List<String> generateParenthesis2(int n) {
		List<String> list = new ArrayList<>();
		addUp(n, 0, 0, new StringBuilder(), list);
		return list;
	}

	private void addUp(int n, int left, int right, StringBuilder str,
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
	
}

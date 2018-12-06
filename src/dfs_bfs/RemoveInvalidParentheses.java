package dfs_bfs;

import java.util.*;

/**
 * 301. Remove Invalid Parentheses
 * @author yutian
 * @since Jan 29, 2016
 */
public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		RemoveInvalidParentheses t = new RemoveInvalidParentheses();
		System.out.println(t.removeInvalidParentheses("()())()"));
		System.out.println(t.removeInvalidParentheses("(a)())()"));
		System.out.println(t.removeInvalidParentheses(")("));
		System.out.println(t.removeInvalidParentheses("((())())())()"));
	}
	
	// time ~ n * 2 ^ (n-1)
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s.length() == 0)
			return new ArrayList<>(Arrays.asList(""));
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		visited.add(s);
		queue.add(s);
		boolean found = false;
		while (!queue.isEmpty()) {
			s = queue.poll();
			if (isValid(s)) { // found answer, add to result
				res.add(s);
				found = true;
			}
			if (found) continue;
			// generate all possible states
			for (int i = 0; i < s.length(); i++) {
				// we only try to remove left or right paren
				if (s.charAt(i) == '(' || s.charAt(i) == ')') {
					String t = s.substring(0, i) + s.substring(i + 1);
					if (!visited.contains(t)) {
						// for each state, if it's not visited, add it othe queue
						queue.add(t);
						visited.add(t);
					}
				}
			}
		}
		return res;
	}
	
	private boolean isValid(String s) {
		int count = 0;
		for (Character c : s.toCharArray()) {
			if (c == '(') count++;
			if (c == ')') {
				count--;
				if (count < 0) return false;
			}
		}
		return count == 0;
	}

	/*********************************************************************************************/
	
	public List<String> removeInvalidParentheses1(String s) {
		List<String> res = new ArrayList<>();
		remove(s, res, 0, 0, new char[]{'(', ')'});
		return res;
	}

	private void remove(String s, List<String> res, int li, int lj, char[] par) {
		for (int stack = 0, i = li; i < s.length(); i++) {
			if (s.charAt(i) == par[0]) stack++;
			if (s.charAt(i) == par[1]) stack--;
			if (stack >= 0) continue;
			for (int j = lj; j <= i; j++) {
				if (s.charAt(j) == par[1] && (j == lj || s.charAt(j - 1) != par[1]))
					remove(s.substring(0, j) + s.substring(j + 1), res, i, j, par);
			}
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') {
			remove(reversed, res, 0, 0, new char[]{')', '('});
		} else {
			res.add(reversed);
		}
	}
	
	/*********************************************************************************************/
	// Since there are 2^n substrings, the time complexity is O(2^n)
	public List<String> removeInvalidParentheses2(String s) {
        Set<String> result = new HashSet<>();
        int L = 0, R = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') L++;
        	if (s.charAt(i) == ')') {
        		if (L > 0) L--;
        		else R++;
        	}
        }
        dfs(result, s, 0, L, R, 0, new StringBuilder());
        return new ArrayList<String>(result);
    }
	
	public void dfs(Set<String> result, String s, int i, int L, int R, 
			int open, StringBuilder sb) {
		if (i == s.length() && L == 0 && R == 0 && open == 0) {
			result.add(sb.toString());
			return;
		}
		if (i == s.length() || L < 0 || R < 0 || open < 0) return;
		char c = s.charAt(i);
		int len = sb.length();
		if (c == '(') {
			dfs(result, s, i + 1, L - 1, R, open, sb);
			dfs(result, s, i + 1, L, R, open + 1, sb.append(c));
		} else if (c == ')') {
			dfs(result, s, i + 1, L, R - 1, open, sb);
			dfs(result, s, i + 1, L, R, open - 1, sb.append(c));
		} else {
			dfs(result, s, i + 1, L, R, open, sb.append(c));
		}
		sb.setLength(len);
	}
	/*********************************************************************************************/
	


}

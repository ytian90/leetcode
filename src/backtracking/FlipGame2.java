package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 294. Flip Game 2
 * @author yutian
 * @since Dec 28, 2015
 */
public class FlipGame2 {
	
	static Map<String, Boolean> map = new HashMap<>();
	
	// Solution 1 space O(N)
	public static boolean canWin(String s) {
		if (s == null || s.length() < 2) return false;
		return helper(s);
	}

	private static boolean helper(String s) {
		if (map.containsKey(s)) return map.get(s);
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
				String next = s.substring(0, i) + "--" + s.substring(i + 2);
				if (!helper(next)) {
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
	
	// Solution 2 space O(1) time (N!) - maybe
	public static boolean canWin2(String s) {
		return helper(s.toCharArray());
	}

	private static boolean helper(char[] c) {
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == '-' || c[i + 1] == '-') continue;
			c[i] = c[i + 1] = '-';
			boolean otherWin = helper(c);
			c[i] = c[i + 1] = '+';
			if (!otherWin) return true;
		}
		return false;
	}
	
	// too slow
	public static boolean canWin3(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && 
					!canWin3(s.substring(0, i) + "--" +s.substring(i + 2))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canWin2("+++++"));
	}

}

package array;
/**
 * Given a string with parentheses, return a string with balanced 
 * parentheses by removing the fewest characters possible. 
 * You cannot add anything to the string.
 * http://www.1point3acres.com/bbs/thread-125084-1-1.html
 * @author yutian
 * @since Feb 4, 2016
 */
public class RemoveInvalidParentheses0 {
	
	public static String remove(String s) {
		int N = s.length();
		char[] arr = s.toCharArray();
		int L = 0, R = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == '(') L++;
			if (arr[i] == ')') R++;
			if (R > L) {
				arr[i] = '*';
				R--;
			}
		}
		L = R = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] == ')') R++;
			if (arr[i] == '(') L++;
			if (L > R) {
				arr[i] = '*';
				L--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (arr[i] != '*') sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(remove("()"));
		System.out.println(remove(")("));
		System.out.println(remove("((("));
		System.out.println(remove("()())"));
		System.out.println(remove(")(())("));
		System.out.println(remove("(()()"));
		
	}

}

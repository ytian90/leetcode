package string;
/**
 * Transform to Palindrome
 * http://www.1point3acres.com/bbs/thread-168216-1-1.html
 * .这题记不大清楚了，貌似是给一个字符串，然后把这个字符串变成palindrome，
 * 求需要变的最小步数。每次变到相邻的字母算是一次变化，只能递减变化，
 * 这个其实没差别，哪个大变哪个就好。。。比如说abc->abb->aba，需要变化2次。
 * @author yutian
 * @since Feb 6, 2016
 */
public class TransformToPalindrome {
	
	public static int change(String s) {
		if (s == null || s.length() == 0) return 0;
		char[] arr = s.toCharArray();
		int start = 0, end = arr.length - 1;
		int count = 0;
		while (start < end) {
			if (arr[start] != arr[end]) {
				count += Math.abs(arr[start] - arr[end]);
			}
			start++; end--;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(change("abc"));
		System.out.println(change("abcba"));
		System.out.println(change("abcd"));
	}

}

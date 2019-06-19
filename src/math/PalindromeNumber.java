package math;
/**
 * 9. Palindrome Number
 * @author yutian
 * @since Jul 26, 2015
 */
public class PalindromeNumber {

	// time O(n) space O(1)
	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int res = 0, n = x;
		while (res < n) {
			int t = n % 10;
			res = 10 * res + t;
			n /= 10;
		}
		return (res == n || res / 10 == n);
	}
	
	// Time ~O(2N), Space ~O(1)
	public static boolean isPalindrome2(int x) {
		if (x < 0) return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r) return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(-12));
		System.out.println(isPalindrome(3));
		System.out.println(isPalindrome(12));
		System.out.println(isPalindrome(12331));
		System.out.println(isPalindrome(12321));
	}

}

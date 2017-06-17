package math;
/**
 * 9. Palindrome Number
 * @author yutian
 * @since Jul 26, 2015
 */
public class PalindromeNumber {
	
	// Time ~O(2N), Space ~O(1)
	public static boolean isPalindrome(int x) {
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
//		System.out.println(isPalindrome(12331));
		System.out.println(isPalindrome(12321));
	}

}

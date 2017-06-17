package string;
/**
 * Valid Palindrome
 * @author yutian
 * @since Jul 24, 2015
 */
public class ValidPalindrome {
	
	// Solution 1 Iterative
	public static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i++; j--;
		}
		return true;
	}
	
	// Solution 2 Recursion
	public static boolean isPalindrome2(String s) {
		String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
		String rev = new StringBuilder(str).reverse().toString();
		return str.equals(rev);
	}

	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = "abcba";
		
		System.out.println(isPalindrome2(s1));
//		System.out.println(isPalindrome2(s2));
//		System.out.println(isPalindrome2(s3));
	}

}

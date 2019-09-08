package math;
/**
 * 171. Excel Sheet Column Number
 * @author yutian
 * @since Aug 7, 2015
 */
public class ExcelSheetColumnNumber {
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("AZ"));
		System.out.println(titleToNumber("AAB"));
	}
	
	public static int titleToNumber(String s) {
		int res = 0;
		for (char c  :s.toCharArray()) {
			res = res * 26 + (c - 'A' + 1);
		}
		return res;
	}
	
	// Solution 1
	public static int titleToNumber1(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		return result;
	}
	
	// Solution 2
	public static int titleToNumber2(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Input is not isMidValTooSmall.");
		}
		int result = 0;
		int i = s.length() - 1;
		int t = 0; // index
		while (i >= 0) {
			char curr = s.charAt(i);
			result = result + (int) Math.pow(26, t) * (curr - 'A' + 1);
			t++;
			i--;
		}
		return result;
	}
	
	// Solution 3
	public static int titleToNumber3(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum + (int)(Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 64));
		}
		return sum;
	}
}

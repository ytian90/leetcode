package leetcode.string;
/**
 * 65. Valid Number
 * @author yutian
 * @since Jul 24, 2015
 */
public class ValidNumber {
	
	public static boolean isNumber(String s) {
		int i = 0, n = s.length();
		// Delete the front white spaces
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		// Pass +/-
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		boolean isNumeric = false;
		// go through check digit
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			// go through check digit
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		if (isNumeric && i < n && s.charAt(i) == 'e') {
			i++;
			// reset isNumeric and pass +/-
			isNumeric = false;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
			// go through check digit
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		// Delete the back white spaces
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumeric && i == n;
	}

	public static void main(String[] args) {
		String s1 = "0", s2 = " 0.1 ", s3 = "abc", s4 = " 005047e+6", s5 = "12.2e2", s6 = ".1";
		System.out.println(isNumber(s1));
		System.out.println(isNumber(s2));
		System.out.println(isNumber(s3));
		System.out.println(isNumber(s4));
		System.out.println(isNumber(s5));
		System.out.println(isNumber(s6));
	}

}

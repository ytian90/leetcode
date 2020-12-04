package leetcode.string;
/**
 * String to Integer (atoi)
 * @author yutian
 * @since Jul 24, 2015
 */
public class StringToInteger {
	
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	
	/*
	 * four cases: 
	 * 1. discards all leading whitespaces
	 * 2. sign of the number
	 * 3. overflow
	 * 4. invalid input
	 */
	
	public static int atoi(String str) {
		if (str == null || str.length() == 0) return 0;
		int i = 0, n = str.length();
		// delete white spaces in the front of leetcode.string
		while (i < n && Character.isWhitespace(str.charAt(i))) i++; 
		
		// Check + or -
		int sign = 1;
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		
		// Check overflow
		int num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit > 7) {
				return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
	
		return sign * num;
	}

	public static void main(String[] args) {
		System.out.println(atoi("   +123"));
		System.out.println(atoi("   123"));
		System.out.println(atoi("d   123"));
		System.out.println(atoi("   12d3"));
		System.out.println(atoi("   123afd"));
		System.out.println(atoi("   -123"));
		System.out.println(atoi("2147483647"));
		System.out.println(atoi("2147483648"));
		System.out.println(atoi("-2147483648"));
		System.out.println(atoi("-2147483649"));
		
	}

}

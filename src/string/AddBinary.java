package string;
/**
 * 67. Add Binary
 * @author yutian
 * @since Aug 11, 2015
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
	// Time ~ O(Max{Na, Nb}), Space ~ O(Max{Na, Nb})
	public String addBinary(String a, String b) {
		if (a == null || a.isEmpty()) return b;
		if (b == null || b.isEmpty()) return a;
		int place = 2;
		int na = a.length(), nb = b.length();
		int digit = 0, carry = 0;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < Math.max(na, nb); i++) {
			int da = (i < na) ? Character.getNumericValue(a.charAt(na - 1 - i)): 0;
			int db = (i < nb) ? Character.getNumericValue(b.charAt(nb - 1 - i)): 0;
			int sum = da + db + carry;
			digit = sum % place;
			carry = sum / place;
			str.append(digit);
		}
		if (carry > 0) str.append(carry);
		return str.reverse().toString();
	}
	
	public static void main(String[] args) {
		AddBinary t = new AddBinary();
		System.out.println(t.addBinary("11", ""));
		System.out.println(t.addBinary("", "110"));
		System.out.println(t.addBinary("10", "11"));
		System.out.println(t.addBinary("101", "11"));
		System.out.println(t.addBinary("1", "111"));
		System.out.println(t.addBinary("101", "1100001"));
	}
	
	// Solution 2 bit manipulation
	public String addBinary2(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1, c = 0; // c is carry
		String s = "";
		
		while (i >= 0 || j >= 0 || c == 1) {
			int m = (i < 0) ? 0 : a.charAt(i--) - '0';
			int n = (j < 0) ? 0 : b.charAt(j--) - '0';
			s = (char)('0' + m ^ n ^ c) + s;
			c = (m + n + c) >> 1;
		}
		
		return s;
	}
}

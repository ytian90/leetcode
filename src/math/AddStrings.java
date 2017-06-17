package math;
/**
 * 415. Add Strings
 * @author yutian
 *
 */
public class AddStrings {
	
	public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length(), n = num2.length();
        int max = Math.max(m, n), carry = 0;
        for (int i = 0; i < max; i++) {
        	int val = carry;
        	if (i < m) val += num1.charAt(m - 1 - i) - '0';
        	if (i < n) val += num2.charAt(n - 1 - i) - '0';
        	sb.append(val % 10);
        	carry = val / 10;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
	
	public static String addStrings2(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int m = num1.length(), n = num2.length();
		int carry = 0;
		for (int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
		}
		return sb.reverse().toString();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("123", "8"));
		System.out.println(addStrings("99", "8"));
		System.out.println(addStrings("11", "22"));
	}

}

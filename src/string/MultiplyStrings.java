package string;
/**
 * Multiply Strings
 * @author yutian
 * @since Aug 11, 2015
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		int n = num1.length(), m = num2.length();
		int[] num = new int[n + m];
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				int a = num1.charAt(i) - '0';
				int b = num2.charAt(j) - '0';
				num[i + j] += a * b;
			}
		}
		int carry = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] += carry;
			carry = num[i] / 10;
			num[i] %= 10;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : num) {
			sb.append(i);
		}
		while (sb.charAt(sb.length() - 1) == '0' && sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		MultiplyStrings t = new MultiplyStrings();
		System.out.println(t.multiply("102", "18"));
		System.out.println(t.multiply("0", "0"));
		System.out.println(t.multiply("98", "9"));
		System.out.println(t.multiply("2", "3"));
		System.out.println(t.multiply("123", "456"));
	}
	
	// Solution 1 don't reverse the string better
	public String multiply1(String num1, String num2) {
		int m = num1.length(), n = num2.length();
        int[] p = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                p[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = p.length - 1; i >= 0; i--) {
        		int sum = carry + p[i];
            p[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : p) sb.append(i);
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
	}
	
	// Solution 2 reverse the string 
	public String multiply2(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();
		int[] d = new int[n1.length() + n2.length()];
		
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}
		StringBuilder sb = new StringBuilder();
		// calculate each digit
		for (int i = 0; i < d.length; i++) {
			int mod = d[i] % 10;
			int carry = d[i] / 10;
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			sb.insert(0, mod);
		}
		// remove front 0's
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	
	
}

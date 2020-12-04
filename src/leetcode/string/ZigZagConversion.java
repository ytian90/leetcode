package leetcode.string;
/**
 * 6. ZigZag Conversionß
 * @author yutian
 * @since Aug 3, 2015
 */
public class ZigZagConversion {
	public static String convert(String s, int numRows) {
        if (s == null || numRows <= 0)
        		return "";
        if (numRows == 1)
        		return s;
        StringBuilder result = new StringBuilder();
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
	        	for (int j = i; j < s.length(); j += size) {
	        		result.append(s.charAt(j));
	        		if (i != 0 && i != numRows - 1) { // except the first row and last row
	        			int temp = j + size - 2 * i;
	        			if (temp < s.length()) {
	        				result.append(s.charAt(temp));
	        			}
	        		}
        		}
        }
        return result.toString();
    }
	
	public static String convert2(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
		
		int i = 0;
		while (i < len) {
			for (int j = 0; j < numRows && i < len; j++) // vertically decr
				sb[j].append(c[i++]);
			for (int j = numRows - 2; j >= 1 && i < len; j--) // obliquely incr
				sb[j].append(c[i++]);
		}
		for (int j = 1; j < sb.length; j++)
			sb[0].append(sb[j]);
		return sb[0].toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("A", 1));
		System.out.println(convert("AB", 1));
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}

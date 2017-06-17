package math;
/**
 * Excel Sheet Column Title
 * @author yutian
 * @since Aug 5, 2015
 */
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
        if (n <= 0) {
        	throw new IllegalArgumentException("Input is not valid!");
        }
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
        	n--; // key
        	char ch = (char) (n % 26 + 'A');
        	n /= 26;
        	sb.append(ch);
        }
        
        sb.reverse();
        return sb.toString();
    }
	
	// Solution 2
	public static String convertToTitle2(int n) {
		return n <= 0? "" : convertToTitle2((n - 1) / 26) + (char)('A' + (n - 1) % 26);
	}
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(28));
	}
}

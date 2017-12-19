package string;
/**
 * 443. String Compression
 * @author ytian
 *
 */
public class StringCompression {
	
	public static int compress(char[] chars) {
        if (chars == null || chars.length == 0)
        		return 0;
        int count = 1, j = 0;
        for (int i = 0; i < chars.length; i++) {
        		if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
        			count++;
        		} else {
        			chars[j++] = chars[i];
        			if (count != 1) {
        				String num = String.valueOf(count);
        				for (char c : num.toCharArray()) {
        					chars[j++] = c;
        				}
        			}
        			count = 1;
        		}
        }
		return j;
    }

	public static void main(String[] args) {
		System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
		System.out.println(compress(new char[]{'a'}));
		System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
		System.out.println(compress(new char[]{'a', 'b', 'a', 'b'}));
	}
}

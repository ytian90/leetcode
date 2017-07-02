package hashtable;
/**
 * 389. Find the Difference
 * @author yutian
 * @since Aug 29, 2016
 */
public class FindTheDifference {
	
	public static char findTheDifference(String s, String t) {
		char c = 0;
        for (char a : s.toCharArray()) {
            c ^= a;
        }
        for (char a : t.toCharArray()) {
            c ^= a;
        }
        return c;
    }

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "acdbe"));
	}

}

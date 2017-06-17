package string;
/**
 * 344. Reverse String
 * @author yutian
 * @since May 7, 2016
 */
public class ReverseString {
	
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
    }

	public static void main(String[] args) {
		ReverseString t = new ReverseString();
		System.out.println(t.reverseString("hello"));
	}

}

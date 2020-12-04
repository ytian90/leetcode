package leetcode.string;
/**
 * 58. Length of Last Word
 * @author yutian
 * @since Aug 11, 2015
 */
public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = s.length() - 1;
		while (i > 0 && s.charAt(i) == ' ') {
			i--;
		}
		int j = 0;
		while (i >= 0 && s.charAt(i) != ' ') {
			i--;
			j++;
		}
		return j;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
		System.out.println(lengthOfLastWord(" "));
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord("Hello World "));
	}
}

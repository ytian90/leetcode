package string;
/**
 * Length of Last Word
 * @author yutian
 * @since Aug 11, 2015
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int i = s.length() - 1, count = 0;
		while (i >= 0 && s.charAt(i) == ' ') i--;
		while (i >= 0 && s.charAt(i) != ' ') {
			count++;
			i--;
		}
		return count;
	}
}

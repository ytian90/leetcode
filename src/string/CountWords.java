package string;
/**
 * Count number of words in a string
 * @author yutian
 * @since Dec 13, 2015
 */
public class CountWords {

	public static void main(String[] args) {
		System.out.println(countWords("Hello ! world d"));
		System.out.println(countWords("Hello ! world *"));
		System.out.println(countWords("Hello ! world d*"));
	}
	
	public static int countWords(String s) {
		int counter = 0;
		boolean word = false;
		int endOfLine = s.length() - 1;
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				counter++;
				word = false;
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				counter++;
			}
		}
		return counter;
	}

}

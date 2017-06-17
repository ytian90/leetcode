package string;
/**
 * 557. Reverse Words in a String III
 * @author ytian
 *
 */
public class ReverseWordsInAString3 {
	
	public static String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s1.length; j++) {
        	if (s1[j] == ' ') {
        		reverse(s1, i, j - 1);
        		i = j + 1;
        	}
        }
        reverse(s1, i, s1.length - 1);
        return new String(s1);
    }
	
	public static void reverse(char[] s, int i, int j) {
		while (i < j) {
			char t = s[i];
			s[i] = s[j];
			s[j] = t;
			i++; j--;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));

	}

}

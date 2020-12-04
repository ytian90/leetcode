package leetcode.string;
/**
 * 186. Reverse Words in a String II
 * @author yutian
 * @since Jul 24, 2015
 */
public class ReverseWordsInAString2 {
	// Time ~ O(2N), Space ~ O(1) 
	public static void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
    }
    private static void reverse(char[] s, int begin, int end) {
        while (begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++; end--;
        }
    }
	
	public static void reverseWords2(char[] s) {
		reverse2(s, 0, s.length); // reverse whole leetcode.string
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse2(s, i, j); 
				i = j + 1;
			}
		}
	}

	private static void reverse2(char[] s, int begin, int end) {
		for (int i = 0; i < (end - begin) / 2; i++) {
			char temp = s[begin + i];
			s[begin + i] = s[end - i - 1];
			s[end - i - 1] = temp;
		}
	}

	public static void main(String[] args) {
		String s1 = "the sky is blue";
		String s2 = "hi!";
		System.out.println(String.valueOf(s1.toCharArray()));
		System.out.println(String.valueOf(s2.toCharArray()));
		
	}

}

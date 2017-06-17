package string;
/**
 * 424. Longest Repeating Character Replacement
 * @author yutian
 *
 */
public class LongestRepeatingCharacterReplacement {
	
	public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, max = 0, res = 0;
        for (int end = 0; end < len; end++) {
        	max = Math.max(max, ++count[s.charAt(end) - 'A']);
        	while (end - start + 1 - max > k) {
        		count[s.charAt(start++) - 'A']--;
        	}
        	res = Math.max(res, end - start + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(characterReplacement("ABAB", 2));
		System.out.println(characterReplacement("AABABBA", 1));
	}

}

package leetcode.string;
/**
 * 424. Longest Repeating Character Replacement
 * @author yutian
 *
 */
public class LongestRepeatingCharacterReplacement {
	
	public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int prev = 0, max = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
        	max = Math.max(max, ++count[s.charAt(i) - 'A']);
        	while (i - prev + 1 - max > k) {
        		count[s.charAt(prev++) - 'A']--;
        	}
        	res = Math.max(res, i - prev + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
		System.out.println(characterReplacement("AABABBA", 1));
	}

}

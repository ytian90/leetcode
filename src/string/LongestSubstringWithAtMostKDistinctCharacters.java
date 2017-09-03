package string;
/**
 * 340. Longest Substring with At Most K Distinct Characters
 * @author yutian
 * @since Apr 8, 2016
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
	
	// Method 1: Using sliding window O(N)
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
        	if (count[s.charAt(j)]++ == 0) num++;
        	if (num > k) {
        		// left pointer move forward until some letter is out
        		while (--count[s.charAt(i++)] > 0);
        		num--;
        	}
        	res = Math.max(res, j - i + 1);
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("abaccc", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("abccbcab", 2));
	}

}

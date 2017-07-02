package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * @author yutian
 *
 */
public class FindAllAnagramsInAString {
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
        	return res;
        }
        int[] map = new int[256];
        for (Character c : p.toCharArray()) {
        	map[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
        	// move right pointer, if Character exists (>= 1), reduce count & map's counter by 1
        	if (map[s.charAt(right++)]-- >= 1) count--;
        	if (count == 0) res.add(left);
        	if (right - left == p.length() && map[s.charAt(left++)]++ >= 0)
        		count++;
        }
        return res;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
	}

}

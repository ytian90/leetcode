package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 522. Longest Uncommon Subsequence II
 * @author ytian
 *
 */
public class LongestUncommonSubsequence2 {
	
	public static int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: strs) {
        	for (String sub: helper(s)) {
        		map.put(sub, map.getOrDefault(sub, 0) + 1);
        	}
        }
        int longest = -1;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
        	if (entry.getValue() == 1)
        		longest = Math.max(longest, entry.getKey().length());
        }
        return longest;
    }

	private static Set<String> helper(String s) {
		Set<String> res = new HashSet<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		Set<String> sub = helper(s.substring(1));
		res.addAll(sub);
		for (String ss: sub) {
			res.add(s.charAt(0) + ss);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae"}));
	}

}

package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 691. Stickers to Spell Word
 * @author ytian
 *
 */
public class StickersToSpellWord {
	public static int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] dp = new int[m][26];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
        	for (char c : stickers[i].toCharArray()) {
        		dp[i][c - 'a']++;
        	}
        }
        map.put("", 0);
        return helper(map, dp, target);
    }

	private static int helper(Map<String, Integer> map, int[][] dp, String target) {
		if (map.containsKey(target))
			return map.get(target);
		int ans = Integer.MAX_VALUE, n = dp.length;
		int[] t = new int[26];
		for (char c : target.toCharArray()) {
			t[c - 'a']++;
		}
		for (int i = 0; i < n; i++) {
			// optimization
			if (dp[i][target.charAt(0) - 'a'] == 0)
				continue;
			StringBuilder sb = new StringBuilder();
			// apply a sticker on every character a-z
			for (int j = 0; j < 26; j++) {
				if (t[j] > 0) {
					for (int k = 0; k < Math.max(0, t[j] - dp[i][j]); k++) {
						sb.append((char)('a' + j));
					}
				}
			}
			String s = sb.toString();
			int tmp = helper(map, dp, s);
			if (tmp != -1) ans = Math.min(ans, 1 + tmp);
		}
		map.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
		return map.get(target);
	}
	
	public static void main(String[] args) {
		System.out.println(minStickers(new String[]{"with", "example", "science"}, "thehat"));
		System.out.println(minStickers(new String[]{"notice", "possible"}, "basicbasic"));
	}
}

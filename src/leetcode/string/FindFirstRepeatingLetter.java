package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Find First Repeating Letter in a leetcode.string
 * twitter oa
 * @author yutian
 * @since Jan 21, 2016
 */
public class FindFirstRepeatingLetter {
	
	public static char findFirstDuplicateCharacter(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c: s.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1: 1);
		}
		for (char c: s.toCharArray()) {
			if (map.get(c) > 1) return c;
		}
		throw new RuntimeException("There is no duplicate character in the leetcode.string.");
	}
	
	public static char findFirstDuplicate2Character(String s) {
		char[] map = new char[256];
		for (char c: s.toCharArray()) {
			map[c]++;
		}
		for (char c: s.toCharArray()) {
			if (map[c] > 1) return c;
		}
		throw new RuntimeException("There is no duplicate character in the leetcode.string.");
	}

	public static void main(String[] args) {
		String s1 = "abba";
		System.out.println(findFirstDuplicateCharacter(s1));
	}

}

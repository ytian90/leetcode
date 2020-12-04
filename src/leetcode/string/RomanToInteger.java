package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * @author yutian
 * @since Jul 29, 2015
 */
public class RomanToInteger {
	
	public static void main(String[] args) {
		System.out.println(romanToInt("CD"));
		System.out.println(romanToInt("LXXX"));
		System.out.println(romanToInt("XL"));
	}
	
	private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
				put('I', 1); put('V', 5); put('X', 10);
				put('L', 50); put('C', 100); put('D', 500);
				put('M', 1000);
			}};
			
	public static int romanToInt(String s) {
		int prev = 0, total = 0;
		for (char c : s.toCharArray()) {
			int curr = map.get(c);
			total += (curr > prev) ? (curr - 2 * prev) : curr;
			prev = curr;
		}
		return total;
	}
}

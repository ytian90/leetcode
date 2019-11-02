package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 299. Bulls and Cows
 * @author yutian
 * @since Dec 25, 2015
 */
public class BullsAndCows {
	public static String getHint(String secret, String guess) {
		Map<Character, Integer> map = new HashMap<>();
		int bull = 0, cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			char a = secret.charAt(i), b = guess.charAt(i);
			if (a == b) {
				bull++;
				continue;
			}
			map.put(b, map.getOrDefault(b, 0) + 1);
		}
		for (int i = 0; i < secret.length(); i++) {
			char a = secret.charAt(i), b = guess.charAt(i);
			if (a == b) {
				continue;
			}
			if (map.containsKey(a)) {
				cows++;
				map.put(a, map.get(a) - 1);
				if (map.get(a) == 0) {
					map.remove(a);
				}
			}
		}
		return bull + "A" + cows + "B";
	}

	public static String getHint_opt(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] nums = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			char a = secret.charAt(i), b = guess.charAt(i);
			if (a == b) {
				bulls++;
			} else {
				if (nums[a - '0']++ < 0) cows++;
				if (nums[b - '0']-- > 0) cows++;
			}
		}
		return bulls + "A" + cows + "B";
	}

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810")); // 1A3B
		System.out.println(getHint("1123", "0111")); // 1A1B
		System.out.println(getHint("1122", "2211")); // 0A4B
		System.out.println(getHint("1122", "1222")); // 3A0B
		System.out.println(getHint_opt("1807", "7810")); // 1A3B
		System.out.println(getHint_opt("1123", "0111")); // 1A1B
		System.out.println(getHint_opt("1122", "2211")); // 0A4B
		System.out.println(getHint_opt("1122", "1222")); // 3A0B
	}

}

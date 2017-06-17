package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 247. Strobogrammatic Number II
 * @author yutian
 * @since Jan 6, 2016
 */
public class StrobogrammaticNumber2 {
	
	public static List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	private static List<String> helper(int n, int m) {
		if (n == 0) return new ArrayList<String>(Arrays.asList(""));
		if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		List<String> list = helper(n - 2, m);
		List<String> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (n != m) result.add("0" + s + "0");
			result.add("1" + s + "1");
			result.add("8" + s + "8");
			result.add("6" + s + "9");
			result.add("9" + s + "6");
		}
		return result;
	}
	
	public static List<String> findStrobogrammatic2(int n) {
		List<String> one = Arrays.asList("0", "1", "8"),
					 two = Arrays.asList(""), r = two;
		if (n % 2 == 1) r = one; // odd
		for (int i = (n % 2) + 2; i <= n; i += 2) {
			List<String> next = new ArrayList<>();
			for (String s: r) {
				if (i != n) next.add("0" + s + "0");
				next.add("1" + s + "1");
				next.add("6" + s + "9");
				next.add("8" + s + "8");
				next.add("9" + s + "6");
			}
			r = next;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic2(4));
	}

}

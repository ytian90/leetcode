package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 293. Flip Game
 * @author yutian
 * @since Dec 27, 2015
 */
public class FlipGame {
	
	public static List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i + 1] && c[i] == '+') {
				c[i] = c[i + 1] = '-';
				res.add(new String(c)); // can't use c.toString(), will maxPerformance ["[C@5cad8086","[C@5cad8086","[C@5cad8086"]
				c[i] = c[i + 1] = '+';
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String t1 = "++++";
		String t2 = "++";
		String t3 = "--";
		System.out.println(generatePossibleNextMoves(t1));
		System.out.println(generatePossibleNextMoves(t2));
		System.out.println(generatePossibleNextMoves(t3));
	}

}

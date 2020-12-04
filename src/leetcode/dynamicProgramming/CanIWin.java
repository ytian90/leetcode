package leetcode.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 464. Can I win
 * @author yutian
 *
 */
public class CanIWin {
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        int[] n = new int[maxChoosableInteger];
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(desiredTotal, n, map);
    }

	private boolean helper(int total, int[] state, HashMap<String, Boolean> map) {
		String curr = Arrays.toString(state);
		if (map.containsKey(curr)) return map.get(curr);
		for (int i = 0; i < state.length; i++) {
			if (state[i] == 0) {
				state[i] = 1;
				if (total <= i + 1 || !helper(total - (i + 1), state, map)) {
					map.put(curr, true);
					state[i] = 0;
					return true;
				}
				state[i] = 0;
			}
		}
		map.put(curr, false);
		return false;
	}

	public static void main(String[] args) {
		CanIWin t = new CanIWin();
		System.out.println(t.canIWin(10, 11));
	}

}

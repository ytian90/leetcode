package dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 403. Frog Jump
 * @author yutian
 *
 */
public class FrogJump {
	
	public static boolean canCross(int[] stones) {
		if (stones.length == 0) return true;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{0,1,3,5,6,8,12,17};
		int[] test2 = new int[]{0,1,2,3,4,8,9,11};
		System.out.println(canCross(test));
		System.out.println(canCross(test2));
	}

}

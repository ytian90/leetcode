package company.uuba.mj;

import java.util.HashMap;
import java.util.HashSet;

/**
 * LC 403. Frog Jump
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 *
 * Example 1:
 *
 * Input: stones = [0,1,3,5,6,8,12,17]
 * Output: true
 * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 *
 * Input: stones = [0,1,2,3,4,8,9,11]
 * Output: false
 * Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 */
public class FrogJump {
    public static boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return true;
        }
        int n = stones.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < n - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[n - 1]) {
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

    /**
     * Time: O(N ^ 2)
     * Space: O(N ^ 2)
     */

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}

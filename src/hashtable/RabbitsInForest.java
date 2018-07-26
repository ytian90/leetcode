package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. Rabbits in Forest
 */
public class RabbitsInForest {

    public static int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        for (Integer n : map.keySet()) {
            int group = map.get(n) / (n + 1);
            if (map.get(n) % (n + 1) != 0) {
                res += (group + 1) * (n + 1);
            } else {
                res += group * (n + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1, 1, 2}));
        System.out.println(numRabbits(new int[]{10, 10, 10}));
        System.out.println(numRabbits(new int[]{}));
    }
}

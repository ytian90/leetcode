package company.uber.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 1743. Restore the Array From Adjacent Pairs
 */
public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : adjacentPairs) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            if (!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[1]).add(e[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        for (int i : map.keySet()) {
            if (map.get(i).size() == 1) {
                res[0] = i;
                break;
            }
        }
        int p = 0;
        Integer prev = null;
        while (p < n - 1) {
            for (int next : map.get(res[p])) {
                if (prev == null || next != prev) {
                    prev = res[p];
                    res[++p] = next;
                    break;
                }
            }
        }
        return res;
    }

}

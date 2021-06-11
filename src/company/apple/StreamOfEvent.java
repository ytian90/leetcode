package company.apple;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764267&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class StreamOfEvent {

    public static List<Integer> steamOfEvent(int[][] events, int k) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Set<Integer>> times = new TreeMap<>();
        Map<Integer, Integer> eventMap = new HashMap<>();
        for (int[] e : events) {
            if (eventMap.containsKey(e[0])) {
                int prevTime = eventMap.get(e[0]);
                times.get(prevTime).remove(e[0]);
            } else {
                eventMap.put(e[0], e[1]);
            }
            if (!times.containsKey(e[1])) {
                times.put(e[1], new HashSet<>());
            }
            times.get(e[1]).add(e[0]);
        }
        while (!times.isEmpty() && k > 0) {
            Set<Integer> set = times.lastEntry().getValue();
            if (set.size() <= k) {
                res.addAll(set);
                k -= set.size();
                times.remove(times.lastKey());
            } else {
                for (int i : set) {
                    res.add(i);
                    k--;
                    if (k == 0) break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(steamOfEvent(new int[][]{
                {1, 200}, {5, 300}, {2, 300}, {5, 400}, {3, 100}
        }, 3));
    }
}

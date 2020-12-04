package leetcode.mj.google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * lc621
 */
public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.addAll(map.values());
        Map<Integer, Integer> coolDown = new HashMap<>();
        int curr = 0;
        while (!pq.isEmpty() || !coolDown.isEmpty()) {
            if (coolDown.containsKey(curr - n - 1)) {
                pq.add(coolDown.remove(curr - n - 1));
            }
            if (!pq.isEmpty()) {
                int rest = pq.poll() - 1;
                if (rest != 0) {
                    coolDown.put(curr, rest);
                }
            }
            curr++;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}

package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 621. Task Scheduler
 * @author ytian
 *
 */
public class TaskScheduler {
	
	public static int leastInterval(char[] tasks, int n) {
		if (n == 0) return tasks.length;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (char c : map.keySet()) {
			pq.offer(map.get(c));
		}
		
		// <current_time, count_down>
		Map<Integer, Integer> coolDown = new HashMap<>();
		int curr = 0;
		while (!pq.isEmpty() || !coolDown.isEmpty()) {
			if (coolDown.containsKey(curr - n - 1)) {
				pq.offer(coolDown.remove(curr - n - 1));
			}
			if (!pq.isEmpty()) {
				int left = pq.poll() - 1;
				if (left != 0) coolDown.put(curr, left);
			}
			curr++;
		}
		return curr;
	}
	
	public static int leastInterval2(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        
        int[] c = new int[26];
        for (char t : tasks) {
        	c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) i--;
        
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

	public static void main(String[] args) {
		char[] t = new char[]{'A','A','A','B','B','B'};
		System.out.println(leastInterval(t, 2));
	}

}

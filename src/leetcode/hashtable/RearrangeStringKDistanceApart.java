package leetcode.hashtable;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 358. Rearrange String k Distance Apart
 * @author yutian
 * @since Jul 16, 2016
 */
public class RearrangeStringKDistanceApart {

	public static String rearrangeString(String s, int k) {
		if (k == 0 || s.length() == 0) {
			return s;
		}
		int[] freq = new int[26];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		Queue<int[]> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				pq.add(new int[]{i, freq[i]});
			}
		}
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			sb.append((char) (curr[0] + 'a'));
			curr[1]--;
			q.add(curr);
			if (q.size() >= k) {
				int[] front = q.poll();
				if (front[1] > 0) {
					pq.add(front);
				}
			}
		}
		return sb.length() == s.length() ? sb.toString() : "";
	}

	public static void main(String[] args) {
		System.out.println(rearrangeString("aabbcc", 3));
		System.out.println(rearrangeString("aaabc", 3));
		System.out.println(rearrangeString("aaadbbcc", 3));
	}

}

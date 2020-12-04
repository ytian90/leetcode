package leetcode.greedy;

import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 */
public class ReorganizeString {
    public static String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int[] map = new int[26];
        for (char c : S.toCharArray()) {
            map[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                pq.add(new int[]{i, map[i]});
            }
        }
        int[] prev = new int[]{-1, -1}, curr;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            curr = pq.poll();
            curr[1]--;
            sb.append((char) ('a' + curr[0]));

            if (prev[1] > 0) {
                pq.add(prev);
            }

            prev = curr;
        }
        return sb.length() == S.length() ? sb.toString(): "";
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}

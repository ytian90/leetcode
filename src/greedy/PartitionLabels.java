package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. Partition Labels
 */
public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        for (int i = 0, end = -1; i < S.length() && end != S.length() - 1; i++) {
            char c = S.charAt(i);
            end = map.get(c);
            for (int j = i; j < end; j++) {
                if (S.charAt(j) == c) {
                    continue;
                }
                int temp = map.get(S.charAt(j));
                end = Math.max(end, temp);
            }
            res.add(end - i + 1);
            i = end;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eaaaabaaec"));
    }

    public static List<Integer> partitionLabels1(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int currMax = 0, prev = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            currMax = Math.max(currMax, map[c - 'a']);
            if (i == currMax) {
                res.add(i - prev);
                prev = i;
                currMax = 0;
            }
        }
        return res;
    }

    public static List<Integer> partitionLabels2(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0, start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }


}

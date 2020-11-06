package util;

import java.util.*;

public class temp {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.get(c) == null) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        for (int i = 0, end = -1; i < S.length(); i++) {
            char c = S.charAt(i);
            end = map.get(c).get(map.get(c).size() - 1);
            for (int j = i; j < end; j++) {
                if (S.charAt(j) == c) {
                    continue;
                }
                int temp = map.get(S.charAt(j)).get(map.get(S.charAt(j)).size() - 1);
                end = Math.max(end, temp);
            }
            res.add(end - i + 1);
            i = end;
            if (end == S.length() - 1) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}

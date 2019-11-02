package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1087. Brace Expansion
 */
public class BraceExpansion {
    public static String[] expand(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        String[] strs = S.split("[{}]");
        Queue<String> q = new LinkedList<>();
        for (String s : strs) {
            if (s == null || s.length() == 0) {
                continue;
            }
            int size = q.size();
            String[] chars = s.split(",");
            Arrays.sort(chars);
            if (q.size() == 0) {
                q.addAll(Arrays.asList(chars));
            }
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (String c : chars) {
                    if (c == null || c.length() == 0) {
                        continue;
                    }
                    q.add(curr + c);
                }
            }
        }
        return q.toArray(new String[q.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(expand("{a,b}c{d,e}f")));
        System.out.println(Arrays.toString(expand("abcd")));
    }
}

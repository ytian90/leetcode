package mj.google;

import java.util.*;

/**
 * lc1087 & lc1096
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

    public static List<String> braceExpansionII(String expression) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(expression);
        helper(set, stack);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    private static void helper(Set<String> set, Stack<String> stack) {
        while (!stack.isEmpty()) {
            String curr = stack.pop();
            if (curr.indexOf('{') == -1) {
                if (!set.contains(curr)) {
                    set.add(curr);
                }
                continue;
            }
            int i = 0, l = 0, r = 0;
            while (curr.charAt(i) != '}') {
                if (curr.charAt(i++) == '{') {
                    l = i - 1;
                }
            }
            r = i;

            String before = curr.substring(0, l);
            String after = curr.substring(r + 1);
            String[] middle = curr.substring(l + 1, r).split(",");
            for (String s : middle) {
                stack.push(before + s + after);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(braceExpansionII("{a,b}{c,{d,e}}"));
        System.out.println(braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
}

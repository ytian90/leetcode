package bitManipulation;

import java.util.*;

/**
 * 756. Pyramid Transition Matrix
 */
public class PyramidTransitionMatrix {

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s.substring(2));
        }
        return helper(bottom, map);
    }

    private static boolean helper(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1)
            return true;
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2)))
                return false;
        }
        List<String> list = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), list, map);
        for (String s : list) {
            if (helper(s, map)) return true;
        }
        return false;
    }

    private static void getList(String bottom, int index, StringBuilder sb, List<String> list, Map<String, List<String>> map) {
        if (index == bottom.length() - 1) {
            list.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(index, index + 2))) {
            sb.append(s);
            getList(bottom, index + 1, sb, list, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(pyramidTransition("XYZ",
                new ArrayList<>(Arrays.asList("XYD", "YZE", "DEA", "FFF"))));
    }
}

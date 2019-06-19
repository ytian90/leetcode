package mj.houzz;

import java.util.*;

/**
 * Given multiple lists, each list contains few integer numbers
 * We want to maxPerformance all the possible combinations within those lists, with the following condition:
 * *** one combination should contain one and at MOST one element from each list ***
 *
 * Example: input => [[1,2], [3,4]]
 * output = [[1, 3], [1, 4], [2, 3], [2, 4]]  // 8
 *
 * 要求用两种方法，都先排序，一个是用Index判断去重，还有一个是用set判断去重
 * 问了时间空间复杂度，最好和最坏情况
 */
public class ListCombinations {

    /*
    k : lists size
    N : lists[0] size

    time O(k * N!/((N-k)!k!))
    space O(N!/((N-k)!k!))
     */

    public static Set<List<Integer>> find(List<List<Integer>> lists) {
        Set<List<Integer>> res = new HashSet<>();
        if (lists == null || lists.size() == 0) {
            return res;
        }
        for (List<Integer> l : lists) {
            Collections.sort(l);
        }
        List<Integer> list = new ArrayList<>();
        helper(lists, list, res, 0);
        return res;
    }

    private static void helper(List<List<Integer>> lists, List<Integer> list, Set<List<Integer>> res, int start) {
        if (list.size() == lists.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < lists.size(); i++) {
            List<Integer> l = lists.get(i);
            for (Integer n : l) {
                list.add(n);
                helper(lists, list, res, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(2, 1)));
        t.add(new ArrayList<>(Arrays.asList(2, 2)));
        System.out.println(find(t));
    }

}

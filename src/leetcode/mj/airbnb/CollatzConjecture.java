package leetcode.mj.airbnb;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Collatz Conjecture
 * https://en.wikipedia.org/wiki/Collatz_conjecture
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=273149
 */
public class CollatzConjecture {

    static Map<Integer, Integer> map = new HashMap<>();

    public static int findSteps(int num) {
        if (num <= 1) return 1;
        if (map.containsKey(num)) return map.get(num);
        if (num % 2 == 0) return 1 + findSteps(num / 2);
        else return 1 + findSteps(3 * num + 1);
    }

    public static int findLongestSteps(int num) {
        if (num < 1) return 0;
        int res = 0;
        for (int i = 1; i < num; i++) {
            int t = findSteps(i);
            map.put(i, t);
            res = Math.max(res, t);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSteps(8));
    }
}

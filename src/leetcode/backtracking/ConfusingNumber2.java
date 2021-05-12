package leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1088. Confusing Number II
 */
public class ConfusingNumber2 {
    Map<Integer, Integer> map;
    int N, res;

    public int confusingNumber(int N) {
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        res = 0;
        if (N == 1000000000) {
            res++;
            N--;
        }
        this.N = N;
        search(0, 0);
        return res;
    }

    private void search(int p, int curr) {
        if (p > 9 || curr > N) {
            return;
        }
        if (isConfusing(curr)) {
            res++;
        }
        for (Integer d : map.keySet()) {
            if (p == 0 && d == 0) {
                continue;
            }
            search(p + 1, curr * 10 + d);
        }
    }

    private boolean isConfusing(int n) {
        long res = 0;
        int ori = n;
        while (n > 0) {
            res = res * 10 + map.get(n % 10);
            n /= 10;
        }
        return ori != res;
    }

    public static void main(String[] args) {
        ConfusingNumber2 obj = new ConfusingNumber2();
        System.out.println(obj.confusingNumber(20));
    }
}

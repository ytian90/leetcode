package leetcode.uber;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个长度一样的数组 求满足a[i] - b[j] = a[j] - b[i] 的pair的个数 只能o(n)才能过所有的testcase
 *
 * 然后从0到n-1扫一遍 获得每个i的两个array的和 看每个和有多少个frequency就能得出一共有多少个pair了
 */
public class EqualPairs {
    public int countPairs(int[] a, int[] b) {
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = a[i] + b[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            res += (map.get(key) * (map.get(key) - 1)) / 2; // n * (n - 1) / 2
        }
        return res;
    }


}

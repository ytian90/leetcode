package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 710. Random Pick with Blacklist
 */
public class RandomPickWithBlacklist {

    int M;
    Random r;
    Map<Integer, Integer> map;

    public RandomPickWithBlacklist(int N, int[] blacklist) {
        map = new HashMap();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        M = N - map.size();

        for (int b : blacklist) { // O(B)
            if (b < M) { // re-mapping
                while (map.containsKey(N - 1))
                    N--;
                map.put(b, N - 1);
                N--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }
    public static void main(String[] args) {
        RandomPickWithBlacklist o = new RandomPickWithBlacklist(3, new int[]{0});
        int count1 = 0, count2 = 0, count0 = 0;
        for (int i = 0; i < 1000; i++) {
            int n = o.pick();
            if (n == 1) {
                count1++;
            }
            else if (n == 2) {
                count2++;
            }
            else if (n == 0) {
                count0++;
            }
        }
        System.out.println("0: " + count0);
        System.out.println("1: " + count1);
        System.out.println("2: " + count2);

    }
}

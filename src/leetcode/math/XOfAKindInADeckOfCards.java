package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 */
public class XOfAKindInADeckOfCards {

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.values()) {
            res = gcd(i, res);
        }
        return res > 1;
    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));

    }
}

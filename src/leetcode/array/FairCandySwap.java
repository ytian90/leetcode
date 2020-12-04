package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 888. Fair Candy Swap
 */
public class FairCandySwap {

    public static int[] fairCandySwap(int[] A, int[] B) {
        int diff = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        for (int b : B) {
            if (set.contains(b + diff))
                return new int[]{b + diff, b};
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{2}, new int[]{1, 3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }
}

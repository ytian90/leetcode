package binarySearch;

import java.util.Arrays;

/**
 * 475. Heaters
 */
public class Heaters {

    // Time complexity: max(O(nlogn), O(mlogn)) - m is the length of houses, n is the length of heaters.
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int i = Arrays.binarySearch(heaters, house);
            if (i < 0) {
                i = - (i + 1);
            }
            int d1 = (i == 0) ? Integer.MAX_VALUE : house - heaters[i - 1];
            int d2 = (i == heaters.length) ? Integer.MAX_VALUE : heaters[i] - house;
            res = Math.max(res, Math.min(d1, d2));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }
}

package company.lnkin;

/**
 * LC 605. Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However,
 * flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, len = flowerbed.length;
        for (int i = 0; i < len && count < n; i++) {
            if (flowerbed[i] == 0) {
                int left = (i == 0) ? 0 : flowerbed[i - 1];
                int right = (i == len - 1) ? 0 : flowerbed[i + 1];
                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    count++;
                    if (count > n) {
                        return true;
                    }
                }
            }
        }
        return count == n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }
}

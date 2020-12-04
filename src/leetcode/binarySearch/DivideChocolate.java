package leetcode.binarySearch;

/**
 * 1231. Divide Chocolate
 */
public class DivideChocolate {
    public static int maximizeSweetness(int[] sweetness, int K) {
        int left = 1, right = (int) 1e9 / (K + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int curr = 0, count = 0;
            for (int a : sweetness) {
                if ((curr + a) > mid) {
                    curr = 0;
                    if (++count > K) break;
                }
            }
            if (count > K) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

package leetcode.uber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/786178/minimum-peaks
 *
 * Given an array of pairwise distinct positive integers arr=[1,9,7,8,2,6] populate the result array by returning minimum peaks .
 * a[i-1]<a[i]>a[i+1]
 * First min peak= 6 [1,9,7,8,2]
 * Second min peak=8 [1,9,7,2]
 * Third min peak=9 [1,7,2]
 * Fourth min peak=7 [1,2]
 * Fifth min peak= 2 [1]
 * Sixth min peak=1
 *
 * output: [6,8,9,7,2,1]
 */
public class minPeaks {

    public static int[] minPeaks(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> list = new LinkedList<>();
        for (int i : nums) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE / 2;
            int index = -1;
            int size = list.size();
            if (size == 1) {
                min = list.get(0);
                index = 0;
            } else {
                for (int j = 0; j < size; j++) {
                    if (j == 0 && list.get(j) > list.get(j + 1) && min > list.get(j) ||
                        j == size - 1 && list.get(j) > list.get(j - 1) && min > list.get(j) ||
                        j - 1 >= 0 && j + 1 < size && list.get(j) > list.get(j - 1) && list.get(j) > list.get(j + 1) && min > list.get(j)) {
                        min = list.get(j);
                        index = j;
                    }
                }
            }
            list.remove(index);
            res[i] = min;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minPeaks(new int[]{1, 9, 7, 8, 2, 6})));
    }
}

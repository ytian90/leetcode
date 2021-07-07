package company.uuba.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 315. Count of Smaller Numbers After Self
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example 1:
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Example 2:
 *
 * Input: nums = [-1]
 * Output: [0]
 * Example 3:
 *
 * Input: nums = [-1,-1]
 * Output: [0,0]
 */
public class CountOfSmallerNumbersAfterSelf {
    int[] count;
    int[] temp;
    int[] nums;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.count = new int[n];
        this.temp = new int[n];
        this.nums = nums;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(index, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int a : count) {
            res.add(a);
        }
        return res;
    }

    private void mergeSort(int[] index, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(index, start, mid);
        mergeSort(index, mid + 1, end);
        merge(index, start, mid, end);
    }

    private void merge(int[] index, int start, int mid, int end) {
        int rightCount = 0;
        int i = start, j = mid + 1, k = start;
        for (int a = start; a <= end; a++) {
            temp[a] = index[a];
        }
        while (i <= mid || j <= end) {
            if (i > mid || j <= end && nums[temp[i]] > nums[temp[j]]) {
                rightCount++;
                index[k++] = temp[j++];
            } else {
                count[temp[i]] += rightCount;
                index[k++] = temp[i++];
            }
        }
    }
    /**
     * Time: O(N * logN), where N is the size of array
     * Space: O(N)
     */
}

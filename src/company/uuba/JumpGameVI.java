package company.uuba;

import java.util.LinkedList;

/**
 * LC 1696. Jump Game VI
 * You are given a 0-indexed integer array nums and an integer k.
 *
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
 *
 * You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.
 *
 * Return the maximum score you can get.
 *
 * Example 1:
 *
 * Input: nums = [1,-1,-2,4,-7,3], k = 2
 * Output: 7
 * Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
 * Example 2:
 *
 * Input: nums = [10,-5,-2,4,0,3], k = 3
 * Output: 17
 * Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
 * Example 3:
 *
 * Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * Output: 0
 */
public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int max = q.isEmpty() ? 0 : nums[q.peekFirst()];
            nums[i] += max;
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.add(i);
            while (!q.isEmpty() && i - q.peekFirst() + 1 > k) {
                q.pollFirst();
            }
        }
        return nums[nums.length - 1];
    }
    /**
     * Time: O(N)
     * Space: O(K)
     *
     * nums = [10,-5,-2,4,0,3], k = 3
     * we are looping each element,
     * At each position,
     *
     * We are picking maximum value from previous choices.
     * Add that maximum value into curr element and update in nums array.
     * Add updated curr value in the queue.
     * We start from 0th index, it does not have previous elements, we are adding current element in the queue.
     * queue = []
     *
     * At index 1 has one choice. So maximum at this position is 10 and curr element is -5 (10-5) =5.
     * queue = [10]
     *
     * At index 2 has two choices, so maximum is 10 and curr element is -2 (10-2)=8;
     * queue = [10,5]
     *
     * At index 3 has three choices, maximum is 10 and curr is 4 (10+4)=14.
     * // in Dequeue, to maintain the max element, we removing smallest element from queue.
     * // in below queue, 8 is maximum than 5, so we are removing 5 from the queue.
     * queue = [10,5,8] ->queue = [10,8]
     *
     * // when insert 14, 14 is maximum than 8,10. so we are removing them
     * queue = [10,8] ->queue = [14]
     *
     * At index 4, the max is 14 and curr is 0, 14+0 = 14
     * queue = [14]
     *
     * At index 5, the max is 14 and curr is 3, So 14+3=17
     * queue = [14]
     */
}

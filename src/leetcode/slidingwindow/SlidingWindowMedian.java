package leetcode.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 480. Sliding Window Median
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        PQ q = new PQ();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (q.size() == k) {
                res[index++] = q.getMedian();
                q.remove(nums[i + 1 - k]);
            }
        }
        return res;
    }

    class PQ {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        void add(int num) {
            minPQ.add(num);
            maxPQ.add(minPQ.poll());
            if (maxPQ.size() > minPQ.size()) {
                minPQ.add(maxPQ.poll());
            }
        }

        double getMedian() {
            return maxPQ.size() < minPQ.size() ? minPQ.peek() : ((double) maxPQ.peek() + minPQ.peek()) / 2;
        }

        int size() {
            return maxPQ.size() + minPQ.size();
        }

        boolean remove(int x) {
            return maxPQ.remove(x) || minPQ.remove(x);
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian obj = new SlidingWindowMedian();
        System.out.println(Arrays.toString(obj.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(obj.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4)));
    }
}

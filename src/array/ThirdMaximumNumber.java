package array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 414. Third Maximum Number
 * @author yutian
 *
 */
public class ThirdMaximumNumber {

    public static int thirdMxx(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                pq.add(n);
                set.add(n);
                if (pq.size() > 3) {
                    set.remove(pq.remove());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) pq.remove();
        }
        return pq.peek();
    }
	
	public static int thirdMax(int[] nums) {
		Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

	public static void main(String[] args) {
        System.out.println(thirdMxx(new int[]{3, 2, 1}));
        System.out.println(thirdMxx(new int[]{1, 2}));
        System.out.println(thirdMxx(new int[]{2, 2, 3, 1}));

	}

}

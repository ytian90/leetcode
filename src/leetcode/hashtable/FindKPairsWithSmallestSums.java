package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * @author yutian
 * @since Jul 17, 2016
 */
public class FindKPairsWithSmallestSums {
	
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
        	return res;
        }
        int[] index = new int[nums1.length];
        while (k-- > 0) {
        	int min_val = Integer.MAX_VALUE;
        	int in = -1;
        	for (int i = 0; i < nums1.length; i++) {
        		if (index[i] >= nums2.length) {
        			continue;
        		}
        		if (nums1[i] + nums2[index[i]] < min_val) {
        			min_val = nums1[i] + nums2[index[i]];
        			in = i;
        		}
        	}
        	if (in == -1) {
        		break;
        	}
        	int[] temp = {nums1[in], nums2[index[in]]};
        	res.add(temp);
        	index[in]++;
        }
        return res;
    }
	
	public static List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new LinkedList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return res;
		}
		// min priority queue
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
			}
		});
		pq.offer(new int[]{0, 0});
		while (k > 0 && !pq.isEmpty()) {
			int[] p = pq.poll();
			int i = p[0], j = p[1];
			res.add(new int[]{nums1[i], nums2[j]});
			k--;
			if (j + 1 < nums2.length) {
				pq.offer(new int[]{i, j + 1});
			}
			if (j == 0 && i + 1 < nums1.length) {
				pq.offer(new int[]{i + 1, 0});
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] t1 = new int[]{1, 7, 11};
		int[] t2 = new int[]{2, 4, 6};
		int[] t3 = new int[]{1, 1, 2};
		int[] t4 = new int[]{1, 2, 3};
		int[] t5 = new int[]{1, 2};
		int[] t6 = new int[]{3};
		
		for (int[] a : kSmallestPairs2(t1, t2, 3)) {
			System.out.println("[" + a[0] + ", " + a[1] + "]");
		}
		System.out.println();
		for (int[] a : kSmallestPairs2(t3, t4, 2)) {
			System.out.println("[" + a[0] + ", " + a[1] + "]");
		}
		System.out.println();
		for (int[] a : kSmallestPairs2(t5, t6, 3)) {
			System.out.println("[" + a[0] + ", " + a[1] + "]");
		}
		
		
		
		
	}

}

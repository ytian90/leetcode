package array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 350. Intersection of Two Arrays 2
 * @author yutian
 * @since May 28, 2016
 */
public class IntersectionOfTwoArrays2 {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int n : nums1) {
        	map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
        	if (map.containsKey(n) && map.get(n) > 0) {
        		result.add(n);
        		map.put(n, map.get(n) - 1);
        	}
        }
        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }
        return r;
    }

	public static void main(String[] args) {
		int[] t1 = new int[]{1, 2, 2, 1};
		int[] t2 = new int[]{2, 2};
		IntersectionOfTwoArrays2 t = new IntersectionOfTwoArrays2();
		for (int i : t.intersect(t1, t2)) {
			System.out.print(i + " ");
		}
	}

}

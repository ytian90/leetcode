package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * @author ytian
 *
 */
public class MaximumDistanceinArrays {
	
	public static int maxDistance(List<List<Integer>> arrays) {
        int res = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
        	int cmax = arrays.get(i).get(arrays.get(i).size() - 1);
        	int cmin = arrays.get(i).get(0);
        	int cres = Math.max(Math.abs(max - cmin), Math.abs(min - cmax));
        	res = Math.max(res, cres);
        	max = Math.max(max, cmax);
        	min = Math.min(min, cmin);
        }
        return res;
    }

	public static void main(String[] args) {
		List<List<Integer>> t = new ArrayList<>();
		t.add(Arrays.asList(1, 2, 3));
		t.add(Arrays.asList(4, 5));
		t.add(Arrays.asList(1, 2, 3));
		
		System.out.println(maxDistance(t));
	}
}

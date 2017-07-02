package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * @author ytian
 *
 */
public class MinimumIndexSumofTwoLists {
	
	public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
        	map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
        	Integer j = map.get(list2[i]);
        	if (j != null && i + j <= min) {
        		if (i + j < min) {
        			res.clear();
        			min = i + j;
        		}
        		res.add(list2[i]);
        	}
        }
        return res.toArray(new String[res.size()]);
    }

	public static void main(String[] args) {
		// case 1: only on same
		String[] t1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] t2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		System.out.println(Arrays.toString(findRestaurant(t1, t2)));
		
		// case 2: multiple same, choose minimum index sum
		String[] t3 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] t4 = new String[]{"KFC", "Shogun", "Burger King"};
		System.out.println(Arrays.toString(findRestaurant(t3, t4)));
		
		// case 3: same index sum, return both
		String[] t5 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] t6 = new String[]{"Tapioca Express", "Shogun", "Burger King"};
		System.out.println(Arrays.toString(findRestaurant(t5, t6)));

	}

}

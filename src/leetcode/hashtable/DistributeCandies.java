package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies
 * @author ytian
 *
 */
public class DistributeCandies {
	
	public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c: candies) {
        	set.add(c);
        }
        return Math.min(set.size(), candies.length / 2);
    }

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
		System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
		System.out.println(distributeCandies(new int[]{1, 1, 1, 1, 2, 3}));
		System.out.println(distributeCandies(new int[]{1, 1, 2, 3, 4, 5}));
	}

}

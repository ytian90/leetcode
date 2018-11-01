package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * @author yutian
 * @since Aug 31, 2016
 */
public class InsertDeleteGetRandomO1DuplicatesAllowed {
	
	ArrayList<Integer> nums;
	HashMap<Integer, Set<Integer>> locs; // change value to Set<Integer>
	Random random;
	
	 /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1DuplicatesAllowed() {
    	nums = new ArrayList<>();
        locs = new HashMap<Integer, Set<Integer>>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean contain = locs.containsKey(val);
        if (!contain)
        	locs.put(val, new LinkedHashSet<>());
        locs.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if (loc < nums.size() - 1) {
        	int lastone = nums.get(nums.size() - 1);
        	nums.set(loc, lastone);
        	locs.get(lastone).remove(nums.size() - 1);
        	locs.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);

        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

	public static void main(String[] args) {
        InsertDeleteGetRandomO1DuplicatesAllowed obj = new InsertDeleteGetRandomO1DuplicatesAllowed();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
	}

}

package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * @author yutian
 * @since Aug 31, 2016
 */
public class InsertDeleteGetRandomO1 {
	
	ArrayList<Integer> nums;
	HashMap<Integer, Integer> locs;
	Random random;
	
	/** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        nums = new ArrayList<>();
        locs = new HashMap<Integer, Integer>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if (!locs.containsKey(val)) return false;
    	int loc = locs.get(val);
    	if (loc < nums.size() - 1) { // not the last one than swap the last one with this value
    		int lastone = nums.get(nums.size() - 1);
    		nums.set(loc, lastone);
    		locs.put(lastone, loc);
    	}
    	locs.remove(val);
    	nums.remove(nums.size() - 1);
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

	public static void main(String[] args) {

	}

}

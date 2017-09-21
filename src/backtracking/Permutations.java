package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 * @author yutian
 * @since Aug 18, 2015
 */
public class Permutations {
	
	// Solution 2: backtracking time ~O(N!) Space ~O(N)
	
    public List<List<Integer>> permute2(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, list, res);
        return res;
    }
    
    private void helper(int[] n, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == n.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i : n) {
            if (list.contains(i)) continue;
            list.add(i);
            helper(n, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> permute5(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (nums == null || nums.length == 0)
    		return res;
    	
    	List<Integer> list = new ArrayList<>();
    	list.add(nums[0]);
    	res.add(list);
    	for (int i = 1; i < nums.length; i++) {
    		List<List<Integer>> res2 = new ArrayList<>();
    		for (int j = 0; j <= i; j++) {
    			for (List<Integer> l : res) {
    				List<Integer> list2 = new ArrayList<>(l);
    				list2.add(j, nums[i]);
    				res2.add(list2);
    			}
    		}
    		res = res2;
    	}
    	return res;
    }
    

	public static void main(String[] args) {
		Permutations t = new Permutations();
		for (List<Integer> l: t.permute5(new int[]{1, 2, 3})) {
			System.out.println(l);
		}
	}
    
    ////////////////////////////////////////////////////////////////////////////////
    
    // iterative too  long..
 	public ArrayList<ArrayList<Integer>> permute33(ArrayList<Integer> nums) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         if (nums == null || nums.size() == 0) {
             return result;   
         }
         
         //start from an empty list
 	    result.add(new ArrayList<Integer>());
  
         //add nums[i] to all positions of each list in the current result => new result
     	for (int i = 0; i < nums.size(); i++) {
     		ArrayList<ArrayList<Integer>> nextResult = new ArrayList<ArrayList<Integer>>();
     		
     		//for each list l in the result
     		for (ArrayList<Integer> l : result) {
     			// insert num[i] from 0 to l.size()
     			for (int j = 0; j < l.size() + 1; j++) {
     				l.add(j, nums.get(i));
     				ArrayList<Integer> temp = new ArrayList<Integer>(l);
     				nextResult.add(temp); //add the new list to the next result.
     				l.remove(j);
     			}
     		}
     		result = nextResult;
 	    }
 	    return result;
     }    
    
	// time ~O(N!) Space ~O(N)
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		helper(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
		return result;
	}

	private static void helper(int[] nums, boolean[] used,
			ArrayList<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				list.add(nums[i]);
				helper(nums, used, list, result);
				used[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static List<List<Integer>> permute0(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		ArrayList<Integer> first = new ArrayList<>();
		first.add(nums[0]);
		result.add(first);
		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> next = new ArrayList<>();
			for (int j = 0; j < result.size(); j++) {
				List<Integer> curr = result.get(j);
				for (int k = 0; k < curr.size() + 1; k++) {
					List<Integer> item = new ArrayList<>(curr);
					item.add(k, nums[i]);
					next.add(item);
				}
			}
			result = next;
		}
		return result;
	}
	
	
	// ==============================================================
	// Solution 1: Call nextPermutation() time ~O(N * N!)
	public static List<List<Integer>> permute4(int[] nums) {
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
		// compute(num.length)!
		int factorial = 1;
		for (int i = 1; i <= nums.length; i++) factorial *= i;
		int[] perm = Arrays.copyOf(nums, nums.length);
		
		// generate all permutations
		for (int i = 0; i < factorial; i++) {
			nextPermutation(perm);
			List<Integer> list = new ArrayList<>();
			for (int k : perm) list.add(k);
			listSet.add(list);
		}
		return listSet;
	}

	private static void nextPermutation(int[] nums) {
		int curr = nums.length - 1;
		while (curr > 0 && nums[curr - 1] >= nums[curr])
			curr--;
		reverse(nums, curr, nums.length - 1);
		// swap num[curr - 1] and the first integer element on its right side
		if (curr > 0) {
			int next = curr;
			curr--;
			while (nums[curr] >= nums[next]) next++;
			swap(nums, curr, next);
		}
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start++, end--);
		}
	}

	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}

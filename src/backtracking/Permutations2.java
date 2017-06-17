package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 * @author yutian
 * @since Aug 18, 2015
 */
public class Permutations2 {
	// recursion backtracking time O(N!)
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, list, visited, result);
        return result;
    }
    private static void dfs(int[] nums, List<Integer> list, Set<Integer> visited, 
    		List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        } 
        for (int i = 0; i < nums.length; i++) {
         	// skip the duplicated elements
            if (i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i]) continue;
            if (!visited.contains(i)) {
                list.add(nums[i]);
                visited.add(i);
                dfs(nums, list, visited, result);
                list.remove(list.size() - 1);
                visited.remove(i);
            }
        }
    }
    
    // iterative
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.size(); i++) {
            Set<ArrayList<Integer>> nextResult = new HashSet<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    //skip duplicates
                    //while (j < l.size() && nums.get(i) == nums.get(j)) {
                    //    j++;
                    //}
                    l.add(j, nums.get(i));
                    nextResult.add(new ArrayList<Integer>(l));
                    l.remove(j);
                }
            }
            result = nextResult;
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> r = permuteUnique(new int[]{1, 1, 2});
//    	List<List<Integer>> r2 = permuteUnique(new int[]{1, 1});
    	for (List<Integer> i: r) {
    		System.out.println(i);
    	}
    }	
	
//	private List<List<Integer>> listSet;
//	private List<Integer> list;
//	private Set<Integer> visited;
//	
//	public List<List<Integer>> permuteUnique(int[] nums) {
//		listSet = new ArrayList<List<Integer>>();
//		list = new ArrayList<Integer>();
//		visited = new HashSet<>();
//		Arrays.sort(nums);
//		dfs(nums);
//		return listSet;
//	}
//
//	private void dfs(int[] nums) {
//		if (list.size() == nums.length) {
//			listSet.add(new ArrayList<Integer>(list));
//		} else {
//			for (int i = 0; i < nums.length; i++) {
//				// skip the duplicated elements
//				if (i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i])
//					continue;
//				if (!visited.contains(i)) {
//					list.add(nums[i]);
//					visited.add(i);
//					dfs(nums);
//					list.remove(list.size() - 1);
//					visited.remove(i);
//				}
//			}
//		}
//	}
	

}

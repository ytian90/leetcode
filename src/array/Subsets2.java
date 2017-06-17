package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II
 * @author yutian
 * @since Aug 19, 2015
 */
public class Subsets2 {
	
	// Solution 1 Time complexity is O(2^n)  Space complexity is O(n).
	List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }
    
    private void helper(int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            helper(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
	
	// Solution 2
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        int size = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            start = (i >= 1 && nums[i - 1] == nums[i]) ? size : 0;
            size = res.size();
            for (int j = start; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
	}
	
	public static void main(String[] args) {
		Subsets2 t = new Subsets2();
		t.subsetsWithDup2(new int[]{1, 2, 2});
		
	}
}

package leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a consecutive list of numbers, find the missing one
 * not sorted, one missing
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=166342&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 19, 2016
 */
public class MissingNumber2 {
	
	public static int missingNumber(List<Integer> nums) {
		int min = Collections.min(nums);
		int res = nums.size();
		for (int i = 0; i < nums.size(); i++) {
			res ^= i;
			res ^= (nums.get(i) - min);
		}
		return res + min;
	}

	public static void main(String[] args) {
		List<Integer> t1 = new ArrayList<Integer>();
		t1.add(3); t1.add(6); t1.add(7); t1.add(4);
		System.out.println(missingNumber(t1));
	}

}

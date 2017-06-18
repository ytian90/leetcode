package array;
/**
 * 565. Array Nesting
 * @author ytian
 *
 */
public class ArrayNesting {
	
	public static int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
        	int size = 0, k = i;
        	while (nums[k] >= 0) {
        		int t = nums[k];
        		nums[k] = -1;
        		k = t;
        		size++;
        	}
        	max = Math.max(max, size);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] t = new int[]{5,4,0,3,1,6,2};
		System.out.println(arrayNesting(t));
	}

}

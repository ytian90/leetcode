package array;
/**
 * 27. Remove Element
 * @author yutian
 * @since Aug 9, 2015
 */
public class RemoveElement {
	
	public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
	
	public static int removeElement2(int[] nums, int val) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
			j++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{2, 3, 5, 3, 2, 4};
		int[] t2 = new int[]{3,2,2,3};
		System.out.println(removeElement(t1, 3));
		System.out.println(removeElement(t2, 3));
		
	}
}

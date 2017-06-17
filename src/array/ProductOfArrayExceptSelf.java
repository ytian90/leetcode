package array;
/**
 * Product of Array Except Self
 * @author yutian
 * @since Aug 29, 2015
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		// left to right
		for (int i = 0, temp = 1; i < nums.length; i++) {
			res[i] = temp;
			temp *= nums[i];
		}
		// right to left
		for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
			res[i] *= temp;
			temp *= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		ProductOfArrayExceptSelf t = new ProductOfArrayExceptSelf();
		for (int i: t.productExceptSelf(new int[]{1, 2, 3, 4})) {
			System.out.println(i);
		}
		
	}
}

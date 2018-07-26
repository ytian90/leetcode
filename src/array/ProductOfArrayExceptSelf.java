package array;
/**
 * Product of Array Except Self
 * @author yutian
 * @since Aug 29, 2015
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0, t = 1; i < nums.length; i++) {
			res[i] = t;
			t *= nums[i];
		}
		for (int i = nums.length - 1, t = 1; i >= 0; i--) {
			res[i] *= t;
			t *= nums[i];
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

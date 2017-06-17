package math;
/**
 * Container With Most Water
 * @author yutian
 * @since Aug 13, 2015
 */
public class ContainerWithMostWater {
	// Greedy algorithm: Time ~O(N), Space ~O(1)
	public static int maxArea(int[] height) {
		if (height == null || height.length < 2)
			return 0;
		int maxArea = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			maxArea = Math.max(maxArea, (right - left) * 
					Math.min(height[left], height[right]));
			if (height[left] < height[right]) left++;
			else right--;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{4, 5, 2, 1, 3};
		System.out.println(maxArea(test));
	}
}

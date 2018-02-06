package math;
/**
 * Container With Most Water
 * @author yutian
 * @since Aug 13, 2015
 */
public class ContainerWithMostWater {
	// Greedy algorithm: Time ~O(N), Space ~O(1)
	public static int maxArea(int[] height) {
		if (height.length < 2) return 0;
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{4, 5, 2, 1, 3};
		System.out.println(maxArea(test));
	}
}

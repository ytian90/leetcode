package math;
/**
 * 11. Container With Most Water
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

    public static int maxArea2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0, i = 0, j = height.length - 1;
        int lmh = height[i], rmh = height[j];
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(lmh, rmh));
            if (lmh < rmh) {
                i++;
                lmh = Math.max(lmh, height[i]);
            } else {
                j--;
                rmh = Math.max(rmh, height[j]);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{4, 5, 2, 1, 3}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea2(new int[]{1, 1}));
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
	}
}

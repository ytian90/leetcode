package array;
/**
 * 42. Trapping Rain Water
 * @author yutian
 * @since Aug 14, 2015
 */
public class TrappingRainWater {
	
	public static void main(String[] args){
		int[] elevation = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap2(elevation));
	}
	
	// Solution 2 Time ~O(N), Space ~O(1)
		public static int trap2(int[] height) {
			int volumn = 0;
			int lmh = 0, rmh = 0;
			int start = 0, end = height.length - 1;
			while (start < end) {
				lmh = Math.max(lmh, height[start]);
				rmh = Math.max(rmh, height[end]);
				if (lmh < rmh) {
					volumn += lmh - height[start];
					start++;
				} else {
					volumn += rmh - height[end];
					end--;
				}
			}
			return volumn;
		}
		
		// Solution 3 Time ~O(N), Space ~O(1)
		public int trap3(int[] height) {
			int volumn = 0;
			int start = 0, end = height.length - 1;
			int mh = 0;
			while (start < end) {
				int min = Math.min(height[start], height[end]);
				if (mh < min) mh = min;
				if (height[start] < height[end]) volumn += mh - height[start++];
				else volumn += mh - height[end--];
			}
			return volumn;
		}
		
		// Solution 4
		public int trap4(int[] height) {
			int i = 0, j = height.length - 1, result = 0, plank = 0;
			while (i <= j) {
				plank = plank < Math.min(height[i], height[j]) ? Math.min(height[i], height[j]) : plank;
				result = height[i] >= height[j] ? result + (plank - height[j--]) : result + (plank - height[i++]);
			}
			return result;
		}
	
	// Solution 1
	public int trap(int[] height) {
		int volumn = 0;
		if (height.length <= 2) return volumn;
		// go from left to right, find the left highest bar for each bar
		int[] lmh = new int[height.length];
		lmh[0] = 0;
		int max = height[0];
		for (int i = 1; i < height.length; i++) {
			lmh[i] = max;
			if (height[i] > max) max = height[i];
		}
		// go from right to left, find the right highest bar from each bar
		max = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i++) {
			int left = lmh[i];
			int right = max;
			if (height[i] > max) max = height[i];
			// calculate the volume if there's a bowl shape
			int min = Math.min(left, right);
			if (min > height[i]) volumn += min - height[i];
		}
		return volumn;
	}
	
	
}

package leetcode.binarySearch;
/**
 * H_Index 2
 * @author yutian
 * @since Oct 26, 2015
 */
public class HIndex2 {

	public static void main(String[] args) {
		int[] c1 = new int[]{ 0, 1, 3, 5, 6 };
		int ans1 = hIndex(c1);
		System.out.println(ans1);
	}
	// time ~O(logN)
	public static int hIndex(int[] citations) {
		int n = citations.length;
        if (citations == null || n == 0) return 0;
        int l = 0, r = n;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (citations[mid] == n - mid) return citations[mid];
			if (citations[mid] < n - mid) l = mid + 1;
			else r = mid;
		}
		return n - l; // it is not n - 1, it is l ->LLLLL
	}
	
	// time ~O(N)
	public static int hIndex2(int[] citations) {
		int h = 0, i = citations.length;
		for (int c : citations) {
			if (c > --i) h++;
		}
		return h;
	}

}

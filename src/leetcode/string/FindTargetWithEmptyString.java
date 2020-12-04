package leetcode.string;
/**
 * Given "", "123", "345", "", "6", "", "789"
 * target = "6" return 4
 * @author yutian
 * @since Feb 20, 2016
 */
public class FindTargetWithEmptyString {
	
	public int find(String[] strs, String target) {
		int lo = 0, hi = strs.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (strs[mid] != "") {
				if (target.equals(strs[mid])) {
					return mid;
				} else if (target.charAt(0) < strs[mid].charAt(0)) {
					hi = mid;
				} else if (target.charAt(0) > strs[mid].charAt(0)){
					lo = mid + 1;
				}
			} else {
				if (target == "") return mid;
				if (strs[hi].equals(target)) {
					return hi;
				} else {
					hi--;
				}
			}
		}
		return (strs[lo].equals(target)) ? lo : -1;
	}

	public static void main(String[] args) {
		FindTargetWithEmptyString t = new FindTargetWithEmptyString();
		String[] s = new String[]{"", "123", "345", "", "6", "", "789"};
		System.out.println(t.find(s, "6"));
	}

}

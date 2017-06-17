package binarySearch;
/**
 * First Bad Version
 * @author yutian
 * @since Dec 6, 2015
 */
public class FirstBadVersion {
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public boolean isBadVersion(int version) {
		return true;
	}
	
	public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

	public static void main(String[] args) {

	}

}

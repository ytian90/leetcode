package leetcode.array;

/**
 * 852. Peak Index in a Mountain Array
 */
public class PeakIndexInAMountainArray {

    // O(N)
    public static int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                return i;
        }
        return 0;
    }

    // O(logN)
    public static int peakIndexInMountainArrays(int[] A) {
        int l = 0, r = A.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (A[mid] < A[mid + 1]) l = mid + 1;
            else if (A[mid - 1] > A[mid]) r = mid;
            else return mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArrays(new int[]{
                0,1,0
        }));
        System.out.println(peakIndexInMountainArrays(new int[]{
                0,2,1,0
        }));
    }

}

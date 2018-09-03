package array;

/**
 * 896. Monotonic Array
 */
public class MonotonicArray {
    public static boolean isMonotonic(int[] A) {
        int max = A[0], min = A[0];
        boolean a = true, b = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < max) a = false;
            if (A[i] > min) b = false;
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return a || b;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,2,2,3}));
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
        System.out.println(isMonotonic(new int[]{1,3,2}));
        System.out.println(isMonotonic(new int[]{1,2,4,5}));
        System.out.println(isMonotonic(new int[]{1,1,1}));
    }
}

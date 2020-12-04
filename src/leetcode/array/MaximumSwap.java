package leetcode.array;

public class MaximumSwap {

    public static int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int maxIndex = digits.length - 1;
        int leftIndex = -1, rightIndex = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            char c = digits[i];
            if (c > digits[maxIndex]) {
                maxIndex = i;
                continue;
            }
            if (c < digits[maxIndex]) {
                leftIndex = i;
                rightIndex = maxIndex;
            }
        }
        if (leftIndex == -1) return num;
        swap(digits, leftIndex, rightIndex);
        return Integer.valueOf(new String(digits));
    }

    public static void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static int maximumSwap2(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    swap(digits, i, buckets[k]);
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
        System.out.println(maximumSwap(736));
        System.out.println(maximumSwap(7836));
        System.out.println(maximumSwap(8673));
        System.out.println(maximumSwap(10));
        System.out.println(maximumSwap(99901));
    }
}

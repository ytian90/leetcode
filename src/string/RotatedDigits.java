package string;

/**
 * 788. Rotated Digits
 */
public class RotatedDigits {

    public static int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i))
                res++;
        }
        return res;
    }

    public static boolean isValid(int N) {
        boolean found = false;
        while (N > 0) {
            if (N % 10 == 2) found = true;
            if (N % 10 == 5) found = true;
            if (N % 10 == 6) found = true;
            if (N % 10 == 9) found = true;
            if (N % 10 == 3) return false;
            if (N % 10 == 4) return false;
            if (N % 10 == 7) return false;
            N /= 10;
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }
}

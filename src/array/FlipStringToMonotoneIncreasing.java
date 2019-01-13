package array;

/**
 * 926. Flip String to Monotone Increasing
 */
public class FlipStringToMonotoneIncreasing {

    public static int minFlipsMonoIncr(String S) {
        if (S == null || S.length() == 0)
            return 0;
        int one_count = 0, flip_count = 0;
        for (char c : S.toCharArray()) {
            if (c == '1') {
                one_count++;
            } else {
                if (one_count == 0) continue;
                flip_count++;
            }
            flip_count = Math.min(one_count, flip_count);
        }
        return flip_count;
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
        System.out.println(minFlipsMonoIncr("0101100011"));
    }
}

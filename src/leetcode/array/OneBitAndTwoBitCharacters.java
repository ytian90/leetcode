package leetcode.array;

/**
 * 717. 1-bit and 2-bit Characters
 */
public class OneBitAndTwoBitCharacters {

    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            if (bits[0] == 0) i++;
            else i += 2;
        }
        return i == n - 1;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}

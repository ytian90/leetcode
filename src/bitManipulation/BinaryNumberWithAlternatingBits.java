package bitManipulation;

/**
 * 693. Binary Number with Alternating Bits
 */
public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
    }
}

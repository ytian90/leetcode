package bitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 762. Prime Number of Set Bits in Binary Representation
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public static int countPrimeSetBits(int L, int R) {
        int count = 0;
        Set<Integer> set = new HashSet<>(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        for (int i = L; i <= R; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimeSetBis(int L, int R) {
        int count = 0;
        Set<Integer> set = new HashSet<>(
                Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        for (Integer i = L; i <= R; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1) {
                bits += n & 1;
            }
            if (set.contains(bits)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
    }
}

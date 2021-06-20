package company.uuba.oa;

/**
 * https://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/
 *
 * LC 191. Number of 1 Bits
 */
public class BinaryNumberMinusOneCountOneOperations {
    public static void main(String[] args) {
        System.out.println(hammingWeight(8));
    }

    public static int minusOne(int n) {
        return --n;
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }

}

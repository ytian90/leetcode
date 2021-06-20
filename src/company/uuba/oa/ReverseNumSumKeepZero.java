package company.uuba.oa;

/**
 * 反转数字求和，末尾0 保留，
 * a=[123,210,106]
 * return 321+120+601=1042
 */
public class ReverseNumSumKeepZero {

    public static int reverseSumKeepZero(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += reverse(i);
        }
        return sum;
    }

    private static int reverse(int n) {
        int res = 0, zeroCount = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0 && res == 0) {
                zeroCount++;
            }
            res += digit;
            n /= 10;
            if (n > 0) {
                res *= 10;
            }
        }
        while (zeroCount > 0) {
            res *= 10;
            zeroCount--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseSumKeepZero(new int[]{123, 210, 106}));
    }
}

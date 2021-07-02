package company.uuba;

/**
 * LC 1281. Subtract the Product and Sum of Digits of an Integer
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int sum = 0, mul = 1;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            mul *= digit;
            n /= 10;
        }
        return mul - sum;
    }
    /**
     * Time: O(K), K is the digit of number n
     * Space: O(1)
     */
}

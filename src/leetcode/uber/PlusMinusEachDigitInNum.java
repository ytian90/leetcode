package leetcode.uber;

public class PlusMinusEachDigitInNum {

    public static void main(String[] args) {
        System.out.println(calculate(12345));
        System.out.println(calculate(5243));
    }

    public static int calculate(int n) {
        if (n == 0) return 0;
        int digit = 0, a = 0, b = 0;
        while (n > 0) {
            int mod = n % 10;
            if (digit % 2 == 0) {
                a += mod;
            } else {
                b += mod;
            }
            n /= 10;
            digit++;
        }
        return (digit % 2 == 0) ? b - a : a - b;
    }
}

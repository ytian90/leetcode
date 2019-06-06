package mj.houzz;

/**
 * 实现add(num1, num2), 不能用加号
 *
 * https://www.1point3acres.com/bbs/thread-317047-1-1.html
 * https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
 */
public class AddTwoNumbersWithoutArithmeticOperations {

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(3, 5));
    }
}

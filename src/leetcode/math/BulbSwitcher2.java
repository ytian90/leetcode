package leetcode.math;

/**
 * 672. Bulb Switcher II
 */
public class BulbSwitcher2 {
    public static int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n <= 0 || m < 0) return 0;

        if (n == 1) return 2;
        else if (n == 2) return (m == 1) ? 3 : 4;
        else return (m == 1) ? 4 : ((m == 2) ? 7 : 8);
    }

    public static void main(String[] args) {
        System.out.println(flipLights(1, 1));
        System.out.println(flipLights(2, 1));
        System.out.println(flipLights(3, 1));
    }
}

package leetcode.string;

/**
 * 481. Magical String
 */
public class MagicalString {

    public static int magicalStringg(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int[] a = new int[n + 1];
        a[0] = 0; a[1] = 2; a[2] = 2;
        int head = 2, tail = 3, num = 1, res = 1;
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                if (num == 1 && tail < n) res++;
                a[tail++] = num;
            }
            num = num ^ 3;
            head++;
        }
        return res;
    }

    public static int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int curr = 2;
        while (sb.length() < n) {
            int c = (sb.charAt(sb.length() - 1) - '0') ^ 3;
            for (int i = '1'; i <= sb.charAt(curr); i++) {
                sb.append(c);
            }
            curr++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(magicalString(6));
    }
}

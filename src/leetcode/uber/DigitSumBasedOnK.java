package leetcode.uber;

public class DigitSumBasedOnK {

    public static int calculate(int n, int k) {
        String s = String.valueOf(n);
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int count = 0, sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
                count++;
                if (count == k) {
                    sb.append(sum);
                    sum = 0;
                    count = 0;
                }
            }
            sb.append(sum);
            s = sb.toString();
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(calculate(1111122222, 3));
    }
}

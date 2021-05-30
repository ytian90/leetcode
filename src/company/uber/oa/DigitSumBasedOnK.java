package company.uber.oa;

/**
 * 给你一个int和k值，让你把这个int的位数分成k份，分别求值。不足k的位数直接放在后面。
 * 一直到你这个值位数小于等于k。比如 1111122222，k=3，那你要111 112 222 2  -> 3462 -> 346 2 -> 132 返回132
 */
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

package leetcode.uber;

/**
 * Add up two strings:
 *      input: String a, String b
 *      output: 从右向左，a 与b中每一个相对应的pair相加，得到的结果转化成string，concat 起来。注意这里不需要进位，单纯concat在一起就好 (output不太好描述，下面举例说明)
 *      Example: a="1234", b="56" => Output: "12810"。
 */
public class AddUpTwoStrings {
    public static String addStrings(String a, String b) {
        if (a == null && b == null || a.length() == 0 || b.length() == 0) {
            return "";
        }
        int n = a.length(), m = b.length();
        int[] sum = new int[Math.max(n, m)];
        int i = n - 1, j = m - 1, k = sum.length - 1;
        while (i >= 0 || j >= 0) {
            int total = 0;
            total += (i < 0) ? 0 : a.charAt(i--) - '0';
            total += (j < 0) ? 0 :b.charAt(j--) - '0';
            sum[k--] = total;
        }
        StringBuilder sb = new StringBuilder();
        for (int c : sum) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1234", "56"));
    }

}

package leetcode.string;

/**
 * 564. Find the Closest Palindrome
 */
public class FindTheClosestPalindrome {

    public static String nearestPalindromic(String n) {
        char[] arr = n.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--)
            arr[j] = arr[i];
        String currP = String.valueOf(arr);
        String prevP = nearestPalindromic(currP, false);
        String nextP = nearestPalindromic(currP, true);

        long num = Long.valueOf(n);
        long curr = Long.valueOf(currP);
        long prev = Long.valueOf(prevP);
        long next = Long.valueOf(nextP);

        long d1 = Math.abs(num - prev);
        long d2 = Math.abs(num - curr);
        long d3 = Math.abs(num - next);

        if (num == curr) {
            return d1 <= d3 ? prevP : nextP;
        } else if (num > curr) {
            return d2 <= d3 ? currP : nextP;
        } else {
            return d1 <= d2 ?  prevP : currP;
        }
    }

    public static String nearestPalindromic(String currP, boolean dir) {
        int k = currP.length() >> 1, p = currP.length() - k;
        int l = Integer.valueOf(currP.substring(0, p));
        l += (dir ? 1 : -1);
        if (l == 0) return k == 0 ? "0" : "9";
        StringBuilder left = new StringBuilder(String.valueOf(l));
        StringBuilder right = new StringBuilder(left).reverse();
        if (k > left.length()) right.append("9");
        return left.append(right.substring(right.length() -k)).toString();
    }

    public static void main(String[] args) {
        System.out.println(nearestPalindromic("123"));
    }
}

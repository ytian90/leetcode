package company.uuba.oa;

import java.util.HashSet;
import java.util.Set;

/**
 * Substring divisible
 * 给定num = 264 和 k = 1
 * 问把num转换为string后 长度为k的substring中有多少个可以拿来整除num
 * 这道题就有2,6,4都可以
 */
public class SubstringDivisible {

    public static int countSubString(int n, int k) {
        String s = String.valueOf(n);
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i - k, i);
            int subNum = Integer.parseInt(sub);
            if (subNum != 0 && n % subNum == 0 && !visited.contains(sub)) {
                count++;
                visited.add(sub);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubString(120, 2));
        System.out.println(countSubString(555, 1));
        System.out.println(countSubString(5400, 2));
    }

}

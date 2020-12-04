package leetcode.hashtable;

/**
 * 771. Jewels and Stones
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
}

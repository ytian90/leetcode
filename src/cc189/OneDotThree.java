package cc189;

/**
 * 1.3 Write a method to replace all spaces in a string with "%20"
 */
public class OneDotThree {
    public static String replace(String s, int k) {
        s = s.substring(0, k);
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(replace("Mr John Smith    ", 13));
    }
}

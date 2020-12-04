package leetcode.math;

/**
 * 800. Similar RGB Color
 */
public class SimilarRGBColor {
    public static String similarRGB(String color) {
        String[] map = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < color.length(); i += 2) {
            String hex = color.substring(i, i + 2);
            int min = Integer.MAX_VALUE;
            String rgb = "";
            for (String s : map) {
                int diff = Math.abs(Integer.parseInt(hex, 16) - Integer.parseInt(s, 16));
                if (diff < min) {
                    min = diff;
                    rgb = s;
                }
            }
            sb.append(rgb);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(similarRGB("#09f166"));
    }
}

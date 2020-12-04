package leetcode.string;
/**
 * 434. Number of Segments in a String
 * @author ytian
 *
 */
public class NumberOfSegmentsInAString {
	
	public static int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        }
        return res;
    }

    public static int countSegmentss(String s) {
        return ("x " + s).split(" +").length - 1;
    }

	public static void main(String[] args) {
		System.out.println(countSegmentss("Hello, my name is John"));
        System.out.println(countSegmentss(", , , ,        a, eaefa"));
	}

}

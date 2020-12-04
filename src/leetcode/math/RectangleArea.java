package leetcode.math;
/**
 * Rectangle Area
 * @author yutian
 * @since Aug 2, 2015
 */
public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A) {
        	return (C - A) * (D - B) + (G - E) * (H - F);
        }
        if (D < F || H < B) {
        	return (C - A) * (D - B) + (G - E) * (H - F);
        }
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}

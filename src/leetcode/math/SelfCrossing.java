package leetcode.math;
/**
 * 335. Self Crossing
 * @author yutian
 * @since Apr 9, 2016
 */
public class SelfCrossing {
	
	/*
	 * 3 scenarios:
	 * 1. Fourth line across first line and works for fifth line 
	 * crosses second line and so on.
	 * 2. Fifth line meets first line and works for the liens after.
	 * 3. Sixth line crosses first line and works for the lines after.
	 * 
	 */
	public boolean isSelfCrossing(int[] x) {
        int l = x.length;
        if (l <= 3) return false;
        
        for (int i = 3; i < l; i++) {
        	// Fourth line crosses first line and onward
        	if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
        		return true;
        	// Fifth line meets first line and onward
        	if(i >= 4)
            {
                if(x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                	return true;
            }

        	// Sixth line crosses first line and onward
        	if(i >=5)
            {
                if(x[i-2] - x[i-4] >= 0 && x[i] >= x[i-2] - x[i-4] 
                		&& x[i-1] >= x[i-3] - x[i-5] && x[i-1] <= x[i-3]) 
                	return true;  
            }
        }
        return false;
    }

	public static void main(String[] args) {
		SelfCrossing t = new SelfCrossing();
		System.out.println(t.isSelfCrossing(new int[]{2, 1, 1, 2}));
		System.out.println(t.isSelfCrossing(new int[]{1, 2, 3, 4}));
		System.out.println(t.isSelfCrossing(new int[]{1, 1, 1, 1}));
	}

}

package leetcode.dynamicProgramming;
/**
 * 552. Student Attendance Record II
 * @author ytian
 *
 */
public class StudentAttendanceRecord2 {
	
	static final int M = 1000000007;
	
	public static int checkRecord(int n) {
        long[] pl = new long[n + 1]; // ending with P or L, no A
        long[] p = new long[n + 1]; // ending with P, no A
        pl[0] = p[0] = 1;
        pl[1] = 2; p[1] = 1;
        
        for (int i = 2; i <= n; i++) {
        	p[i] = pl[i - 1];
        	pl[i] = (p[i] + p[i - 1] + p[i - 2]) % M;
        }
        
        long res = pl[n];
        for (int i = 0; i < n; i++) { // inserting A into (n - 1) - length strings
        	long s = (pl[i] * pl[n - i - 1]) % M;
        	res = (res + s) % M;
        }
        return (int) res;
    }

	public static void main(String[] args) {
		System.out.println(checkRecord(2));
		System.out.println(checkRecord(100));
		
	}

}

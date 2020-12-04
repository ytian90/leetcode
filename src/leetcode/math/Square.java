package leetcode.math;
/**
 * 
 * @author ytian
 *
 */
public class Square {

	public static int solution(int A, int B) {
		if (B < 0) return 0;
        int head = A == 0 ? 0 : floorSqrt(A);
        int tail = floorSqrt(B);
        if (A == head * head) {
            return tail - head + 1;
        } else {
            return tail - head;
        }
    }
    public static int floorSqrt(int x)
    {
        if (x == 0 || x == 1)
            return x;
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
 
            if (mid*mid == x)
                return mid;
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else 
                end = mid - 1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(solution(4, 17));  // 3
		System.out.println(solution(4, 25));  // 4
		System.out.println(solution(4, 26));  // 4
		System.out.println(solution(5, 26));  // 3
		System.out.println(solution(5, 37));  // 4
		System.out.println(solution(5, 36));  // 4
		System.out.println(solution(-1, 0));  // 0
		System.out.println(solution(-2, -1)); // 0
		System.out.println(solution(0, 25));  // 6
	}   
}

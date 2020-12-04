package leetcode.binarySearch;
/**
 * 744. Find Smallest Letter Greater Than Target
 * @author ytian
 *
 */
public class FindSmallestLetterGreaterThanTarget {

	public static char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
        		int mid = lo + (hi - lo) / 2;
        		if (letters[mid] <= target) lo = mid + 1;
        		else hi = mid;
        }
		return letters[lo % letters.length];
    }
	
	public static void main(String[] args) {
		System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a')); // c
		System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c')); // f
		System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'd')); // f
		System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'g')); // j
		System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'j')); // c
		System.out.println(nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'k')); // c
	}
}

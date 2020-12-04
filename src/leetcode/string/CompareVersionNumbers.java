package leetcode.string;
/**
 * 165. Compare Version Numbers
 * @author yutian
 * @since Aug 7, 2015
 */
public class CompareVersionNumbers {
	// Time ~O(max(Na, Nb)), Space ~O(Na + Nb)
	// version 1 > version 2, return 1, v1 < v2, return -1, otherwise return 0-1
	// 0.1 < 1.1 < 1.2 < 13.37
	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        while (i < arr1.length || i < arr2.length) {
            if (i < arr1.length && i < arr2.length) {
                if (Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i])) {
                    return -1;
                } else if (Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[i])) {
                    return 1;
                }
            } else if (i < arr1.length && Integer.valueOf(arr1[i]) != 0) {
                return 1;
            } else if (i < arr2.length && Integer.valueOf(arr2[i]) != 0) {
                return -1;
            }
            i++;
        }
        return 0;
	}
	
	public static void main(String[] args) {
		String s1 = "0.1";
		String s2 = "1.1";
		String s3 = "1.2";
		String s4 = "13.23";
		System.out.println(compareVersion(s1, s2));
		System.out.println(compareVersion(s2, s3));
		System.out.println(compareVersion(s3, s4));
		
	}
}

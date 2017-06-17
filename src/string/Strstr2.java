package string;

import java.util.HashSet;

/**
 * F
 * http://www.cnblogs.com/EdwardLiu/p/5123513.html
 * Given an integer k>=1 and two strings A and B (length ~n each);
 * Figure out if there is any common substring of length at least k.
 * (i.e. any string of length at least k, that is a substring of both A and B)
 *  A="facebook", B="bookshelf", k=3  ==> true
           ^^^       ^^^
 *  A="facebook", B="bookshelf", k=4  ==> true
           ^^^^      ^^^^
 *  A="facebook", B="bookshelf", k=5  ==> false
 * @author yutian
 *
 */
public class Strstr2 {
	
	public boolean strstr(String A, String B, int k) {
		int lenA = A.length();
		int lenB = B.length();
		for (int i = 0; i <= lenA - k; i++) {
			String stra = A.substring(i, i + k);
			for (int j = 0; j <= lenB - k; j++) {
				String strb = B.substring(j, j + k);
				if (stra.equals(strb)) return true;
			}
		}
		return false;
	}
	
	// optimize
	public boolean strstr2(String A, String B, int k) {
	    //store B's substring of length k to hashSet
	    HashSet<String> set = new HashSet<String>();
	    for (int i=0; i<B.length()-k; i++) {
	        set.add(B.substring(i, i+k));
	    }           
	    for (int i=0; i<A.length()-k; i++) {
	        String sbstra = A.substring(i, i+k);
	        if (B.contains(sbstra)) return true;
	    }
	    return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strstr2 sol = new Strstr2();
		System.out.println(sol.strstr2("facebook", "bookshelf", 3));
		System.out.println(sol.strstr2("facebook", "bookshelf", 4));
		System.out.println(sol.strstr2("facebook", "bookshelf", 5));
	}

}

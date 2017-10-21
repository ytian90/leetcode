package binaryTree;

import java.util.List;

/**
 * MJ Google
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=299385&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */

interface Monarchy {
	void birth(String child, String parent);
	void death(String name);
	List<String> getOrderOfSuccession();
}

/** 
 * Implement the interface above
 * eg:
 * parent child
 * A1:	  A2 A3
 * A2:    A4 A5
 * the third method return A1 A2 A4 A5 A3
 * if call death(A2), then the getOrderOfSuccession() 
 * return A1 A4 A5 A3
 * 
 * @author ytian
 *
 */
public class BornDeathMonarchy implements Monarchy {
	
	
	
	@Override
	public void birth(String child, String parent) {
		
		
	}
	
	@Override
	public void death(String name) {
	}
	
	@Override
	public List<String> getOrderOfSuccession() {
		return null;
	}
	
	public static void main(String[] args) {
		BornDeathMonarchy t = new BornDeathMonarchy();
		t.birth("A2", "A1");
		System.out.println(t.getOrderOfSuccession());
		t.birth("A3", "A1");
		System.out.println(t.getOrderOfSuccession());
	}


}



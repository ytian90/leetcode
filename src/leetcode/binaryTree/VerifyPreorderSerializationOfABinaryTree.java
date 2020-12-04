package leetcode.binaryTree;
/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * @author yutian
 * @since Feb 13, 2016
 */
public class VerifyPreorderSerializationOfABinaryTree {
	
	// time O(N)
	public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String n: nodes) {
        	if (--diff < 0) return false;
        	if (!n.equals("#")) diff += 2;
        }
        return diff == 0;
    }

	public static void main(String[] args) {
		VerifyPreorderSerializationOfABinaryTree t = 
				new VerifyPreorderSerializationOfABinaryTree();
		
		System.out.println(t.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(t.isValidSerialization("1,#"));
		System.out.println(t.isValidSerialization("9,#,#,1"));
	}

}

package binaryTree;
/**
 * 606. Construct String from Bianry Tree
 * @author ytian
 *
 */
public class ConstructStringFromBinaryTree {
	
	public static String tree2str(TreeNode t) {
        if (t == null) return "";
        String result = String.valueOf(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
        
    }

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2; n1.right = n3;
		n2.left = n4;
		
		System.out.println(tree2str(n1));
		
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(4);
		n5.left = n6; n5.right = n7;
		n6.right = n8;
		
		System.out.println(tree2str(n5));
		
	}

}

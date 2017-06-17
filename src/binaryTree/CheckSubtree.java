package binaryTree;
/**
 * Check if a binary tree is subtree of another binary tree
 * http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 * @author yutian
 * @since Feb 17, 2016
 */
public class CheckSubtree {
	
	// time O(mn)
	
	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}
	
	static TreeNode root1, root2;
	
	// A utility function to check whether trees with roots as root1 and
    // root2 are identical or not
	boolean areIdentical(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		// check if the value of both roots is same and value of left and 
		// right subtrees are also same
		return (node1.val == node2.val && areIdentical(node1.left, node2.left) && 
				areIdentical(node1.right, node2.right));
	}
	
	// This function returns true if S is a subtree of T, otherwise false
	boolean isSubtree(TreeNode T, TreeNode S) {
		if (S == null) return true;
		if (T == null) return false;
		/* Check the tree with root as current node */
		if (areIdentical(T, S)) {
			return true;
		}
		/* If the tree with root as current node doesn't match then
        try left and right subtrees one by one */
        return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	public static void main(String[] args) {
		CheckSubtree tree = new CheckSubtree();
		
		// TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
          
        tree.root1 = new TreeNode(26);
        tree.root1.right = new TreeNode(3);
        tree.root1.right.right = new TreeNode(3);
        tree.root1.left = new TreeNode(10);
        tree.root1.left.left = new TreeNode(4);
        tree.root1.left.left.right = new TreeNode(30);
        tree.root1.left.right = new TreeNode(6);
 
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
          
        tree.root2 = new TreeNode(10);
        tree.root2.right = new TreeNode(6);
        tree.root2.left = new TreeNode(4);
        tree.root2.left.right = new TreeNode(30);
 
        if (tree.isSubtree(root1, root2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
		
	}

}

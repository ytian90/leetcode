package binaryTree;
/**
 * Find the closest leaf in a Binary Tree
 * http://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
 * @author yutian
 * @since Jan 27, 2016
 */
public class FindClosestLeafInBinaryTree {
	
	static TreeNode root;
	
	// function to find distance of closest leaf of the tree
	// rooted under given root
	int closestDown(TreeNode node) {
		// Base case
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (node.left == null && node.right == null) {
			return 0;
		}
		return 1 + Math.min(closestDown(node.left), closestDown(node.right));
	}
	
	// Returns distance of the closest leaf to a given key 'k'. The array
	// ancestors is used to keep track of ancestors of current node and 
	// 'index' is used to keep track of current index in 'ancestors[]'
	int findClosestUtil(TreeNode node, char k, TreeNode ancestors[], int index) {
		// Base case
		if (node == null) return Integer.MAX_VALUE;
		// If key found
		if (node.val == k) {
			// Find the closest leaf under the subtree rooted with given key
			int res = closestDown(node);
			// Traverse all ancestors and update result if any parent node
			// gives smaller distance
			for (int i = index - 1; i >= 0; i--) {
				res = Math.min(res, index - i + closestDown(ancestors[i]));
			}
			return res;
		}
		// If key node found, store current node and recur for left and right children
		ancestors[index] = node;
		return Math.min(findClosestUtil(node.left, k, ancestors, index + 1), 
				findClosestUtil(node.right, k, ancestors, index + 1));
	}
	
	int findClosest(TreeNode node, char k) {
		// create an array to store ancestors
		// assumption: maximum height of tree is 100
		TreeNode ancestors[] = new TreeNode[100];
		return findClosestUtil(node, k, ancestors, 0);
	}

	public static void main(String[] args) {
		FindClosestLeafInBinaryTree tree = new FindClosestLeafInBinaryTree();
		tree.root = new TreeNode('A');
        tree.root.left = new TreeNode('B');
        tree.root.right = new TreeNode('C');
        tree.root.right.left = new TreeNode('E');
        tree.root.right.right = new TreeNode('F');
        tree.root.right.left.left = new TreeNode('G');
        tree.root.right.left.left.left = new TreeNode('I');
        tree.root.right.left.left.right = new TreeNode('J');
        tree.root.right.right.right = new TreeNode('H');
        tree.root.right.right.right.left = new TreeNode('H');
        
        char k = 'H';
        System.out.println("Distace of the closest key from " + k + " is "
                            + tree.findClosest(root, k));
        k = 'C';
        System.out.println("Distace of the closest key from " + k + " is "
                            + tree.findClosest(root, k));
        k = 'E';
        System.out.println("Distace of the closest key from " + k + " is "
                            + tree.findClosest(root, k));
        k = 'B';
        System.out.println("Distace of the closest key from " + k + " is "
                             + tree.findClosest(root, k));
	}

}

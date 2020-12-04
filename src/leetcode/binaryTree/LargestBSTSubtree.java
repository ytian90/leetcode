package leetcode.binaryTree;

public class LargestBSTSubtree {
	
	TreeNode root; // only for test
	
	// method 1 time O(N)
	public int largestBSTSubtree(TreeNode root) {
		int[] res = recursive(root);
		return res[2];
	}
	/*
	 * res[0]: whether the node is root of a BST: 0 no, 1 yes
	 * res[1]: number of nodes
	 * res[2]: max BST subtree
	 * res[3]: minimum value of the subtree
	 * res[4]: maximum value of the subtree
	 * 
	 */
	private int[] recursive(TreeNode root) {
		int[] res = new int[5];
		res[0] = 1; res[3] = Integer.MAX_VALUE; res[4] = Integer.MIN_VALUE;
		if (root == null) return res;
		int[] L = recursive(root.left);
		int[] R = recursive(root.right);
		if (L[0] == 0 || R[0] == 0 || L[4] > root.val || R[3] < root.val) {
			res[0] = 0; // false, not a BST
		}
		res[1] = L[1] + R[1] + 1;
		res[2] = (res[0] > 0) ? res[1]: Math.max(L[2], R[2]);
		res[3] = Math.min(root.val, L[3]);
		res[4] = Math.max(root.val, R[4]);
		return res;
	}
	
	public static void main(String[] args) {
		LargestBSTSubtree t = new LargestBSTSubtree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(t.largestBSTSubtree(n1));
		
		/* Let us construct the following Tree
        			50
     			 /      \
    		   10        60
   			  /  \       /  \
  			 5   20    55    70
 		   /     /  \
		  45   65    80
		 */

		LargestBSTSubtree tree = new LargestBSTSubtree();
		tree.root = new TreeNode(50);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(60);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(55);
		tree.root.right.left.left = new TreeNode(45);
		tree.root.right.right = new TreeNode(70);
		tree.root.right.right.left = new TreeNode(65);
		tree.root.right.right.right = new TreeNode(80);

		/* The complete tree is not BST as 45 is in right subtree of 50.
        The following subtree is the largest BST
            60
           /  \
         55    70
         /     /  \
       45     65   80
       */
		System.out.println("Size of largest BST is " + tree.largestBSTSubtree(tree.root));
	}
	
	
	// Method 2
	class Result {
		int res;
		int min;
		int max;
		public Result(int r, int mi, int mx) {
			res = r;
			min = mi;
			max = mx;
		}
	}
	
	public int largestBSTSubtree2(TreeNode root) {
		Result res = helper(root);
		return Math.abs(res.res);
    }
	
	private Result helper(TreeNode root) {
		if (root == null) 
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		Result left = helper(root.left);
		Result right = helper(root.right);
		if (left.res < 0 || right.res < 0 || root.val < left.max || root.val > right.min) {
            return new Result(Math.max(Math.abs(left.res), Math.abs(right.res)) * -1, 0, 0);
        } else {
            return new Result(left.res + right.res + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}

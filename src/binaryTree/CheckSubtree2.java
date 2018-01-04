package binaryTree;

/**
 * Check if a binary tree is subtree of another binary tree
 * improvement of CheckSubtree
 * http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 * @author yutian
 * @since Feb 17, 2016
 */
public class CheckSubtree2 {
	
	public class Node {
		Node left, right;
		int val, sum, dup = 1;
		public Node (int v, int s) {
			val = v;
			sum = s;
		}
	}
	
	public static class Passing {
		int i;
		int m = 0;
		int n = 0;
	}
	
	static Node root;
	Passing p = new Passing();
	
	boolean strstr(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return true;
				if (i + j >= haystack.length()) return false;
				if (haystack.charAt(i + j) != needle.charAt(j)) break;
			}
		}
	}
	
	// A utility function to store inorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
	void storeInorder(TreeNode node, char[] arr, Passing i) {
		if (node == null) {
			arr[i.i++] = '$';
			return;
		}
		storeInorder(node.left, arr, i);
		arr[i.i++] = node.val;
		storeInorder(node.right, arr, i);
	}
	
	// A utility function to store preorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
	void storePreorder(TreeNode node, char[] arr, Passing i) {
		if (node == null) {
			arr[i.i++] = '$';
			return;
		}
		arr[i.i++] = node.val;
		storePreorder(node.left, arr, i);
		storePreorder(node.right, arr, i);
	}
	
	boolean isSubtree(TreeNode T, TreeNode S) {
		/* base cases */
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }
        
     // Store Inorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        char inT[] = new char[100];
        String op1 = String.valueOf(inT);
        char inS[] = new char[100];
        String op2 = String.valueOf(inS);
        storeInorder(T, inT, p);
        storeInorder(S, inS, p);
        inT[p.m] = '\0';
        inS[p.m] = '\0';
 
        // If inS[] is not a substring of preS[], return false
        if (!strstr(op1, op2)) {
            return false;
        }
 
        // Store Preorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        p.m = 0;
        p.n = 0;
        char preT[] = new char[100];
        char preS[] = new char[100];
        String op3 = String.valueOf(preT);
        String op4 = String.valueOf(preS);
        storePreorder(T, preT, p);
        storePreorder(S, preS, p);
        preT[p.m] = '\0';
        preS[p.n] = '\0';
 
        // If inS[] is not a substring of preS[], return false
        // Else return true
        return (!strstr(op3, op4));
        
	}

	public static void main(String[] args) {
		CheckSubtree2 tree = new CheckSubtree2();
		TreeNode T = new TreeNode('a');
        T.left = new TreeNode('b');
        T.right = new TreeNode('d');
        T.left.left = new TreeNode('c');
        T.right.right = new TreeNode('e');
 
        TreeNode S = new TreeNode('a');
        S.left = new TreeNode('b');
        S.right = new TreeNode('d');
        S.left.left = new TreeNode('c');
 
        if (tree.isSubtree(T, S)) {
            System.out.println("Yes , S is a subtree of T");
        } else {
            System.out.println("No, S is not a subtree of T");
        }
	}
	
	public static class TreeNode {
		char val; // value is char !!
		TreeNode left, right;
		TreeNode(char x) {
			val = x;
			left = right = null;
		}
	}

}

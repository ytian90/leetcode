package leetcode.binaryTree;
/**
 * Flatten BST to Double LinkedList
 * @author yutian
 * @since Feb 5, 2016
 */
public class FlattenBSTtoDoubleLinkedList {
	// Time ~O(N)
	private TreeNode head, tail;
	
	public void traversal(TreeNode node) {
		if (node == null) return;
		if (node.left != null) traversal(node.left);
		changeNode(node);
		if (node.right != null) traversal(node.right);
	}
	
	private void changeNode(TreeNode node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.left = tail;
			tail.right = node;
			tail = node;
		}
	}

	public TreeNode bstToLinkedList(TreeNode root) {
		traversal(root);
		return head;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(30);
        node2.left = node3;
        node2.right = node4;
        root.left = node1;
        root.right = node2;
        TreeNode head = new FlattenBSTtoDoubleLinkedList().bstToLinkedList(root);
        
        while(head != null){
            System.out.println(head.val);
            head = head.right;
        }
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int val) {
			this.val = val;
		}
	}

}

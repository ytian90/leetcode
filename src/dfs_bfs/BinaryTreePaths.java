package dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Paths
 * @author yutian
 * @since Aug 29, 2015
 */
class Node {
    String str;
    TreeNode node;
    public Node(String str, TreeNode node) {
        this.str = str;
        this.node = node;
    }
}

public class BinaryTreePaths {
	// recursion Time Complexity: O(n)
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        dfs(root, "", result);
        return result;
    }
    
    private static void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) result.add(path);
        path += "->";
        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }

    public List<String> binaryTreePathss(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }

    private void helper(TreeNode node, String path, List<String> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add((path.length() == 0) ? node.val + "" : path + "->" + node.val);
            return;
        }
        if (node.left != null)
            helper(node.left, (path.length() == 0) ? node.val + "" : path + "->" + node.val, res);
        if (node.right != null)
            helper(node.right, (path.length() == 0) ? node.val + "" : path + "->" + node.val, res);
    }
    
    // iteration Time Complexity: O(n)
    public static List<String> binaryTreePaths2(TreeNode root) {
    	List<String> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(Integer.toString(root.val), root));
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.node.left == null && n.node.right == null) {
                res.add(n.str);
            }
            if (n.node.left != null) {
                Node nn = new Node(n.str + "->" + n.node.left.val, n.node.left);
                q.add(nn);
            }
            if (n.node.right != null) {
                Node nn = new Node(n.str + "->" + n.node.right.val, n.node.right);
                q.add(nn);
            }
        }
        return res;
    }
    
    // iteration with hashmap
    public static List<String> binaryTreePaths3(TreeNode root) {
    	List<String> result = new ArrayList<>();
    	if (root == null) return result;
    	Queue<TreeNode> q = new LinkedList<>();
    	HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    	q.add(root);
    	while (!q.isEmpty()) {
    		TreeNode n = q.poll();
    		if (n.left == null && n.right == null) {
    			result.add(printPath(parent, n));
    		} else {
    			if (n.left != null) {
    				parent.put(n.left, n);
    				q.add(n.left);
    			}
    			if (n.right != null) {
    				parent.put(n.right, n);
    				q.add(n.right);
    			}
    		}
    	}
    	return result;
    }
    
    private static String printPath(HashMap<TreeNode, TreeNode> parent,
			TreeNode node) {
		String result = Integer.toString(node.val);
		while (parent.containsKey(node)) {
			node = parent.get(node);
			result = Integer.toString(node.val) + "->" + result;
		}
		return result;
	}

	public static void main(String[] args) {
    	TreeNode n0 = new TreeNode(1);
    	TreeNode n1 = new TreeNode(2);
    	TreeNode n2 = new TreeNode(3);
    	TreeNode n3 = new TreeNode(5);
    	n0.left = n1; n0.right = n2; n1.right = n3;
    	
    	System.out.println(binaryTreePaths(n0));
    }
	
}

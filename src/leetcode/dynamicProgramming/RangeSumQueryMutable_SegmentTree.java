package leetcode.dynamicProgramming;
/**
 * 307. Range Sum Query - Mutable with Segment Tree
 * @author yutian
 * @since Feb 15, 2016
 */
public class RangeSumQueryMutable_SegmentTree {

	// Time complexity of construction is O(nLogn) 
	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;
		
		public SegmentTreeNode (int start, int end) {
			this.start = start;
			this.end = end;
			this.sum = 0;
		}
	}
	
	SegmentTreeNode root;
	
	public RangeSumQueryMutable_SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
	

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		SegmentTreeNode result = new SegmentTreeNode(start, end);
		if (start == end) {
			result.sum = nums[start];
		} else {
			int mid = start + (end - start) / 2;
			result.left = buildTree(nums, start, mid);
			result.right = buildTree(nums, mid + 1, end);
			result.sum = result.left.sum + result.right.sum;
		}
		return result;
	}


	void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int pos, int val) {
    	if (root.start == root.end) {
    		root.sum = val;
    	} else {
    		int mid = root.start + (root.end - root.start) / 2;
    		if (mid >= pos) {
    			update(root.left, pos, val);
    		} else {
    			update(root.right, pos, val);
    		}
    		root.sum = root.left.sum + root.right.sum;
    	}
	}


	public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

	private int sumRange(SegmentTreeNode root, int start, int end) {
		if (root.start == start && root.end == end) {
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (end <= mid) {
				return sumRange(root.left, start, end);
			} else if (start >= mid + 1) {
				return sumRange(root.right, start, end);
			} else {
				return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
			}
		}
	}


	public static void main(String[] args) {
		RangeSumQueryMutable_SegmentTree t = 
				new RangeSumQueryMutable_SegmentTree(new int[]{1, 3, 5});
		System.out.println(t.sumRange(0, 2));
		t.update(1, 2);
		System.out.println(t.sumRange(0, 2));
		
	}

}

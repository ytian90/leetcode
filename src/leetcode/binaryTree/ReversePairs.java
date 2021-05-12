package leetcode.binaryTree;

import java.util.Arrays;

/**
 * 493. Reverse Pairs
 * @author ytian
 *
 */
public class ReversePairs {
	private static int count = 0;
	public static int reversePairs(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		mergeSort(nums, 0, nums.length - 1);
		return count;
	}
	private static void mergeSort(int[] nums, int left, int right){
		if(left >= right)
			return;
		int mid = left + (right - left) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		merge(nums, left, mid, right);
	}

	private static void merge(int[] nums, int left, int mid, int right){
		int[] temp = new int[right - left +1];
		int p = left;
		int q = mid + 1;
		while(p <= mid && q <= right){
			if((long)nums[p] > 2 * (long)nums[q]){
				count += mid - p + 1;
				q++;
			}else{
				p++;
			}
		}
		mergeHelper(temp, nums, left, mid, mid + 1, right);
		System.arraycopy(temp, 0, nums, left, right - left + 1);
	}

	private static void mergeHelper(int[] temp, int[] nums, int p, int mid, int q, int right) {
		int index = 0;
		while(p <= mid && q <= right){
			if(nums[p] < nums[q]){
				temp[index++] = nums[p++];
			}else{
				temp[index++] = nums[q++];
			}
		}
		while(p <= mid){
			temp[index++] = nums[p++];
		}
		while(q <= right){
			temp[index++] = nums[q++];
		}
	}

	public static void main(String[] args) {
		System.out.println(reversePairs(new int[]{1,3,2,3,1}));
//		System.out.println(reversePairs1(new int[]{2,4,3,5,1}));
	}
	
	// BST time complexity can go as bad as O(n^2)
	static class Node {
		int val, count;
		Node left, right;
		Node (int val) {
			this.val = val;
			this.count = 1;
		}
	}
	
	private static int search1(Node node, long val) {
		if (node == null) {
			return 0;
		} else if (val == node.val) {
			return node.count;
		} else if (val < node.val) {
			return node.count + search1(node.left, val);
		} else {
			return search1(node.right, val);
		}
	}
	
	private static Node insert1(Node node, int val) {
		if (node == null) {
			node = new Node(val);
		} else if (val == node.val) {
			node.count++;
		} else if (val < node.val) {
			node.left = insert1(node.left, val);
		} else {
			node.count++;
			node.right = insert1(node.right, val);
		}
		return node;
	}
	
	public static int reversePairs1(int[] nums) {
        int res = 0;
        Node root = null;
        for (int e : nums) {
        	res += search1(root, 2L * e + 1);
        	root = insert1(root, e);
        }
        return res;
    }
	
	// BIT
	private static int search2(int[] bit, int i) {
		int sum = 0;
		while (i < bit.length) {
			sum += bit[i];
			i += i & -i;
		}
		return sum;
	}
	
	private static void insert2(int[] bit, int i) {
		while (i > 0) {
			bit[i] += 1;
			i -= i & -i;
		}
	}
	
	public static int reversePairs2(int[] nums) {
		int res = 0;
		int[] copy = Arrays.copyOf(nums, nums.length);
		int[] bit = new int[copy.length + 1];
		
		Arrays.sort(copy);
		
		for (int e : nums) {
			res += search2(bit, index2(copy, 2L * e + 1));
			insert2(bit, index2(copy, e));
		}
		return res;
	}

	private static int index2(int[] arr, long val) {
		int l = 0, r = arr.length - 1, m = 0;
		
		while (l <= r) {
			m = l + ((r - l) >> 1);
			
			if (arr[m] >= val) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l + 1;
	}
	
	// partition recurrence relation
	public static int reversePairs3(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private static int helper(int[] nums, int l, int r) {
		if (l >= r) return 0;
		int m = l + ((r - l) >> 1);
		int res = helper(nums, l, m) + helper(nums, m + 1, r);
		int i = l, j = m + 1, k = 0, p = m + 1;
		int[] merge = new int[r - l + 1];
		
		while (i <= m) {
			while (p <= r && nums[i] > 2L * nums[p]) p++;
			res += p - (m + 1);
			
			while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
			merge[k++] = nums[i++];
		}
		
		while (j <= r) merge[k++] = nums[j++];
		
		System.arraycopy(merge, 0, nums, l, merge.length);
		return res;
	}

}

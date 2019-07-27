package sort;
/**
 * Basic Sort Algorithms
 * @author yutian
 * @since Jan 14, 2016
 */
public class SortAlgos {
	
	public void bubbleSort(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (nums[j - 1] > nums[j]) {
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					/*
					 * a = a + b;
					 * b = a - b;
					 * a = a - b;
					 */
				}
			}
		}
	}
	
	public void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) min = j;
			}
			int temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;
		}
	}
	
	public void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int index = nums[i]; int j = i;
			while (j > 0 && nums[j - 1] > index) {
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = index;
		}
	}
	
	public void mergeSort(Comparable[] a) {
		Comparable[] temp = new Comparable[a.length];
		mergeSort(a, temp, 0, a.length - 1);
	}

	private void mergeSort(Comparable[] a, Comparable[] temp, int left, int right) {
		if (left < right) {
			int center = left + (right - left) / 2;
			mergeSort(a, temp, left, center);
			mergeSort(a, temp, center + 1, right);
			merge(a, temp, left, center + 1, right);
		}
	}

	private void merge(Comparable[] a, Comparable[] temp, int left, int right,
			int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
		
		while (left <= leftEnd && right <= rightEnd) {
			if (a[left].compareTo(a[right]) <= 0) {
				temp[k++] = a[left++];
			} else {
				temp[k++] = a[right++];
			}
		}
		while (left <= leftEnd) { // copy rest of first half
			temp[k++] = a[left++];
		}
		while (right <= rightEnd) { // copy rest of right half
			temp[k++] = a[right++];
		}
		// copy test back
		for (int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = temp[rightEnd];
		}
	}

	public static void main(String[] args) {

	}

}

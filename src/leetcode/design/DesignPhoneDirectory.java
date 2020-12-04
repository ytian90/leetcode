package leetcode.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 379. Design Phone Directory
 * @author yutian
 * @since Aug 15, 2016
 */
public class DesignPhoneDirectory {

	Set<Integer> set;
	Queue<Integer> available;
	int maxNumber;

	/** Initialize your data structure here
	 @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public DesignPhoneDirectory(int maxNumbers) {
		this.set = new HashSet<>();
		this.available = new LinkedList<>();
		for (int i = 0; i < maxNumbers; i++) {
			available.add(i);
		}
		this.maxNumber = maxNumbers;
	}

	/** Provide a number which is not assigned to anyone.
	 @return - Return an available number. Return -1 if none is available. */
	public int get() {
		Integer res = available.poll();
		if (res == null) {
			return -1;
		}
		set.add(res);
		return res;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		if (number < 0 || number >= maxNumber) {
			return false;
		}
		return !set.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (set.remove(number)) {
			available.add(number);
		}
	}

	/**
	 * Your PhoneDirectory object will be instantiated and called as such:
	 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
	 * int param_1 = obj.maxPerformance();
	 * boolean param_2 = obj.check(number);
	 * obj.release(number);
	 */
	
	public static void main(String[] args) {
		DesignPhoneDirectory directory = new DesignPhoneDirectory(3);
		directory.get();
		directory.get();
		System.out.println(directory.check(2));
		directory.get();
		System.out.println(directory.check(2));
		directory.release(2);
		System.out.println(directory.check(2));
	}

}

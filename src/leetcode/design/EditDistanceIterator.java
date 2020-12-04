package leetcode.design;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Edit distance iterator
 * http://www.1point3acres.com/bbs/thread-121661-1-1.html
 * @author yutian
 * @since Jan 31, 2016
 */
public class EditDistanceIterator {
	
	class IntFileIterator implements Iterator<Integer> {
		private List<Integer> elements;
		private int index;
		
		public IntFileIterator(String path) {
			index = -1;
			elements = new LinkedList<Integer>();
			readFile(path);
		}
		
		private void readFile(String path) {
			FileReader fr = null;
			BufferedReader br = null;
			Scanner in = null;
			try {
				fr = new FileReader(path);
				br = new BufferedReader(fr);
				in = new Scanner(br);
				while (in.hasNextInt()) {
					elements.add(in.nextInt());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) in.close();
					if (br != null) br.close();
					if (fr != null) fr.close();
				} catch (IOException e) {
					
				}
			}
		}

		public boolean hasNext() {
			return index < elements.size() - 1;
		}
		public Integer next() {
			if (index == elements.size()) return null;
			return elements.get(++index);
		}
		
		public void print() {
			System.out.println(elements);
		}
	}
	
	class FileCompare {
		public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
			boolean ins_a = false, ins_b = false, replace = false, diff = false;
			int pre_a = 0, pre_b = 0;
			while (a.hasNext() && b.hasNext()) {
				int cur_a = a.next(), cur_b = b.next();
				if (!ins_a && !ins_b && !replace) {
					if (cur_a != cur_b) {
						ins_a = ins_b = replace = diff = true;
					}
				} else {
					if (ins_a && pre_b != cur_a) {
						ins_a = false;
					}
					if (ins_b && pre_a != cur_b) {
						ins_b = false;
					}
					if (replace && cur_a != cur_b) {
						replace = false;
					}
					if (!ins_a && !ins_b && !replace) {
						return false;
					}
				}
				pre_a = cur_a;
				pre_b = cur_b;
			}
			if (!a.hasNext() && !b.hasNext()) {
				return !diff || replace;
			} else if (a.hasNext()) {
				int cur_a = a.next();
				return (!diff || (ins_a && pre_b == cur_a)) && !a.hasNext();
			} else if (b.hasNext()) {
				int cur_b = b.next();
				return (!diff || (ins_b && pre_a == cur_b)) && !b.hasNext();
			}
			return true;
		}
	}
	
	/*
	 * Return if the distance between a and b is at most 1
	 * Distance: minimum number of modifications to make a = b
	 * Modification:
	 * 	1. change an int in a
	 * 	2. insert an int to a 
	 * 	3. remove an int from a 
	 */

	public static void main(String[] args) {
		
		
	}

}

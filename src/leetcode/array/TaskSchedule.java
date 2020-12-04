package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Task Schedule
 * https://shawnlincoding.wordpress.com/page/3/
 * [1,2,1,2] N=3
	1,2,_,_,1,2 得到len=6
	因为要保持任务执行顺序一样
	所以第二个任务1只能等上3个单位时间 才能执行 这三个单位时间 第一个被任务2占据 后两个是用'_'来表示单位时间
	又比如.
	[1] N=4 无论N是多少 都只输出长度1.
	因为后面已经没有要继续执行的任务了，尤其是相同的任务
	又比如
	[1,2,1,2] N=2
	[1,2,_,1,2] 长度应该是5
 * @author yutian
 * @since Feb 4, 2016
 */
public class TaskSchedule {
	
	// Method 1
	// 每种task都有冷却时间，比如task1执行后，要经过interval时间后才能再次执行，求总共所需时间。
	// 用HashMap保存每一个task的下一次可以开始执行的最早时间
	public static int executeTime(int[] input, int N) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(input[0], 1);
		for (int i = 1; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				int maxNum = Math.max(map.get(input[i - 1]) + 1, map.get(input[i]) + N + 1);
				map.put(input[i], maxNum);
			} else {
				map.put(input[i], map.get(input[i - 1]) + 1);
			}
		}
		return map.get(input[input.length - 1]);
	}
	
	public static void main(String[] args) {
//		System.out.println(task(new int[]{1, 2, 1, 2}, 3));
		
//		int[] tasks = {1, 1, 1, 1, 2};
//		TaskSchedule ins = new TaskSchedule();
//        System.out.println(ins.executeTime(tasks, 3));
//        int[] res = ins.optimal(tasks, 2);
//        for(int i : res){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        
//        int[] tasks2 = {1, 2, 1, 2};
//		TaskSchedule ins2 = new TaskSchedule();
//        System.out.println(ins2.executeTime(tasks2, 3));
//        int[] res2 = ins2.optimal(tasks2, 3);
//        for(int i : res2){
//            System.out.print(i + " ");
//        }
		
		int[] tasks = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
		TaskSchedule ins = new TaskSchedule();
        System.out.println(ins.executeTime(tasks, 2));
        int[] res = ins.optimal(tasks, 2);
        for(int i : res){
            System.out.print(i + " ");
        }
	}
	
	// Method 2
	public int executeTime1(int[] tasks, int N) {
		if (tasks == null)
			throw new IllegalArgumentException();
		if (tasks.length == 0) return 0;
		// task ID, last execute time
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int count = 0;
		for (int i = 0; i < tasks.length; i++) {
			int task = tasks[i];
			if (!hashmap.containsKey(task)) {
				count++;
				hashmap.put(task, count);
			} else {
				int lastTime = hashmap.get(task);
				if (count - lastTime >= N) {
					count++;
				} else {
					count = lastTime + N;
					count++;
				}
				hashmap.put(task, count);
			}
		}
		return count;
	}
	
	private class Entry implements Comparable<Entry> {
		int task;
		int count;
		public Entry(int t, int c) {
			task = t;
			count = c;
		}
		public int compareTo(Entry that) {
			return that.count - count;
		}
	}
	
	/*
	 * followup是tasks是无序的.一开始是有序的，比如说1, 1, 2, 1，一定要先执行第一个task1，
	 * 然后等task1恢复，再执行第2个task1，再执行task2..... followup是无序的，
	 * 就是不用按给的顺序执行，也就是可以先执行task1，然后task1还没恢复时，先执行task2, etc......
	 * 
	 * 正确的做法应该是统计每个task的frequency，然后每次选frequency最高并且可以执行的task执行。
	 * 用maxHeap存每个task的剩余frequency
	 */
	
	public int[] optimal(int[] tasks, int N) {
		if (tasks == null || tasks.length == 0) {
			throw new IllegalArgumentException();
		}
		int len = tasks.length;
		int[] res = new int[len];
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		for (int task: tasks) {
			if (!hashmap.containsKey(task)) {
				hashmap.put(task, 1);
			} else {
				hashmap.put(task, hashmap.get(task) + 1);
			}
		}
		Entry[] entries = new Entry[hashmap.size()];
		int src = 0, total = 0;
		for (int task : hashmap.keySet()) {
			entries[src++] = new Entry(task, hashmap.get(task));
			total += hashmap.get(task);
		}
		Arrays.sort(entries);
		// arrange
		src = 0;
		int gap = 0;
		while (total != 0) {
			for (int i = 0; i < entries.length; i++) {
				Entry entry = entries[i];
				if (entry.count != 0) {
					res[src++] = entry.task;
					gap++;
					total--;
					entry.count--;
				}
				if (gap == N + 1) {
					gap = 0;
					break;
				}
			}
		}
		return res;
		
	}

	

}

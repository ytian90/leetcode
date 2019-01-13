package summary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://instant.1point3acres.com/thread/139300
 * snapchat
 * @author yutian
 * @since Apr 1, 2016
 */
public class TopoSort {

	/*
	 * 安装程序 with dependecies，求出任一正确的安装顺序，
	 * follow incr 求出安装顺序但是需要dependecies少的程序先安装
	 */
	public static void main(String[] args) {
		
	}
	
	private boolean hasCycle;
	private boolean[] marked, onStack;
	private Stack<Integer> postorder;
	
	public ArrayList<Task> topologicalOrder(ArrayList<Task> input) {
		int V = input.size();
		hasCycle = false;
		marked = new boolean[V];
		onStack = new boolean[V];
		postorder = new Stack<>();
		for (int v = 0; v < V; v++) {
			if (!marked[v]) dfs(v, input);
		}
		ArrayList<Task> result = new ArrayList<Task>();
		if (hasCycle) return result;
		else {
			while (!postorder.isEmpty()) {
				result.add(input.get(postorder.pop()));
			}
			return result;
		}
	}
	
	private void dfs(int v, ArrayList<Task> input) {
		marked[v] = true;
		onStack[v]= true;
		for (int w : input.get(v).getDependencies()) {
			if (hasCycle) return;
			else if (!marked[w]) dfs(w, input);
			else if (onStack[w]) hasCycle = true;
		}
		postorder.push(v); // modification: record postorder
		onStack[v] = false;
	}

	public static class Task {
		void execute() {
			
		}
		List<Integer> getDependencies() {
			return null;
		}
	}

}

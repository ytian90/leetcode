package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 444. Sequence Reconstruction
 * @author yutian
 *
 */
public class SequenceReconstruction {
	
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] seq : seqs) {
        	for (int i = 0; i < seq.length; i++) {
        		graph.putIfAbsent(seq[i], new ArrayList<Integer>());
        		indegree.putIfAbsent(seq[i], 0);
        		if (i > 0) {
        			graph.get(seq[i - 1]).add(seq[i]);
        			indegree.put(seq[i], indegree.get(seq[i]) + 1);
        		}
        	}
        }
        if (org.length != indegree.size()) {
        	return false;
        }
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
        	if (entry.getValue() == 0) {
        		q.add(entry.getKey());
        	}
        }
        int index = 0;
        while (!q.isEmpty()) {
        	if (q.size() > 1) {
        		return false;
        	}
        	int curr = q.poll();
        	if (org[index++] != curr) {
        		return false;
        	}
        	for (int nb : graph.get(curr)) {
        		indegree.put(nb, indegree.get(nb) - 1);
        		if (indegree.get(nb) == 0) {
        			q.add(nb);
        		}
        	}
        }
        return index == org.length;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

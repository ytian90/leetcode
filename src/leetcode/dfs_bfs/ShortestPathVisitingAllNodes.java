package leetcode.dfs_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 847. Shortest Path Visiting All Nodes
 */
public class ShortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;

        Set<String> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1 << i);
            q.offer(node);
            visited.add(node.toString());
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.mask == fullMask) {
                    return level;
                }
                for (int next : graph[node.id]) {
                    Node nextNode = new Node(next, node.mask | (1 << next));
                    if (visited.contains(nextNode.toString())) {
                        continue;
                    }
                    q.offer(nextNode);
                    visited.add(nextNode.toString());
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][]{
                {1, 2, 3},
                {0},
                {0},
                {0}
        }));
        System.out.println(shortestPathLength(new int[][]{
                {1, 2, 3},
                {0},
                {0},
                {0}
        }));
    }

    static class Node {
        int id;
        int mask;

        Node(int id, int mask) {
            this.id = id;
            this.mask = mask;
        }

        public String toString() {
            return id + ":" + mask;
        }
    }
}

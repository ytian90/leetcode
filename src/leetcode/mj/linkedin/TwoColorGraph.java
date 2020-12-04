package leetcode.mj.linkedin;

import java.util.Iterator;
import java.util.LinkedList;

/*
Question: 2-color
问一个图能否用两种颜色涂色，要求是每条边的两个顶点颜色不同。
It means to check if there is a circle in an undirected leetcode.graph
 */
public class TwoColorGraph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[];

    TwoColorGraph(int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void addEdges(int[][] edges) {
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
    }

    public boolean isCycleHelper(int v, boolean visited[], int parent) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> iterator = adj[v].iterator();
        while  (iterator.hasNext()) {
            i = iterator.next();
            if (!visited[i]) {
                if (isCycleHelper(i, visited, v))
                    return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclic() {
        boolean visited[] = new boolean[V];
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (isCycleHelper(u, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ableToColor() {
        return !isCyclic();
    }

    public static void main(String[] args) {
        TwoColorGraph obj = new TwoColorGraph(5);
        int[][] edges = new int[][]{
                {1, 0},
                {0, 2},
                {1, 2},
                {0, 3},
                {3, 4}
        };
        obj.addEdges(edges);
        System.out.println(obj.ableToColor());
    }
}

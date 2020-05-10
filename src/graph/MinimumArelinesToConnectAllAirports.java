package graph;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=qz9tKlF431k
 *
 */
public class MinimumArelinesToConnectAllAirports {
    private final static List<String> airports = Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM",
            "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD");
    private final static List<List<String>> routes = Arrays.asList(
            Arrays.asList("DSM", "ORD"),
            Arrays.asList("ORD", "BGI"),
            Arrays.asList("BGI", "LGA"),
            Arrays.asList("SIN", "CDG"),
            Arrays.asList("CDG", "SIN"),
            Arrays.asList("CDG", "BUD"),
            Arrays.asList("DEL", "DOH"),
            Arrays.asList("DEL", "CDG"),
            Arrays.asList("TLV", "DEL"),
            Arrays.asList("EWR", "HND"),
            Arrays.asList("HND", "ICN"),
            Arrays.asList("HND", "JFK"),
            Arrays.asList("ICN", "JFK"),
            Arrays.asList("JFK", "LGA"),
            Arrays.asList("EYW", "LHR"),
            Arrays.asList("LHR", "SFO"),
            Arrays.asList("SFO", "SAN"),
            Arrays.asList("SFO", "DSM"),
            Arrays.asList("SAN", "EYW"));

    static class Graph {
        private int V;
        private List<Integer>[] adj;

        Graph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void dfsGenForRep(int v, boolean[] visited, int rep, int[] who, Map<String, Integer> airportsIds) {
            visited[v] = true;
            who[v] = rep;
            for (Map.Entry<String, Integer> entry : airportsIds.entrySet()) {
                if (entry.getValue() == v) {
                    System.out.print(entry.getKey() + " ");
                }
            }

            for (int i : adj[v]) {
                if (!visited[i]) {
                    dfsGenForRep(i, visited, rep, who, airportsIds);
                }
            }
        }

        Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                for (int i : adj[v]) {
                    g.adj[i].add(v);
                }
            }
            return g;
        }

        void fillOrder(int v, boolean[] visited, Stack stack) {
            visited[v] = true;
            for (int i : adj[v]) {
                if (!visited[i]) {
                    fillOrder(i, visited, stack);
                }
            }
            stack.push(new Integer(v));
        }

        int solve(String airportName) {
            int n = airports.size();
            Map<String, Integer> airportsIds = new HashMap<>();
            for (int i = 0; i < n; i++) {
                airportsIds.put(airports.get(i), i);
            }

            for (List<String> e : routes) {
                addEdge(airportsIds.get(e.get(0)), airportsIds.get(e.get(1)));
            }
            Stack stack = new Stack();
            int[] who = new int[V];
            Arrays.fill(who, -1);
            boolean[] visited = new boolean[V];
            int[] deg = new int[V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    fillOrder(i, visited, stack);
                }
            }
            Graph g = getTranspose();

            for (int i = 0; i < V; i++) {
                visited[i] = false;
            }

            while (!stack.isEmpty()) {
                int v = (int) stack.pop();

                if (!visited[v]) {
                    g.dfsGenForRep(v, visited, v, who, airportsIds);
                    System.out.println();
                }
            }

            for (int i = 0; i < V; i++) {
                for (int j : adj[i]) {
                    if (who[i] != who[j]) {
                        ++deg[who[j]];
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < V; i++) {
                if (who[i] == i && deg[i] == 0 && i != who[airportsIds.get(airportName)]) {
                    res++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(airports.size());
        System.out.println();
        System.out.println(g.solve("LGA"));
    }
}

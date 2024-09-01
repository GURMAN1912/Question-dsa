package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathUndirected {
    public static class Pair<T> {
        public T v;
        public T w;

        public Pair(T v, T w) {
            this.v = v;
            this.w = w;
        }
    }

    public static List<Integer> shortestPath(int s, int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Pair<Integer>> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        pq.add(new Pair<>(s, 0));
        dist[s] = 0;
        parent[s] = s;

        while (!pq.isEmpty()) {
            Pair<Integer> top = pq.poll();
            int v = top.v;
            int w = top.w;

            for (int i = 0; i < adj.get(v).size(); i++) {
                int u = adj.get(v).get(i).get(0);
                int dis = adj.get(v).get(i).get(1);

                if (dist[u] > w + dis) { // Corrected condition
                    parent[u] = v;
                    dist[u] = w + dis;
                    pq.add(new Pair<>(u, dist[u]));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int node = n - 1; // Assuming the destination is the last node

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(s); // Add the source node at the end

        // Reverse the path to get it from source to destination
        List<Integer> result = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            result.add(path.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes in the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Initializing adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph edges (u, v, w): u -> v with weight w
        adj.get(0).add(new ArrayList<>(List.of(1, 9)));
        adj.get(0).add(new ArrayList<>(List.of(2, 6)));
        adj.get(0).add(new ArrayList<>(List.of(3, 5)));
        adj.get(0).add(new ArrayList<>(List.of(4, 20)));
        adj.get(2).add(new ArrayList<>(List.of(4, 2)));
        adj.get(2).add(new ArrayList<>(List.of(3, 4)));

        int source = 0; // Starting node for Dijkstra's algorithm

        // Get the shortest path from source to destination (n-1)
        List<Integer> path = shortestPath(source, n, adj);

        // Print the shortest path from source to the last node
        System.out.println("Shortest path from node " + source + " to node " + (n - 1) + ": " + path);
    }
}

package graph;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPath {
    public static class Pair {
        public int v; // destination node
        public int w; // weight of the edge

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void topoSort(int v, ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int[] vis) {
        vis[v] = 1;
        for (int i = 0; i < adj.get(v).size(); i++) {
            int u = adj.get(v).get(i).v;
            if (vis[u] == 0) {
                topoSort(u, adj, st, vis);
            }
        }
        st.push(v);
    }

    public static int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0]; // start node
            int v = edges[i][1]; // end node
            int w = edges[i][2]; // weight
            adj.get(u).add(new Pair(v, w));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // Perform topological sort
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, st, vis);
            }
        }

        int INF = (int) 1e9;
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = INF; // Initialize distances to infinity
        }
        dis[0] = 0; // Assuming source is node 0

        // Process nodes in topological order
        while (!st.isEmpty()) {
            int u = st.pop();
            if (dis[u] != INF) { // If the node has been reached
                for (Pair p : adj.get(u)) {
                    int v = p.v;
                    int w = p.w;
                    if (dis[u] + w < dis[v]) {
                        dis[v] = dis[u] + w;
                    }
                }
            }
        }

        // Convert unreachable nodes' distances to -1
        for (int i = 0; i < n; i++) {
            if (dis[i] == INF) {
                dis[i] = -1;
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
            {0, 1, 2},
            {1, 2, 3},
            {2, 3, 6},
            {0, 4, 1},
            {4, 2, 2},
            {4, 5, 4},
            {5, 1, 3}
        };

        int[] dis = shortestPath(n, edges.length, edges);
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i] + " ");
        }
    }
}

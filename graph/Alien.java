package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alien {
    public static String findOrder(String[] dict, int n, int k) {
        // Initialize adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph from the given dictionary
        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Perform topological sort
        List<Integer> topo = topoSort(k, adj);
        if (topo.isEmpty()) {
            return ""; // return empty string if a valid order doesn't exist
        }

        // Build the resulting string from the topological order
        StringBuilder ans = new StringBuilder();
        for (int i : topo) {
            ans.append((char) (i + 'a'));
        }
        return ans.toString();
    }

    public static List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int u : adj.get(i)) {
                inDegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int v = q.poll();
            topoOrder.add(v);
            for (int u : adj.get(v)) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    q.offer(u);
                }
            }
        }

        // If topological sort does not include all nodes, a cycle exists
        if (topoOrder.size() != n) {
            return new ArrayList<>(); // return empty list if a valid order doesn't exist
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        String[] dict = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println(findOrder(dict, dict.length, 26));
    }
}

package graph;

import java.util.ArrayList;

public class DirectedGraph {
    public static boolean cycle(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] vis = new int[v];
        int[] pathvis = new int[v];
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathvis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int s, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis) {
        vis[s] = 1;
        pathvis[s] = 1;
        for (int u : adj.get(s)) {
            if (vis[u] == 0) {
                if (dfs(u, adj, vis, pathvis)) {
                    return true;
                }
            } else if (pathvis[u] == 1) {
                return true;
            }
        }
        pathvis[s] = 0;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<4;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            adj.add(temp);
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        System.out.println(cycle(adj, 4));

    }
}

package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DijkstraSet {
    public static class Pair<T>{
        public T v;
        public T w;
        Pair(T v,T w){
            this.v=v;
            this.w=w;
        } 
    }
     public static int[] dijkstra(int s,ArrayList<ArrayList<ArrayList<Integer>>> adj){
        int n=adj.size();
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Set<Pair<Integer>> set=new HashSet<>();
        set.add(new Pair<Integer>(s, 0));
        dist[0]=0;
        while(set.size()!=0){
            Pair<Integer> top=set.iterator().next();
            set.remove(top );
            int w=(int) top.w;
            int v=(int) top.v;
            for(int i=0;i<adj.get(v).size();i++){
                int u=adj.get(v).get(i).get(0);
                int dis=adj.get(v).get(i).get(1);
                if(w+dis<dist[u]){
                    set.remove(new Pair<Integer>(u,dist[u]));
                    dist[u]=w=dis;
                    set.add(new Pair<Integer>(u, dist[u]));
                }
            }
        }
        return dist;
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
        adj.get(0).add(new ArrayList<>(List.of(4, 3)));
        adj.get(2).add(new ArrayList<>(List.of(1, 2)));
        adj.get(2).add(new ArrayList<>(List.of(3, 4)));
        
        int source = 0; // Starting node for Dijkstra's algorithm
        
        // Get shortest paths from source
        int[] distances = dijkstra(source, adj);
        
        // Print shortest distances from source to all nodes
        System.out.println("Shortest distances from node " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + " : " + distances[i]);
        }
    }
}

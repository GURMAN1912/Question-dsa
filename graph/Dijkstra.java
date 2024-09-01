package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



public class Dijkstra {
    public static class Pair{
        public int v;
        public int w;
        public Pair(int v,int w){
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
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.w-y.w);
        pq.add(new Pair(s, 0));
        dist[0]=0;
        while(pq.size()!=0){
            int w=pq.peek().w;
            int v=pq.peek().v;
            pq.remove();
            for(int i=0;i<adj.get(v).size();i++){
                int u=adj.get(v).get(i).get(0);
                int dis=adj.get(v).get(i).get(1);
                if(w+dis<dist[u]){
                    dist[u]=w=dis;
                    pq.add(new Pair(u, dist[u]));
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

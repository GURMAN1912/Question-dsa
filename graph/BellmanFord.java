package graph;

import java.util.ArrayList;

public class BellmanFord {
   public static class Pair<T> {
      public T v;
      public T w;

      public Pair(T v, T w) {
         this.v = v;
         this.w = w;
      }
   }   
   public static int[] bellmanFord(int s, int n, ArrayList<ArrayList<Integer>> edges) {
      int[] dist = new int[n];
      for (int i = 0; i < n; i++) {
         dist[i] = Integer.MAX_VALUE;
      }
        dist[s] = 0;
        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer> edge:edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int w=edge.get(2);
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        //check for negative cycle
        for(ArrayList<Integer> edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            int w=edge.get(2);
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                return new int[]{-1};
            }
        }

      return dist;
   } 
   public static void main(String[] args) {
      ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
      edges.add(new ArrayList<>());
      edges.get(0).add(0);
      edges.get(0).add(1);
      edges.get(0).add(1);
      edges.add(new ArrayList<>());
      edges.get(1).add(1);
      edges.get(1).add(2);
      edges.get(1).add(1);
      edges.add(new ArrayList<>());
      edges.get(2).add(2);
      edges.get(2).add(3);
      edges.get(2).add(1);
      edges.add(new ArrayList<>());
      edges.get(3).add(3);
      edges.get(3).add(0);
      edges.get(3).add(-3);
      int[] dist = bellmanFord(0, 4, edges);
      for (int i = 0; i < dist.length; i++) {
         System.out.println(i + " " + dist[i]);
      }
   }
}

package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static class Pair<T> {
        public T v;
        public T w;

        public Pair(T v, T w) {
            this.v = v;
            this.w = w;
        }
    }   
    public static int spanningTree(int n,ArrayList<ArrayList<ArrayList<Integer>>> adj ){
        PriorityQueue<Pair<Integer>> pq=new PriorityQueue<>((x,y)->x.w-y.w);
        ArrayList<ArrayList<Integer>> mst=new ArrayList<>();
        int []visited=new int[n];
        pq.add(new Pair<>(0,0));
        int ans=0;  
        while(!pq.isEmpty()){
            Pair<Integer> top=pq.poll();
            int v=top.v;
            int w=top.w;
            if(visited[v]==1){
                continue;
            }
            visited[v]=1;
            ans+=w;
            for(int i=0;i<adj.get(v).size();i++){
                int u=adj.get(v).get(i).get(0);
                int dis=adj.get(v).get(i).get(1);
                if(visited[u]==0){
                    pq.add(new Pair<>(u,dis));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.get(0).add(new ArrayList<>());
        adj.get(0).get(0).add(1);
        adj.get(0).get(0).add(2);
        adj.add(new ArrayList<>());
        adj.get(1).add(new ArrayList<>());
        adj.get(1).get(0).add(0);
        adj.get(1).get(0).add(2);
        adj.get(1).add(new ArrayList<>());
        adj.get(1).get(1).add(2);
        adj.get(1).get(1).add(3);
        adj.add(new ArrayList<>());
        adj.get(2).add(new ArrayList<>());
        adj.get(2).get(0).add(0);
        adj.get(2).get(0).add(1);
        adj.get(2).add(new ArrayList<>());
        adj.get(2).get(1).add(1);
        adj.get(2).get(1).add(3);
        adj.add(new ArrayList<>());
        adj.get(3).add(new ArrayList<>());
        adj.get(3).get(0).add(2);
        adj.get(3).get(0).add(3);
        System.out.println(spanningTree(4,adj));
    }
}

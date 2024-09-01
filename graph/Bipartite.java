 package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        boolean ans;
        boolean finalAns=true;
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        for(int i=0;i<n;i++){
                if(color[i]==-1){
                    ans=dfs(graph,color,i);
                    finalAns=finalAns&& ans;
                }
        }
        return finalAns;
    }
    private boolean bfs(int[][]graph,int []color,int s){
       Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        color[s] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            int c = color[v];
            for (int u : graph[v]) {
                if (color[u] == -1) {
                    if (c == 0) {
                        color[u] = 1;
                    } else {
                        color[u] = 0;
                    }
                    q.offer(u);
                } else if (color[u] == color[v]) {
                    return false;
                }
            }

        }
        return true; 
    }
    private boolean dfs(int [][]graph,int []color,int s){
        boolean ans=true;
        for(int u:graph[s]){
            if(color[u]==-1 )
            {
                color[u]=1-color[s];
                ans= ans && (dfs(graph,color,u));
            }
            else if(color[u]==color[s] ){
                return false;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Bipartite ob=new Bipartite();
        int[][] board={{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(ob.isBipartite(board));
    }
}
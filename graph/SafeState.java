package graph;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeState {
    public static List<Integer> safeState(int n,List<List<Integer>> adj){
        List<List<Integer>> revAdj=new ArrayList<>();
        for(int i=0;i<n;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            for(int u:adj.get(i)){
                revAdj.get(u).add(i);
                in[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.offer(in[i]);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int v=q.poll();
            list.add(v);
            for(int u:revAdj.get(v)){
                in[u]--;
                if(in[u]==0){
                    q.offer(u);
                }
            }
        }
        Collections.sort(list);
        return list;
    } 
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<4;i++){
            List<Integer> temp=new ArrayList<>();
            adj.add(temp);
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        System.out.println(safeState(4, adj));
    }
}

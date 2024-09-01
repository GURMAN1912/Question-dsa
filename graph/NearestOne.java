package graph;


import java.util.LinkedList;

import java.util.Queue;
public class NearestOne {
    public static class Pair {
        public int row;
        public int col;
        public int d;
        public Pair(int row,int col,int d){
            this.row=row;
            this.col=col;
            this.d=d;
        }
    }
    public static int[][] Nearest(int[][] grid){
        int[][] dist=new int[grid.length][grid[0].length];
        int[][] vis=new int[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.add(new Pair( i, j, 0));
                }
            }
        }
        int []dr={1,0,-1,0};
        int []dc={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c =q.peek().col;
            int d=q.peek().d;
            q.poll();
            dist[r][c]=d;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<grid.length && nc>=0&& nc<grid[0].length &&grid[nr][nc]==0 && vis[nr][nc]==0 ){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr, nc, d+1));
                }
            } 
        }
        
        return dist;

    } 
    public static void main(String[] args) {
        int[][] grid={{0,0,0},{0,1,0},{1,0,1}};
        int[][] ans=Nearest(grid);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(ans[i][j]);
            }
            System.err.println();
        }
    }
}

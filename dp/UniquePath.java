package dp;

import java.util.Arrays;

public class UniquePath {
    public static int uniquePathsdpt(int m, int n) {
        int [][]dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public static int uniquePathsdp(int m, int n) {
        int [][]dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        fdp(m-1,n-1,dp);        
        return fdp(m-1,n-1,dp);
    }
    public static int fdp(int i,int j,int [][]dp){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return dp[0][0]=1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=f(i-1,j);
        int left=f(i,j-1);
        return dp[i][j]=up+left;
    }
    public static int uniquePaths(int m, int n) {
        return f(m-1,n-1);        
    }
    private static int f(int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        int up=f(i-1,j);
        int left=f(i,j-1);
        return up+left;
    }
    public static void main(String[] args) {
        int m=4;
        int n=4;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePathsdp(m, n));
        System.out.println(uniquePathsdpt(m, n));
    }
    
}

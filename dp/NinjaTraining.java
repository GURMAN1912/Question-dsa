package dp;

import java.util.Arrays;

public class NinjaTraining {
    public static int  f(int n,int last,int [][]arr,int [][]dp ){
        if(dp[n][last]!=-1)
        {
            return dp[n][last];
        }
        if(n==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                int max=0;
                if(i!=last){
                    maxi=Math.max(max,arr[n][i]);
                }    
            }
            return dp[n][last]=maxi;
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int act=arr[n][i]+f(n-1, i, arr, dp);
                maxi=Math.max(act,maxi);
            }
        }
        return dp[n][last]=maxi;
    }
    public  static  int ninjaMemo(int [][]arr ,int n, int [][]dp){
        return f(n-1,3,arr,dp);
        
    }
    public static int ninjaTable(int [][]arr,int n,int [][]dp){
        dp[0][0]=Math.max(arr[0][1],arr[0][2]);
        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
        dp[0][2]=Math.max(arr[0][1],arr[0][0]);
        dp[0][3]=Math.max(arr[0][1],Math.max(arr[0][1],arr[0][2]));
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=0;
                for(int k=0;k<=2;k++){
                    if(k!=j){
                        int act=arr[i][k]+dp[n-1][k];
                        dp[i][j]=Math.max(dp[i][j],act);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    public static void main(String[] args){
        int n=3;
        int [][] arr={{1,2,5},{3,1,1},{3,3,3}};
        int [][] dp = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(ninjaMemo(arr,n,dp));
        System.out.println(ninjaTable(arr,n,dp));

    }
}

package dp;

import java.util.Arrays;
public class FrogJump {
    public static int minCost(int[] heights){
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(dp[i-1] + Math.abs(heights[i] - heights[i-1]), dp[i-2] + Math.abs(heights[i] - heights[i-2]));
        }
        return dp[n-1];
    }


    public static int minCost2(int[] heights,int n){
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n-1, heights, dp);
    }


    public static int f(int n, int[] heights, int[] dp){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.abs(heights[1] - heights[0]);
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = Math.min(f(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]), f(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]));
        return dp[n];
    }


    public static int kJumps(int[] heights, int k){
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return kJumps(heights, n-1, k, dp);
    }


    public static int kJumps(int[] heights, int n, int k, int[] dp){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.abs(heights[1] - heights[0]);
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(n-i >= 0){
                minCost = Math.min(minCost, kJumps(heights, n-i, k, dp) + Math.abs(heights[n] - heights[n-i]));
            }
        }
        dp[n] = minCost;
        return dp[n];
    }


    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 20};
        System.out.println(minCost(heights));
        System.out.println(minCost2(heights, heights.length));
        System.out.println(kJumps(heights, 3));
    }
}

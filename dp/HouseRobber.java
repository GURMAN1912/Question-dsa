package dp;

import java.util.Arrays;

public class HouseRobber {
    public static int houseRobber(int [] arr){
        int n=arr.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return f(arr,n-1,dp);        
    }
    public static int f(int []arr,int i,int [] dp){
        if(i==0){
            return arr[0];
        }
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int pick=arr[i]+f(arr, i-2, dp);
        int notPick=0+f(arr, i-1, dp);
        return dp[i]=Math.max(pick,notPick);
    }
    public static int rob(int[] arr){
        int n=arr.length;
        int []dp=new int[n+1];
        dp[0]=arr[0];
        int pick=0,notPick=0;
        for(int i=1;i<n;i++){

            pick=arr[i] + ((i>1)?dp[i-2]:0);
            notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }

        return dp[n-1];
    }
    public static int circle(int [] nums){
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int[] nums1=Arrays.copyOfRange(nums, 0, n-1);
        int [] nums2=Arrays.copyOfRange(nums, 1, n);
        return Math.max(f(nums1, n-2, dp), f(nums2, n-2, dp));
    }
    public static void main(String[] args) {
        int [] arr={2,7,9,3,1};
        System.out.println(houseRobber(arr));
        System.out.println(rob(arr));
        System.out.println(circle(arr));
    }
}

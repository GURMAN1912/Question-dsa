package dp;
public class SubsetSum {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean [][] dp=new boolean[N][sum+1];
        for(int i=0;i<N;i++){
            dp[i][0]=true;
        }
        if(sum>=arr[0]){
            dp[0][arr[0]]=true;
        }
        for(int i=1;i<N;i++){
            for(int target=1;target<=sum;target++){
                boolean NotTaken=dp[i-1][target];
                boolean taken=false;
                if(arr[i]<=target){
                    taken=dp[i-1][target-arr[i]];
                }
                dp[i][target]=NotTaken||taken;
            }
            
        }
        return dp[N-1][sum];
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4};
        System.out.println(isSubsetSum(4, arr, 5));
    }
}
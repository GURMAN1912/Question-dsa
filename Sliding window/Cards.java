public class Cards {
    public static void main(String[] args) {
        Cards ob=new Cards();
        int [] arr={6,2,3,4,7,2,1,7,1};
        int k=4;
        System.err.println(ob.maximumPoint(arr,k));
    }
    public int maximumPoint(int [] arr,int k){
        int lsum=0;
        int rsum=0;
        int maxSum=0;
        for(int i=0;i<=k-1;i++){
            lsum+=arr[i];
            maxSum=lsum;
        }
        int rindex=arr.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=arr[i];
            rsum+=arr[rindex];
            rindex--;
            maxSum=Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
}
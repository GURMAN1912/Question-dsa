public class Ones {
    public static void main(String[] args) {
        Ones ob=new Ones();
        int [] arr={1,1,1,0,0,0,1,1,1,1,0};
        System.err.println(ob.maxConsecutiveOne(arr,2));
    }
    public int maxConsecutiveOne(int [] arr,int k){
        int l=0;
        int r=0;
        int z=0;
        int maxl=0;
        while (r<arr.length) {
            if(arr[r]==0){
                z++;
            }       
            if(z>k){
                if(arr[l]==0){
                    z--;
                }
                l++;
            }
            if(z<=k){
                int len=r-l+1;
                maxl=Math.max(maxl, len);
            }
            r++;
        }
        return maxl;

    }
}
